package kg.game.demo.service;

import kg.game.demo.entity.Gamer;

import java.util.List;

public interface GamerService {
    List<Gamer> getAll();
    Gamer getById(Long id);
    Gamer saveGamer(Gamer gamer);
    Gamer deleteById(Long id);
}
