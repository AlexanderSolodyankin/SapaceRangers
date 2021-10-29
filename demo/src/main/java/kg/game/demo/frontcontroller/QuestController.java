package kg.game.demo.frontcontroller;


import kg.game.demo.entity.Quest;
import kg.game.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String startQuest( @RequestParam String action,  Model model){
        int time ;
       List<String> mans = new ArrayList<>();
        if(action.equals("Start")){
            time = 18;
            model.addAttribute("discript","Перед вами находится река и на ней лодка в которую\n" +
                    "помещается два человека. Вам нужно переместить четырех человек на жругой берег за отведенное время\n" +
                    "в лодку помещается 2 человека. Время с которым плывет лодка отнимается от наибольшего человека.\n" +
                    "Чук самый ловкий и сильный среди всех по этому он плывет 1 час.\n" +
                    "Ахилес среднего тело сложения и не обделен здоровьем по этому он может плыть 2 часа\n" +
                    "Балл хилый и слабый из за чего он плывет 5 часов\n" +
                    "Грогу самый толстый в группе и плывет 10 часов.\n" +
                    "переправьте всех путников за отведенное время на это вам дается " + time + " часов." +
                    "Выберите того кого вы посадите в ложку первым.");
            model.addAttribute("action", "right1");
            mans.add("Чук");
            mans.add("Ахилес");
            mans.add("Балл");
            mans.add("Грогу");
            model.addAttribute("mans", mans);
            model.addAttribute("time", time);
        }
        return "questrun";
    }
    @GetMapping("/quests/quest/questrun")
    public String questRun(
            @RequestParam int time,
            @RequestParam String mans,
            @RequestParam String action,
            @RequestParam String check,
            Model model){
        System.out.println("Получено время: " + time);
        System.out.println("Получен лист людей: " + mans);
        System.out.println("Получена активность : " + action);
        System.out.println("Получен выбор : " + check);

        return "questrun";
    }
}
