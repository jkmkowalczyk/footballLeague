package application.controller;


import application.dto.Player;
import application.dto.Team;
import application.service.PlayerService;
import application.service.PointsService;
import application.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam String name, @RequestParam String surname, @RequestParam Integer number, @RequestParam String team) {
        playerService.save(new Player(id, name, surname, number, new Team(team)));
        return "redirect:/player/display";
    }

}
