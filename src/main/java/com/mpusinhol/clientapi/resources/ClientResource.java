package com.mpusinhol.clientapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mpusinhol.clientapi.domain.Client;
import com.mpusinhol.clientapi.dto.ClientDto;
import com.mpusinhol.clientapi.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClientDto>> findAll(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		System.out.print(ip);
		List<Client> clients = clientService.findAll();
		List<ClientDto> clientDtos = clients.stream().map(
				client -> new ClientDto(client)
			).collect(Collectors.toList());

		return ResponseEntity.ok().body(clientDtos);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(new ClientDto(client));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClientDto clientDto, HttpServletRequest request) {
		Client newClient = clientService.insert(clientDto.convertToClient(), request.getRemoteAddr());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
}
