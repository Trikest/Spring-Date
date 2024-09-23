package com.postgre.nuvem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.postgre.nuvem.repository.*;
import  com.postgre.nuvem.model.*;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para salvar um novo cliente
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para buscar todos os clientes
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    // Método para buscar um cliente por ID
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Método para atualizar um cliente existente
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    // Método para excluir um cliente por ID
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}