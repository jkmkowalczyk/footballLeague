package application.service;

import application.dto.Points;
import application.dto.Team;
import application.entity.TeamEntity;
import application.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final PointsService pointsService;

    public TeamService(TeamRepository teamRepository, PointsService pointsService) {
        this.teamRepository = teamRepository;
        this.pointsService = pointsService;
    }

    public void save(Team team) {
        teamRepository.save(toEntity(team));

        if (team.getId() == null) {
            Optional<TeamEntity> optional = teamRepository.findByName(team.getName());
            Team teamToPoints = toDto(optional.get());
            pointsService.save(new Points(teamToPoints, 0, 0, 0, 0));
        }
    }


    public List<Team> findAll() {
        return teamRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public TeamEntity getById(Integer id) {
        return teamRepository.findOne(id);
    }

    private Team toDto(TeamEntity teamEntity) {
        return new Team(teamEntity.getId(), teamEntity.getName());
    }

    private TeamEntity toEntity(Team team) {
        return new TeamEntity(team.getId(), team.getName());
    }
}