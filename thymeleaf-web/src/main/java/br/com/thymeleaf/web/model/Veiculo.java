package br.com.thymeleaf.web.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="veiculo")
public class Veiculo {
 @Id @Column(nullable=false, unique=true) private String placa; private String modelo; private String marca; private Integer anoModelo; private Integer anoFabricacao; private String cor; private Double preco;
 public String getPlaca() { return placa; } public void setPlaca(String placa) { this.placa=placa; } public String getModelo() { return modelo; } public void setModelo(String modelo) { this.modelo=modelo; } public String getMarca() { return marca; } public void setMarca(String marca) { this.marca=marca; } public Integer getAnoModelo() { return anoModelo; } public void setAnoModelo(Integer anoModelo) { this.anoModelo=anoModelo; } public Integer getAnoFabricacao() { return anoFabricacao; } public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao=anoFabricacao; } public String getCor() { return cor; } public void setCor(String cor) { this.cor=cor; } public Double getPreco() { return preco; } public void setPreco(Double preco) { this.preco=preco; }
}
