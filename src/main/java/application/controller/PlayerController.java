package application.controller;


import application.dto.Player;
import application.dto.Team;
import application.service.PlayerService;
import application.service.PointsService;
import application.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;
    private final PointsService pointsService;
    private final TeamService teamService;

    public PlayerController(PlayerService playerService, PointsService pointsService, TeamService teamService) {
        this.playerService = playerService;
        this.pointsService = pointsService;
        this.teamService = teamService;
    }

    @GetMapping("/display")
    public String display(Model model) {
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("points", pointsService.findAll());
        model.addAttribute("teams", teamService.findAll());
        return "player/display";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        playerService.delete(playerService.getById(id));
        return "redirect:/player/display";
    }


    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam String surname, @RequestParam Integer number, @RequestParam String team) {
        playerService.save(new Player(name, surname, number, new Team(team)));
        return "redirect:/player/display";
    }

    @GetMapping("/update")
    public String viewPlayer(@RequestParam Integer id, Model model) {
        model.addAttribute("player", playerService.getById(id));
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("points", pointsService.findAll());
        return "player/update";
    }

}
