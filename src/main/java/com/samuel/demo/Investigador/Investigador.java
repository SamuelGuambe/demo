package com.samuel.demo.Investigador;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Investigador {
    @Id
    @SequenceGenerator(
            name = "investigador_sequence",
            sequenceName = "investigador_sequencia",
            allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "investigador_sequencia"
    )
    private Long id;
    private String nome;
    private String email;
    private LocalDate data;
    @Transient
    private Integer ano;

    public Investigador() {
    }

    public Investigador(Long id,
                        String nome,
                        String email,
                        LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.data = data;
    }

    public Investigador(String nome,
                        String email,
                        LocalDate data) {
        this.nome = nome;
        this.email = email;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getAno() {
        return Period.between(this.data, LocalDate.now()).getYears();
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Investigador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", data=" + data +
                ", ano=" + ano +
                '}';
    }
}

