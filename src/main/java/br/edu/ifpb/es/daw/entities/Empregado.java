package br.edu.ifpb.es.daw.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "EMPREGADO", indexes = @Index(name="ix_empregado_cpf", columnList = "CPF"))
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Column(name = "SOBRENOME")
    private String sobrenome;

    @NotNull
    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @NotNull
    @Column(name = "DATA_DE_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "ENDEREÇO")
    private String endereco;

    @Column(name = "SEXO")
    private Character sexo;

    @Column(name = "SALARIO")
    private BigDecimal salario;

    @Column(name = "NDEPENDENTES")
    private Integer nDepedentes;

    public Empregado() {}

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Integer getNdepedentes() {
        return nDepedentes;
    }

    public void setNdepedentes(Integer ndepedentes) {
        this.nDepedentes = ndepedentes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Empregado)) return false;
        Empregado empregado = (Empregado) obj;
        return Objects.equals(cpf, empregado.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id + "Nome: " + nome +
                "sobrenome: " + sobrenome + "CPF: " + cpf
                + "Data de Nascimento: " + dataNascimento +
                "Endereço: " + endereco + "Sexo: " + sexo +
                "Salário: " + salario + "Ndepedentes: " + nDepedentes;
    }
}