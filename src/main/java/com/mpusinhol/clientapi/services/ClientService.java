package com.mpusinhol.clientapi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpusinhol.clientapi.domain.Client;
import com.mpusinhol.clientapi.domain.Location;
import com.mpusinhol.clientapi.repository.ClientRepository;
import com.mpusinhol.clientapi.services.exception.FetchLocationErrorException;
import com.mpusinhol.clientapi.services.exception.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private LocationService locationService;
	
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		clientRepository.findAll().forEach(clients::add);
		
		return clients;
	}
	
	public Client findById(Long id) {
		return clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Client not found"));
	}
	
	public Client insert(Client client, String ip) {
		try {
			Location location = locationService.FindLocationByIp(ip);
			System.out.print(location);
		} catch (RuntimeException exception) {
			throw new FetchLocationErrorException(exception.getMessage());
		} catch (IOException exception) {
			throw new FetchLocationErrorException(exception.getMessage());
		}
		
		return clientRepository.save(client);
	}
}