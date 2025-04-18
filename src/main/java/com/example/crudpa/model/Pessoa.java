package com.example.crudpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    // getters
    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public Servico getServico() { return servico; }

    // setters

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setServico(Servico servico) { this.servico = servico; }

}
