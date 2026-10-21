package br.com.thymeleaf.web.repository;
import br.com.thymeleaf.web.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServicoRepository extends JpaRepository<Servico,Long> {}
