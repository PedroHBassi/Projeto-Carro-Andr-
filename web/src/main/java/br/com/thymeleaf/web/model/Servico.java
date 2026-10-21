package br.com.thymeleaf.web.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="servico")
public class Servico {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private String descricao; private LocalDate dtCadastro;
 public Long getId() { return id; } public void setId(Long id) { this.id=id; } public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao=descricao; } public LocalDate getDtCadastro() { return dtCadastro; } public void setDtCadastro(LocalDate dtCadastro) { this.dtCadastro=dtCadastro; }
}
