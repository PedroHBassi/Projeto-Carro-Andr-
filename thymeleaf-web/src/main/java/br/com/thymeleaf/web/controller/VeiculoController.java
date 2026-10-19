package br.com.thymeleaf.web.controller;
import br.com.thymeleaf.web.model.Veiculo;
import br.com.thymeleaf.web.repository.VeiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/veiculos")
public class VeiculoController {
 private final VeiculoRepository repo;
 public VeiculoController(VeiculoRepository repo) { this.repo=repo; }
 @GetMapping public String listar(Model m) { m.addAttribute("itens",repo.findAll()); m.addAttribute("item",new Veiculo()); m.addAttribute("titulo","Veículos"); m.addAttribute("modulo","veiculos"); return "lista"; }
 @PostMapping("/salvar") public String salvar(@ModelAttribute("item") Veiculo item,RedirectAttributes ra) { repo.save(item); ra.addFlashAttribute("mensagem","Registro salvo com sucesso."); return "redirect:/veiculos"; }
 @GetMapping("/editar/{id}") public String editar(@PathVariable String id,Model m,RedirectAttributes ra) { var item=repo.findById(id); if(item.isEmpty()) { ra.addFlashAttribute("mensagem","Registro não encontrado."); return "redirect:/veiculos"; } m.addAttribute("itens",repo.findAll()); m.addAttribute("item",item.get()); m.addAttribute("titulo","Veículos"); m.addAttribute("modulo","veiculos"); return "lista"; }
 @PostMapping("/excluir/{id}") public String excluir(@PathVariable String id,RedirectAttributes ra) { if(repo.existsById(id)) repo.deleteById(id); ra.addFlashAttribute("mensagem","Registro excluído."); return "redirect:/veiculos"; }
}
