package kg.game.demo.frontcontroller;

import kg.game.demo.entity.Gamer;
import kg.game.demo.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/gamer/newGamer")
    public String newGamer(Model model){
        return "newGamer";
    }

    @PostMapping("/gamer/newGamer")
    public String saveGamer(@RequestParam String fullName,  Model model){ // Принимает кастомные параметры и их может быть несколько
        Gamer gamer = new Gamer().builder().fullName(fullName).build();
        gamerRepository.save(gamer); // добовляет созданный класс в БД для логики игры его вызывать не надо
        return "redirect:/gamer";
    }
}
