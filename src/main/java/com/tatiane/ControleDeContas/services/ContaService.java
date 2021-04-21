package com.tatiane.ControleDeContas.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tatiane.ControleDeContas.DTO.ContaDTO;
import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.MovimentoConta;
import com.tatiane.ControleDeContas.entities.Pessoa;
import com.tatiane.ControleDeContas.entities.enums.StatusConta;
import com.tatiane.ControleDeContas.entities.enums.TipoMovimentoConta;
import com.tatiane.ControleDeContas.repositories.ContaRepository;
import com.tatiane.ControleDeContas.repositories.MovimentoContaRepository;
import com.tatiane.ControleDeContas.repositories.PessoaRepository;
import com.tatianeanjos.services.exceptions.ObjectNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private MovimentoContaRepository movimentoContaRepository;

	@Autowired
	private MovimentoContaService mcv;

	private Double valorMaximoPF = 500.00;
	private Double valorMaximoPJ = 2000.00;

	public boolean isValorValido(Conta conta, Double valor) {
		if ((conta != null && valor > 0.0 && ((conta.getPessoa().getTipo_pessoa().equals("F") && valor <= valorMaximoPF)
				|| (conta.getPessoa().getTipo_pessoa().equals("J") && valor <= valorMaximoPJ)))) {
			return true;
		} else {
			return false;
		}
	}

	public Conta findById(Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		return conta.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada!"));
	}

	@Transactional
	public ContaDTO insertConta(ContaDTO dto) {
		Conta c = new Conta();
		c.setNome_conta(dto.getNome_conta());
		c.setData_hora(Instant.now());
		c.setSaldo(0.0);
		Pessoa pessoa = pessoaRepository.getOne(dto.getId_pessoa());
		c.setPessoa(pessoa);
		c.setStatusConta(StatusConta.ATIVA);

		c = contaRepository.save(c);
		return new ContaDTO(c);
	}

	@Transactional
	public String insertSaldo(Double valor, Long id, String descricao) {
		Conta c = findById(id);
		if (c.getStatusConta() == StatusConta.ATIVA){
			if (isValorValido(c, valor))  {
				c.setSaldo(c.getSaldo() + valor);
				contaRepository.save(c);
				MovimentoConta mc = mcv.insertMovConta(TipoMovimentoConta.DEPOSITO, descricao, c, valor);
				movimentoContaRepository.save(mc);
				return "Sucesso!";
			} else {
				return "Ops! Valor não permitido para esse tipo de conta";
			}
		} else {
			return "Esta conta está bloqueada!";
		}
	}

	@Transactional
	public String realizarTranferencia(Long id_origem, Long id_destino, Double valor, String descricao) {
		Conta conta_origem = findById(id_origem);
		Conta conta_destino = findById(id_destino);

		if (isValorValido(conta_destino, valor) && conta_origem.getStatusConta() == StatusConta.ATIVA
				&& conta_destino.getStatusConta() == StatusConta.ATIVA) {
			if (conta_origem.getSaldo() >= valor) {
				conta_origem.setSaldo(conta_origem.getSaldo() - (valor));
				MovimentoConta mc = mcv.insertMovConta(TipoMovimentoConta.TRANSFERENCIA, descricao, conta_origem,
						valor);
				conta_destino.setSaldo(conta_destino.getSaldo() + valor);
				MovimentoConta mc1 = mcv.insertMovConta(TipoMovimentoConta.DEPOSITO, descricao, conta_destino, valor);
				movimentoContaRepository.save(mc);
				movimentoContaRepository.save(mc1);
				return "Sucesso!";
			} else {
				return "Saldo induficiente para a transferência!";
			}
		} else {
			return "Ops! Verifique se as contas estão ativas ou o valor é válido!";
		}
	}

	@Transactional
	public Conta consultaSaldo(Long id) {
		Conta c = findById(id);
		return c;
	}

	@Transactional
	public ContaDTO alteraStatusConta(Long id_conta, StatusConta statusConta) {
		Conta c = findById(id_conta);
		c.setStatusConta(statusConta);
		contaRepository.save(c);
		return new ContaDTO(c);
	}

}