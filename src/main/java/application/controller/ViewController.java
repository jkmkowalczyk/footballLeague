package application.controller;

import application.service.PlayerService;
import application.service.PointsService;
import application.service.ScoreService;
import application.utils.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    private final PlayerService playerService;
    private final MatchService matchService;
    private final ScoreService scoreService;
    private final PointsService pointsService;

    public ViewController(PlayerService playerService, MatchService matchService, ScoreService scoreService, PointsService pointsService) {
        this.playerService = playerService;
        this.matchService = matchService;
        this.scoreService = scoreService;
        this.pointsService = pointsService;
    }

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("scores", scoreService.findAll());
        model.addAttribute("points", pointsService.findAll());
        return "index";
    }

    @GetMapping("/play")
    public String play() {
        matchService.play();
        return "redirect:/";
    }
}
