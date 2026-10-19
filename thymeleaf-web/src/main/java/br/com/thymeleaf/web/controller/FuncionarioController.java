package br.com.thymeleaf.web.controller;
import br.com.thymeleaf.web.model.Funcionario;
import br.com.thymeleaf.web.repository.FuncionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller @RequestMapping("/funcionarios")
public class FuncionarioController {
 private final FuncionarioRepository repo;
 public FuncionarioController(FuncionarioRepository repo) { this.repo=repo; }
 @GetMapping public String listar(Model m) { m.addAttribute("itens",repo.findAll()); m.addAttribute("item",new Funcionario()); m.addAttribute("titulo","Funcionários"); m.addAttribute("modulo","funcionarios"); return "lista"; }
 @PostMapping("/salvar") public String salvar(@ModelAttribute("item") Funcionario item,RedirectAttributes ra) { repo.save(item); ra.addFlashAttribute("mensagem","Registro salvo com sucesso."); return "redirect:/funcionarios"; }
 @GetMapping("/editar/{id}") public String editar(@PathVariable String id,Model m,RedirectAttributes ra) { var item=repo.findById(id); if(item.isEmpty()) { ra.addFlashAttribute("mensagem","Registro não encontrado."); return "redirect:/funcionarios"; } m.addAttribute("itens",repo.findAll()); m.addAttribute("item",item.get()); m.addAttribute("titulo","Funcionários"); m.addAttribute("modulo","funcionarios"); return "lista"; }
 @PostMapping("/excluir/{id}") public String excluir(@PathVariable String id,RedirectAttributes ra) { if(repo.existsById(id)) repo.deleteById(id); ra.addFlashAttribute("mensagem","Registro excluído."); return "redirect:/funcionarios"; }
}
