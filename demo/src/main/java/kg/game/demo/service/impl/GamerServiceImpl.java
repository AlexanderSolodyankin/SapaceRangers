package kg.game.demo.service.impl;

import kg.game.demo.entity.Gamer;
import kg.game.demo.repository.GamerRepository;
import kg.game.demo.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GamerServiceImpl implements GamerService {

    @Autowired
    private GamerRepository gamerRepository;
    @Override
    public List<Gamer> getAll() {
        return gamerRepository.findAll();
    }

    @Override
    public Gamer getById(Long id) {
        return gamerRepository.findById(id).orElse(null);
    }

    @Override
    public Gamer saveGamer(Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    @Override
    public Gamer deleteById(Long id) {
        Gamer gamerForDelete = getById(id);
        gamerRepository.delete(gamerForDelete);
        return gamerForDelete;
    }
}
