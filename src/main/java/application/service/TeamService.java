package application.service;

import application.dto.Player;
import application.dto.Points;
import application.dto.Team;
import application.entity.PlayerEntity;
import application.entity.PointsEntity;
import application.entity.TeamEntity;
import application.repository.PlayerRepository;
import application.repository.PointsRepository;
import application.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final PointsRepository pointsRepository;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository, PointsRepository pointsRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.pointsRepository = pointsRepository;
    }

    public void save(Team team) {
        teamRepository.save(toEntity(team));

        if (team.getId() == null) {
            Optional<TeamEntity> optional = teamRepository.findByName(team.getName());
            TeamEntity teamToPoints = optional.get();
            pointsRepository.save(new PointsEntity(teamToPoints, 0, 0, 0, 0, 0));
        }
    }


    public List<Team> findAll() {

        return teamRepository.findAll().stream().map(this::toDto)
                .sorted(Comparator.comparing(Team::getName)).collect(Collectors.toList());
    }


    public Team getById(Integer id) {
        return toDto(teamRepository.findOne(id));
    }

    private Team toDto(TeamEntity teamEntity) {
        List<Player> players = playerRepository.findByTeam(teamEntity).stream().map(i ->
                new Player(i.getId(), i.getName(), i.getSurname(), i.getNumber()
                        , new Team(i.getTeam().getId(), i.getTeam().getName()), i.getRate()))
                .collect(Collectors.toList());
        return new Team(teamEntity.getId(), teamEntity.getName(), players);
    }

    public TeamEntity toEntity(Team team) {
        return new TeamEntity(team.getId(), team.getName());
    }

    public void delete(Team team) {
        teamRepository.delete(toEntity(team));
    }
}
