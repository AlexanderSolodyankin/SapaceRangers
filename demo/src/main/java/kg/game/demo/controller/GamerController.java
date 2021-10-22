package kg.game.demo.controller;

import kg.game.demo.entity.Gamer;
import kg.game.demo.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/draft/gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    @GetMapping
    public List<Gamer> getAll() {
        return gamerService.getAll();
    }

    @GetMapping("/{id}")
    public Gamer getById(@PathVariable Long id) {
        return gamerService.getById(id);
    }

    @PostMapping("/save")
    public Gamer saveGamer(@RequestBody Gamer gamer) {
        System.out.println(gamer);
        return gamerService.saveGamer(gamer);
    }

    @PutMapping
    public Gamer updateGamer(@RequestBody Gamer gamer) {
        return gamerService.saveGamer(gamer);
    }

    @DeleteMapping("/{id}")
    public Gamer deleteGamer(@PathVariable Long id) {
        return gamerService.deleteById(id);
    }
}
