package br.com.thymeleaf.web.controller;
import br.com.thymeleaf.web.model.Servico;
import br.com.thymeleaf.web.repository.ServicoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/servicos")
public class ServicoController {
 private final ServicoRepository repo;
 public ServicoController(ServicoRepository repo) { this.repo=repo; }
 @GetMapping public String listar(Model m) { m.addAttribute("itens",repo.findAll()); m.addAttribute("item",new Servico()); m.addAttribute("titulo","Serviços"); m.addAttribute("modulo","servicos"); return "lista"; }
 @PostMapping("/salvar") public String salvar(@ModelAttribute("item") Servico item,RedirectAttributes ra) { repo.save(item); ra.addFlashAttribute("mensagem","Registro salvo com sucesso."); return "redirect:/servicos"; }
 @GetMapping("/editar/{id}") public String editar(@PathVariable Long id,Model m,RedirectAttributes ra) { var item=repo.findById(id); if(item.isEmpty()) { ra.addFlashAttribute("mensagem","Registro não encontrado."); return "redirect:/servicos"; } m.addAttribute("itens",repo.findAll()); m.addAttribute("item",item.get()); m.addAttribute("titulo","Serviços"); m.addAttribute("modulo","servicos"); return "lista"; }
 @PostMapping("/excluir/{id}") public String excluir(@PathVariable Long id,RedirectAttributes ra) { if(repo.existsById(id)) repo.deleteById(id); ra.addFlashAttribute("mensagem","Registro excluído."); return "redirect:/servicos"; }
}
