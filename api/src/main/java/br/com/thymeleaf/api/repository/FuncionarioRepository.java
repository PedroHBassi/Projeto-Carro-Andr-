package br.com.thymeleaf.api.repository;
import br.com.thymeleaf.api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FuncionarioRepository extends JpaRepository<Funcionario,String> {}
