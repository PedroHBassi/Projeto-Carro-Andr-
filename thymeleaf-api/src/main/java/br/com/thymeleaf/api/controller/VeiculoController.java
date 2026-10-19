package br.com.thymeleaf.api.controller;
import br.com.thymeleaf.api.model.Veiculo;
import br.com.thymeleaf.api.repository.VeiculoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins="*")
public class VeiculoController {
 private final VeiculoRepository repo;
 public VeiculoController(VeiculoRepository repo) { this.repo=repo; }
 @GetMapping public List<Veiculo> listar() { return repo.findAll(); }
 @GetMapping("/{id}") public ResponseEntity<Veiculo> buscar(@PathVariable String id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
 @PostMapping public ResponseEntity<Veiculo> criar(@RequestBody Veiculo item) { return ResponseEntity.ok(repo.save(item)); }
 @PutMapping("/{id}") public ResponseEntity<Veiculo> atualizar(@PathVariable String id,@RequestBody Veiculo item) {
  if(!repo.existsById(id)) return ResponseEntity.notFound().build(); item.setPlaca(id); return ResponseEntity.ok(repo.save(item));
 }
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable String id) { if(!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
