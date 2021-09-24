package br.com.eicon.leonardo.eicon.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.leonardo.eicon.dominio.modelo.Cliente;
import br.com.eicon.leonardo.eicon.servico.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Clientes")
@RequestMapping("/clientes")
public class ClienteApi {

	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value="Pesquisar Clientes", tags="Clientes")
	@GetMapping(produces = { "application/json" })
	public List<Cliente> pesquisaPorParametros(Long numeroControle, LocalDate dataCadastro) {
		return clienteService.pesquisaPorParametros(numeroControle, dataCadastro);
	}
	
	
	@ApiOperation(value="Incluir Clientes", tags="Clientes")
	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<String> incluir(@RequestBody Cliente agendamento) {
		clienteService.incluir(agendamento);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
