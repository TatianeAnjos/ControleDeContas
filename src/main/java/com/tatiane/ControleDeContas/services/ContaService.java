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
import com.tatiane.ControleDeContas.repositories.ContaRepository;
import com.tatiane.ControleDeContas.repositories.MovimentoContaRepository;
import com.tatiane.ControleDeContas.repositories.PessoaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private MovimentoContaRepository movimentoContaRepository;

	private Double valorMaximoPF = 500.00;
	private Double valorMaximoPJ = 2000.00;

	public Conta findById(Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		return conta.get();
	}

	@Transactional
	public ContaDTO insertConta(ContaDTO dto) {
		Conta c = new Conta();
		c.setNome_conta(dto.getNome_conta());
		c.setData_hora(Instant.now());
		c.setSaldo(0.0);
		Pessoa pessoa = pessoaRepository.getOne(dto.getId_pessoa());
		c.setPessoa(pessoa);

		c = contaRepository.save(c);
		return new ContaDTO(c);
	}

	@Transactional
	public Conta insertSaldo(Double valor, Long id, String descricao) {
		Conta c = findById(id);
		if ((c != null && valor > 0.0 && ((c.getPessoa().getTipo_pessoa().equals("F") && valor <= valorMaximoPF)
				|| (c.getPessoa().getTipo_pessoa().equals("J") && valor <= valorMaximoPJ)))) {

			c.setSaldo(c.getSaldo() + valor);
			contaRepository.save(c);

			MovimentoConta mv = new MovimentoConta();
			mv.setData_hora(Instant.now());
			mv.setOperacao("Deposito");
			mv.setDescricao(descricao);
			mv.setConta(c);
			movimentoContaRepository.save(mv);

			return c;
		} else {
			return null;
		}

	}

}
