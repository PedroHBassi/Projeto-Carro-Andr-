package br.com.thymeleaf.api.repository;
import br.com.thymeleaf.api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServicoRepository extends JpaRepository<Servico,Long> {}
