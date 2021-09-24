package br.com.eicon.leonardo.eicon.servico;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.eicon.leonardo.eicon.dominio.modelo.Cliente;
import br.com.eicon.leonardo.eicon.dominio.repositorio.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

	@InjectMocks
	ClienteService clienteService;
	
	@Spy
	ClienteRepository clienteRepository;
	
	@Test
	void testCliente() {
		Cliente cliente = new Cliente();
		LocalDate data = LocalDate.now();
		cliente.setDataCadastro(data);
		cliente.setNome("Teste");
		cliente.setNumeroControle(22L);
		cliente.setQuantidade(33L);
		cliente.setValorUnitario(new BigDecimal(55.2));
		clienteService.incluir(cliente);
		List<Cliente> clientes = clienteService.pesquisaPorParametros(22L, data);
		assertThat(clientes.size() > 0);
	}
}
