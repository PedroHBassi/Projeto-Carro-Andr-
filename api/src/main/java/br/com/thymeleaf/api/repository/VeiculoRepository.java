package br.com.thymeleaf.api.repository;
import br.com.thymeleaf.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VeiculoRepository extends JpaRepository<Veiculo,String> {}
