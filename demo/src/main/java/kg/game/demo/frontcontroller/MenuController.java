package kg.game.demo.frontcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class MenuController {
    @GetMapping("/")
    public String menu(Model model){
        model.addAttribute("menu","Главное меню");
        return "menu";
    }
}
