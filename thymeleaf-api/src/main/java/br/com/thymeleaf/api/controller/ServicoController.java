package br.com.thymeleaf.api.controller;
import br.com.thymeleaf.api.model.Servico;
import br.com.thymeleaf.api.repository.ServicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins="*")
public class ServicoController {
 private final ServicoRepository repo;
 public ServicoController(ServicoRepository repo) { this.repo=repo; }
 @GetMapping public List<Servico> listar() { return repo.findAll(); }
 @GetMapping("/{id}") public ResponseEntity<Servico> buscar(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
 @PostMapping public ResponseEntity<Servico> criar(@RequestBody Servico item) { return ResponseEntity.ok(repo.save(item)); }
 @PutMapping("/{id}") public ResponseEntity<Servico> atualizar(@PathVariable Long id,@RequestBody Servico item) {
  if(!repo.existsById(id)) return ResponseEntity.notFound().build(); item.setId(id); return ResponseEntity.ok(repo.save(item));
 }
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id) { if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
