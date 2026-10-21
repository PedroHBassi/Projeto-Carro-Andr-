package br.com.thymeleaf.api.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="funcionario")
public class Funcionario {
 @Id @Column(nullable=false, unique=true) private String cpf; private String nome; private Double salario;
 public String getCpf() { return cpf; } public void setCpf(String cpf) { this.cpf=cpf; } public String getNome() { return nome; } public void setNome(String nome) { this.nome=nome; } public Double getSalario() { return salario; } public void setSalario(Double salario) { this.salario=salario; }
}
