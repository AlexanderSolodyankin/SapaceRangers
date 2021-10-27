package kg.game.demo.frontcontroller;


import kg.game.demo.entity.Quest;
import kg.game.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller("/quests")
public class QuestController {
    @Autowired
    private QuestRepository questRepository;

    @GetMapping("/quests")
    public String menu(Model model){
    List<Quest> quests = new ArrayList<>();
    quests.add(Quest.builder().questName("Лодка").build());
    quests.add(Quest.builder().questName("Тюрьма").build());

        model.addAttribute("quests", quests);
        return "quests";
    }
}
