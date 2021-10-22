package kg.game.demo.frontcontroller;

import kg.game.demo.entity.Gamer;
import kg.game.demo.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/gamer")
public class GamerController{

    @Autowired
    private GamerRepository gamerRepository;

    @GetMapping("/gamer")
    public String getAllGamers(Model model){
        Iterable<Gamer> gamers = gamerRepository.findAll();
        model.addAttribute("gamers", gamers);
        return "gamer";
    }
}
