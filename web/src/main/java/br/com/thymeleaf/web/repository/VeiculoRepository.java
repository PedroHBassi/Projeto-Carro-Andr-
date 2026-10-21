package br.com.thymeleaf.web.repository;
import br.com.thymeleaf.web.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VeiculoRepository extends JpaRepository<Veiculo,String> {}
