package br.com.thymeleaf.web.repository;
import br.com.thymeleaf.web.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FuncionarioRepository extends JpaRepository<Funcionario,String> {}
