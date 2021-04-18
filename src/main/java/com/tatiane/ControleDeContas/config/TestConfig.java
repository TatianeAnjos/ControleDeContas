package com.tatiane.ControleDeContas.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.MovimentoConta;
import com.tatiane.ControleDeContas.entities.PessoaFisica;
import com.tatiane.ControleDeContas.entities.PessoaJuridica;
import com.tatiane.ControleDeContas.repositories.ContaRepository;
import com.tatiane.ControleDeContas.repositories.MovimentoContaRepository;
import com.tatiane.ControleDeContas.repositories.PessoaFisicaRepository;
import com.tatiane.ControleDeContas.repositories.PessoaJuridicaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MovimentoContaRepository movimentoConta;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Date data = sdf.parse("23/11/2015");


		PessoaFisica pf1 = new PessoaFisica(null,"Maria Carvalho", "12345678910","F", data);
		PessoaJuridica pj1 = new PessoaJuridica(null,"MAVariedades","21125123000110","J","MAVariedadesLTDA");
		Conta conta1 = new Conta(null, "conta1", Instant.now(), 0.0, pj1);
		Conta conta2 = new Conta(null, "conta2", Instant.now(), 0.0, pf1);

		MovimentoConta mc = new MovimentoConta(null,"Deposito", Instant.now(), "Pagamento de Mercadoria",conta1);
		
		pessoaFisicaRepository.saveAll(Arrays.asList(pf1));
		pessoaJuridicaRepository.saveAll(Arrays.asList(pj1));
		contaRepository.saveAll(Arrays.asList(conta1, conta2));
		movimentoConta.saveAll(Arrays.asList(mc));

	}
	
}