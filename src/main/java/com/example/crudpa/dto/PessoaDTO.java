package com.example.crudpa.dto;

public class PessoaDTO {
    private Long id;
    private String nome;

    private String cpf;
    private Long servicoId;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }
    public void setNome(String nome) { this.nome = nome; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }

    public void setServicoNome(String descricao) {
    }
}
