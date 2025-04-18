package com.example.crudpa.controller;

import com.example.crudpa.dto.ServicoDTO;
import com.example.crudpa.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping
    public ServicoDTO create(@RequestBody ServicoDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ServicoDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ServicoDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ServicoDTO edit(@PathVariable Long id, @RequestBody ServicoDTO dto) {
        return service.edit(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
