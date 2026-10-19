package br.com.thymeleaf.web.controller;
import br.com.thymeleaf.web.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller public class DashboardController {
 private final FuncionarioRepository f; private final ContasDoMesRepository c; private final VeiculoRepository v; private final ServicoRepository s;
 public DashboardController(FuncionarioRepository f,ContasDoMesRepository c,VeiculoRepository v,ServicoRepository s){this.f=f;this.c=c;this.v=v;this.s=s;}
 @GetMapping("/") public String inicio(Model m){m.addAttribute("funcionarios",f.count());m.addAttribute("contas",c.count());m.addAttribute("veiculos",v.count());m.addAttribute("servicos",s.count());return "index";}
}
