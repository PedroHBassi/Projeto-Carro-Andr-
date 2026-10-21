package br.com.thymeleaf.api.controller;
import br.com.thymeleaf.api.model.Funcionario;
import br.com.thymeleaf.api.repository.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins="*")
public class FuncionarioController {
 private final FuncionarioRepository repo;
 public FuncionarioController(FuncionarioRepository repo) { this.repo=repo; }
 @GetMapping public List<Funcionario> listar() { return repo.findAll(); }
 @GetMapping("/{id}") public ResponseEntity<Funcionario> buscar(@PathVariable String id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
 @PostMapping public ResponseEntity<Funcionario> criar(@RequestBody Funcionario item) { return ResponseEntity.ok(repo.save(item)); }
 @PutMapping("/{id}") public ResponseEntity<Funcionario> atualizar(@PathVariable String id,@RequestBody Funcionario item) {
  if(!repo.existsById(id)) return ResponseEntity.notFound().build(); item.setCpf(id); return ResponseEntity.ok(repo.save(item));
 }
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable String id) { if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
