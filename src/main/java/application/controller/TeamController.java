package application.controller;


import application.dto.Player;
import application.dto.Team;
import application.service.PlayerService;
import application.service.PointsService;
import application.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;
    private final PlayerService playerService;
    private final PointsService pointsService;

    public TeamController(TeamService teamService, PlayerService playerService, PointsService pointsService) {
        this.teamService = teamService;
        this.playerService = playerService;
        this.pointsService = pointsService;
    }

    @GetMapping("/display")
    public String display(Model model) {
        List<Team> teams = teamService.findAll();
//        for (Team team : teams) {
//            team.setPlayers(playerService.playersByTeam(team));
//        }
        model.addAttribute("teams", teams);
        model.addAttribute("points", pointsService.findAll());
        return "team/display";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        teamService.delete(teamService.getById(id));
        return "redirect:/team/display";
    }


    @PostMapping("/add")
    public String add(@RequestParam String name) {
        teamService.save(new Team(name));
        return "redirect:/team/display";
    }

}
