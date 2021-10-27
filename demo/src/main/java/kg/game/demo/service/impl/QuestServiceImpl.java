package kg.game.demo.service.impl;

import kg.game.demo.entity.Quest;
import kg.game.demo.repository.QuestRepository;
import kg.game.demo.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private QuestRepository questRepository;

    @Override
    public List<Quest> getAll() {
        return questRepository.findAll();
    }

    @Override
    public Quest getById(Long id) {
        return questRepository.findById(id).orElse(null);
    }

    @Override
    public Quest saveGamer(Quest quest) {
        return questRepository.save(quest);
    }

    @Override
    public Quest deleteById(Long id) {
        Quest questForDelete = getById(id);
        questRepository.delete(questForDelete);
        return questForDelete;
    }
}
