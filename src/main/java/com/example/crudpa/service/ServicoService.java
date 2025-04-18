package com.example.crudpa.service;

import com.example.crudpa.dto.ServicoDTO;
import com.example.crudpa.model.Servico;
import com.example.crudpa.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public ServicoDTO create(ServicoDTO dto) {
        Servico s = new Servico();
        s.setDescricao(dto.getDescricao());
        Servico salvo = repo.save(s);
        return toDTO(salvo);
    }

    public ServicoDTO getById(Long id) {
        Servico s = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não existe"));
        return toDTO(s);
    }

    public List<ServicoDTO> getAll() {
        return repo.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ServicoDTO edit(Long id, ServicoDTO dto) {
        Servico s = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não existe"));
        s.setDescricao(dto.getDescricao());
        return toDTO(repo.save(s));
    }

    public void delete(Long id) {
        if (!repo.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não existe");
        repo.deleteById(id);
    }

    private ServicoDTO toDTO(Servico s) {
        ServicoDTO dto = new ServicoDTO();
        dto.setId(s.getId());
        dto.setDescricao(s.getDescricao());
        return dto;
    }
}
