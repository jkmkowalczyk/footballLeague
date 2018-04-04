package application.controller;


import application.dto.Player;
import application.dto.Team;
import application.service.PlayerService;
import application.service.PointsService;
import application.service.TeamService;
import application.utils.PlayerValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;
    private final PointsService pointsService;
    private final TeamService teamService;
    private final PlayerValidator playerValidator;

    public PlayerController(PlayerService playerService, PointsService pointsService, TeamService teamService, PlayerValidator playerValidator) {
        this.playerService = playerService;
        this.pointsService = pointsService;
        this.teamService = teamService;
        this.playerValidator = playerValidator;
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
    public String add(@RequestParam String name, @RequestParam String surname
            , @RequestParam String number, @RequestParam String team
            , @RequestParam String rate, Model model) {

        List<String> errors = playerValidator.validate(name, surname, number, team, rate);
        if (errors.isEmpty()) {
            playerService.save(new Player(name, surname, Integer.valueOf(number), new Team(team), new BigDecimal(rate).setScale(1, BigDecimal.ROUND_UP)));
            return "redirect:/player/display";
        }
        model.addAttribute("errors", errors);
        return display(model);

    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam String name, @RequestParam String surname, @RequestParam Integer number, @RequestParam String team, @RequestParam String rate) {
        playerService.save(new Player(id, name, surname, number, new Team(team), new BigDecimal(rate)));
        return "redirect:/player/display";
    }

}
