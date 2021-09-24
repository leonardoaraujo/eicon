package br.com.eicon.leonardo.eicon.servico;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.leonardo.eicon.dominio.modelo.Cliente;
import br.com.eicon.leonardo.eicon.dominio.repositorio.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void incluir(Cliente agendamento) {
		clienteRepository.save(agendamento);
	}
	
	public List<Cliente> pesquisaPorParametros(Long numeroControle, LocalDate dataCadastro) {
		return clienteRepository.pesquisaPorParametros(numeroControle, dataCadastro);
	}
	
	
}
