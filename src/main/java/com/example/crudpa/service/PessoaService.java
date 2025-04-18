package com.example.crudpa.service;

import com.example.crudpa.dto.PessoaDTO;
import com.example.crudpa.model.Pessoa;
import com.example.crudpa.model.Servico;
import com.example.crudpa.repository.PessoaRepository;
import com.example.crudpa.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repo;

    @Autowired
    private ServicoRepository servRepo;

    public PessoaDTO create(PessoaDTO dto) {
        Servico serv = servRepo.findById(dto.getServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço inválido"));
        Pessoa p = new Pessoa();
        p.setNome(dto.getNome());
        p.setCpf(dto.getCpf());
        p.setServico(serv);
        Pessoa salvo = repo.save(p);
        return toDTO(salvo);
    }

    public PessoaDTO getById(Long id) {
        Pessoa p = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não existe"));
        return toDTO(p);
    }

    public List<Pessoa> getAll() {
        return repo.findAll();
    }

    public PessoaDTO edit(Long id, PessoaDTO dto) {
        Pessoa p = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não existe"));
        Servico serv = servRepo.findById(dto.getServicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço inválido"));
        p.setNome(dto.getNome());
        p.setCpf(dto.getCpf());
        p.setServico(serv);
        return toDTO(repo.save(p));
    }

    public void delete(Long id) {
        if (!repo.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não existe");
        repo.deleteById(id);
    }

    private PessoaDTO toDTO(Pessoa p) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setCpf(p.getCpf());
        dto.setServicoId(p.getServico().getId());
        dto.setServicoNome(p.getServico().getDescricao());
        return dto;
    }
}
