package kg.game.demo.frontcontroller;


import kg.game.demo.entity.Quest;
import kg.game.demo.model.QuestBoat;
import kg.game.demo.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("/quests")
public class QuestController {
    @Autowired
    private QuestRepository questRepository;


    @GetMapping("/quests")
    public String menu(Model model) {
        List<Quest> quests = new ArrayList<>();
        quests.add(Quest.builder().questName("Лодка").build());
        quests.add(Quest.builder().questName("Тюрьма").build());
        model.addAttribute("quests", quests);
        return "quests";
    }

    @GetMapping("/quests/quest1")
    public String questGet(@RequestParam String questName, Model model) {
        model.addAttribute("questName", questName);
        if (questName.equals("Лодка")) {
            model.addAttribute("discript",
                    "У экспедиции наших археологов возникла проблема в решении одной головоломки \n" +
                            "на незаселенной плате в системе Бенатрикс был найден храм и для открытия двери нужно решить\n" +
                            "небольшую задачу. Если вы сможете ее решить то вы получите щедрую награду.");
            return "discriptQuest";
        } else return "menu";
    }

    @GetMapping("/quests/quest/start")
    public String startQuest(@RequestParam String action, Model model) {

        List<String> mans = new ArrayList<>();
        if (action.equals("Start")) {
            List<String> right1 = Arrays.asList(new String[]{"Чук", "Ахилес", "Балл", "Грогу"});
            List<String> right2 = List.of(new String[]{"пусто", "пусто"});
            List<String> left = List.of(new String[]{"пусто", "пусто", "пусто", "пусто"});
            List<String> checkList = List.of(new String[]{"Чук", "Ахилес", "Балл", "Грогу"});
            int time = 18;
            String check = "";
            String actions = "right1";
            String discript = "Перед вами находится река и на ней лодка в которую\n" +
                    "помещается два человека. Вам нужно переместить четырех человек на жругой берег за отведенное время\n" +
                    "в лодку помещается 2 человека. Время с которым плывет лодка отнимается от наибольшего человека.\n" +
                    "Чук самый ловкий и сильный среди всех по этому он плывет 1 час.\n" +
                    "Ахилес среднего тело сложения и не обделен здоровьем по этому он может плыть 2 часа\n" +
                    "Балл хилый и слабый из за чего он плывет 5 часов\n" +
                    "Грогу самый толстый в группе и плывет 10 часов.\n" +
                    "переправьте всех путников за отведенное время на это вам дается " + time + " часов." +
                    "Выберите того кого вы посадите в ложку первым.";

            QuestBoat questBoat = QuestBoat.run(right1, right2, left, checkList, time, check, actions, discript);

            model.addAttribute("quest1", questBoat);
//            model.addAttribute("action", "right1");
//            model.addAttribute("mans", mans);
//            model.addAttribute("time", time);
        }
        return "questrun";
    }

    @GetMapping("/quests/quest/questrun")
    public String questRun(
            @RequestParam int time,
            @RequestParam String right1,
            @RequestParam String right2,
            @RequestParam String left,
            @RequestParam String checkList,
            @RequestParam String action,
            @RequestParam String check,
            Model model) {
        QuestBoat questBoat = new QuestBoat();
        List<String> rihgtBeach = List.of(right1.split(","));
        List<String> boat = List.of(right2.split(","));
        List<String> leftBeach = List.of(left.split(","));
        List<String> checkMan = List.of(checkList.split(","));
        int times = time;
        String checkNow = check;
        String discript = "";
        int timeFerst = 0, timeLost = 0;

        if(action.equals("left")){
            rihgtBeach = addElement(rihgtBeach, check);
            leftBeach = getListDeleteObject(leftBeach, check);
            checkMan = rihgtBeach;
            if (check.equals("Чук")) timeFerst = 1;
            if (check.equals("Ахилес")) timeFerst = 2;
            if (check.equals("Балл")) timeFerst = 5;
            if (check.equals("Грогу")) timeFerst = 10;
            times = times - timeFerst;
            boat = new ArrayList<>();
            check="";
            action = "right1";
            discript = "Вы находитесь на правом берегу и вам нужно выбрать того кто первым сядет в лодку " +
                    "Чук самый ловкий и сильный среди всех по этому он плывет 1 час.\n" +
                    "Ахилес среднего тело сложения и не обделен здоровьем по этому он может плыть 2 часа\n" +
                    "Балл хилый и слабый из за чего он плывет 5 часов\n" +
                    "Грогу самый толстый в группе и плывет 10 часов.\n";
        }

        if (action.equals("right2")) {
            if (boat.size() > 2) boat = new ArrayList<>();
            boat = addElement(boat, check);
            rihgtBeach = getListDeleteObject(rihgtBeach, check);
            leftBeach = addElement(leftBeach, check);
            checkMan = leftBeach;
            action = "left";

            if (boat.get(0).equals("Чук")) timeFerst = 1;
            if (boat.get(0).equals("Ахилес")) timeFerst = 2;
            if (boat.get(0).equals("Балл")) timeFerst = 5;
            if (boat.get(0).equals("Грогу")) timeFerst = 10;
            if (boat.get(1).equals("Чук")) timeLost = 1;
            if (boat.get(1).equals("Ахилес")) timeLost = 2;
            if (boat.get(1).equals("Балл")) timeLost = 5;
            if (boat.get(1).equals("Грогу")) timeLost = 10;
            if (timeFerst > timeLost) times = times - timeFerst;
            else times = times - timeLost;
             discript = "На левом берегу стоят " + leftBeach + " нужно вернуть лодку обратно." +
                    "у вас осталось " + times + " часов кого вы выберите чтобы вернуть лодку. " +
                    "Чук самый ловкий и сильный среди всех по этому он плывет 1 час.\n" +
                    "Ахилес среднего тело сложения и не обделен здоровьем по этому он может плыть 2 часа\n" +
                    "Балл хилый и слабый из за чего он плывет 5 часов\n" +
                    "Грогу самый толстый в группе и плывет 10 часов.\n";
             if(times > 0 && leftBeach.size() == 4){
                 discript = " ПОЗДРОВЛЯЮ ВЫ РЕШИЛИ ЗАДАЧУ!!!!!!!!!!!!!!!!";
                 return "menu";
             }

        }
        if (action.equals("right1")) {
            boat = addElement(boat, check);
            boat = getListDeleteObject(boat, "пусто");
            rihgtBeach = getListDeleteObject(rihgtBeach, check);
            leftBeach = addElement(leftBeach, check);
            leftBeach = getListDeleteObject(leftBeach, "пусто");
            if (rihgtBeach.size() < 1) rihgtBeach.add("пусто");
            checkMan = getListDeleteObject(checkMan, check);
            action = "right2";
             discript = "Вы находитесь на правом берегу и посадили первого человека в лодку. Теперь вам нужно" +
                    "посадить второго. Кого вы выберите у вас осталось " + times + " часов  " +
                    "Чук самый ловкий и сильный среди всех по этому он плывет 1 час.\n" +
                    "Ахилес среднего тело сложения и не обделен здоровьем по этому он может плыть 2 часа\n" +
                    "Балл хилый и слабый из за чего он плывет 5 часов\n" +
                    "Грогу самый толстый в группе и плывет 10 часов.\n";

        }

        if(times < 0){
            discript = " Вы не смогли переправить людей за заданное время ВЫ ПРОИГРАЛИ!!!!!!!!!!!!!";
            return "menu";
        }
        questBoat = QuestBoat.run(rihgtBeach, boat, leftBeach, checkMan, times, "", action, discript);
        model.addAttribute("quest1", questBoat);
        return "questrun";
    }
    public List<String> getListDeleteObject(List<String> writeList, String write) {
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < writeList.size(); i++) {
            if (!writeList.get(i).equals(write)) arrayList.add(writeList.get(i));
        }
        return arrayList;
    }
    public List<String> addElement(List<String> array, String write) {
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            arrayList.add(array.get(i));
        }
        arrayList.add(write);
        return arrayList;
    }
}
