package kg.game.demo.frontcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/gamer")
public class GamerController{
    @GetMapping("/gamer")
    public String getAllGamers(Model model){
        model.addAttribute("gamer","Меню игрока");
        return "gamer";
    }
}
