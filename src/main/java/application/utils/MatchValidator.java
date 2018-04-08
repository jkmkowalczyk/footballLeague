package application.utils;

import application.dto.Team;
import application.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchValidator {
    private final TeamService teamService;

    public MatchValidator(TeamService teamService) {
        this.teamService = teamService;
    }

    public List<String> validate() {
        List<Team> teams = teamService.findAll();
        List<String> errors = new ArrayList<>();
        if (teams.size() < 2) {
            errors.add("There are less than two teams");
        }
        return errors;
    }
}
