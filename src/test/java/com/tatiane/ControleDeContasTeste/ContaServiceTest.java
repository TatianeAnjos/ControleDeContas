package com.tatiane.ControleDeContasTeste;

import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tatiane.ControleDeContas.DTO.ContaDTO;
import com.tatiane.ControleDeContas.entities.Conta;
import com.tatiane.ControleDeContas.entities.Pessoa;
import com.tatiane.ControleDeContas.entities.enums.StatusConta;
import com.tatiane.ControleDeContas.repositories.ContaRepository;
import com.tatiane.ControleDeContas.repositories.PessoaRepository;
import com.tatiane.ControleDeContas.services.ContaService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = ContaServiceTest.class)
public class ContaServiceTest {


		@Mock
		ContaRepository contaRepository;
		
		@Mock 
		PessoaRepository pessoaRepository;
		
		@InjectMocks
		private ContaService contaService;
				
		@Test
		public void UmaContaDeveSerCriada() {
			
			ContaDTO dto = new ContaDTO();
			dto.setNome_conta("ContaTeste");
			dto.setId_pessoa(1L);
			
			Conta c = new Conta();
			c.setId_conta((long) 3);
			c.setNome_conta("ContaTeste");
			c.setData_hora(Instant.now());
			c.setSaldo(0.0);
			Pessoa pessoa = pessoaRepository.getOne(dto.getId_pessoa());
			c.setPessoa(pessoa);
			c.setStatusConta(StatusConta.ATIVA);
			Conta conta = contaRepository.save(c);
			
			Mockito.when(contaRepository.save(c)).thenReturn(c);
			
			ContaDTO createdDTO = contaService.insertConta(dto);
			
			assertEquals(conta,createdDTO);
			
		}
		@Test
		void bucarContaTest() {
			Conta conta = contaService.findById(1L);
			assertEquals("1",String.valueOf(conta.getId_conta()));
			//assertsEquals((long)1,conta.getId_conta());
		}
	}
