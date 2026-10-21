package br.com.thymeleaf.api.controller;
import br.com.thymeleaf.api.model.ContasDoMes;
import br.com.thymeleaf.api.repository.ContasDoMesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/contas-do-mes")
@CrossOrigin(origins="*")
public class ContasDoMesController {
 private final ContasDoMesRepository repo;
 public ContasDoMesController(ContasDoMesRepository repo) { this.repo=repo; }
 @GetMapping public List<ContasDoMes> listar() { return repo.findAll(); }
 @GetMapping("/{id}") public ResponseEntity<ContasDoMes> buscar(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
 @PostMapping public ResponseEntity<ContasDoMes> criar(@RequestBody ContasDoMes item) { return ResponseEntity.ok(repo.save(item)); }
 @PutMapping("/{id}") public ResponseEntity<ContasDoMes> atualizar(@PathVariable Long id,@RequestBody ContasDoMes item) {
  if(!repo.existsById(id)) return ResponseEntity.notFound().build(); item.setId(id); return ResponseEntity.ok(repo.save(item));
 }
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id) { if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
