package kg.game.demo.frontcontroller;


import kg.game.demo.entity.Quest;
import kg.game.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/quests/quest1")
    public String questGet(@RequestParam String questName, Model model){
        model.addAttribute("questName", questName);
        if(questName.equals("Лодка")) {
            model.addAttribute("discript",
                    "У экспедиции наших археологов возникла проблема в решении одной головоломки \n" +
                    "на незаселенной плате в системе Бенатрикс был найден храм и для открытия двери нужно решить\n" +
                            "небольшую задачу. Если вы сможете ее решить то вы получите щедрую награду.");
            return "discriptQuest";
        }else return "menu";
    }

    @GetMapping("/quests/quest/start")
    public String startQuest(@RequestParam String questName, @RequestParam String action, Model model){
        System.out.println("Получили по квест найм: " + questName);
        System.out.println("Получили по квест старту: " + action);
        return "menu";
    }
}
