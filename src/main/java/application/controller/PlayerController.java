package application.controller;


import application.dto.Player;
import application.dto.Team;
import application.service.PlayerService;
import application.service.PointsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final PointsService pointsService;

    public PlayerController(PlayerService playerService, PointsService pointsService) {
        this.playerService = playerService;
        this.pointsService = pointsService;
    }

    @GetMapping("/player/{id}")
    public String display(@PathVariable Integer id, Model model) {
        model.addAttribute("player", playerService.getById(id));
        return "player/display";
    }


    @PostMapping("/player/delete")
    public String delete(@RequestParam Integer id) {
        playerService.delete(playerService.getById(id));
        return "redirect:/";
    }

    @GetMapping("add")
    public String display(Model model) {
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("points", pointsService.findAll());
        return "player/add";
    }

    @PostMapping("add")
    public String add(@RequestParam String name, @RequestParam String surname, @RequestParam Integer number, @RequestParam String team) {
        playerService.save(new Player(name, surname, number, new Team(team)));
        return "redirect:/";
    }

}
