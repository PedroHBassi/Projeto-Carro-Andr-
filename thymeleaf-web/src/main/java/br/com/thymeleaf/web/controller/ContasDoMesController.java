package br.com.thymeleaf.web.controller;
import br.com.thymeleaf.web.model.ContasDoMes;
import br.com.thymeleaf.web.repository.ContasDoMesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/contas-do-mes")
public class ContasDoMesController {
 private final ContasDoMesRepository repo;
 public ContasDoMesController(ContasDoMesRepository repo) { this.repo=repo; }
 @GetMapping public String listar(Model m) { m.addAttribute("itens",repo.findAll()); m.addAttribute("item",new ContasDoMes()); m.addAttribute("titulo","Contas do mês"); m.addAttribute("modulo","contas-do-mes"); return "lista"; }
 @PostMapping("/salvar") public String salvar(@ModelAttribute("item") ContasDoMes item,RedirectAttributes ra) { repo.save(item); ra.addFlashAttribute("mensagem","Registro salvo com sucesso."); return "redirect:/contas-do-mes"; }
 @GetMapping("/editar/{id}") public String editar(@PathVariable Long id,Model m,RedirectAttributes ra) { var item=repo.findById(id); if(item.isEmpty()) { ra.addFlashAttribute("mensagem","Registro não encontrado."); return "redirect:/contas-do-mes"; } m.addAttribute("itens",repo.findAll()); m.addAttribute("item",item.get()); m.addAttribute("titulo","Contas do mês"); m.addAttribute("modulo","contas-do-mes"); return "lista"; }
 @PostMapping("/excluir/{id}") public String excluir(@PathVariable Long id,RedirectAttributes ra) { if(repo.existsById(id)) repo.deleteById(id); ra.addFlashAttribute("mensagem","Registro excluído."); return "redirect:/contas-do-mes"; }
}
