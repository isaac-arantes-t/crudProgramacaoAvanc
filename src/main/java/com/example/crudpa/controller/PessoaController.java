package com.example.crudpa.controller;

import com.example.crudpa.dto.PessoaDTO;
import com.example.crudpa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.crudpa.model.Pessoa;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public PessoaDTO create(@RequestBody PessoaDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public PessoaDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Pessoa> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PessoaDTO edit(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        return service.edit(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
