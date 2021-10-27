package kg.game.demo.service;

import kg.game.demo.entity.Gamer;
import kg.game.demo.entity.Quest;

import java.util.List;

public interface QuestService {
    List<Quest> getAll();
    Quest getById(Long id);
    Quest saveGamer(Quest quest);
    Quest deleteById(Long id);
}
