package application.service;

import application.dto.Player;
import application.dto.Team;
import application.entity.PlayerEntity;
import application.entity.TeamEntity;
import application.repository.PlayerRepository;
import application.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final TeamService teamService;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }

    public List<Player> findAll() {
        return toDto(playerRepository.findAll());
    }

    public Player getById(Integer id) {
        return toDto(playerRepository.findOne(id));
    }

    public void save(Player player) {
        playerRepository.save(toEntity(player));
    }

    public void delete(Player player) {
        playerRepository.delete(toEntity(player));
    }

    public PlayerEntity toEntity(Player player) {

        Optional<TeamEntity> teamEntity = teamRepository.findByName(player.getTeam().getName());

        if (!teamEntity.isPresent()) {
            teamService.save(new Team(player.getTeam().getName()));
        }
        teamEntity = teamRepository.findByName(player.getTeam().getName());

        return new PlayerEntity(player.getId()
                , player.getName()
                , player.getSurname()
                , player.getNumber()
                , teamEntity.get()
                , player.getRate());
    }

    public Player toDto(PlayerEntity playerEntity) {
        return new Player(playerEntity.getId()
                , playerEntity.getName()
                , playerEntity.getSurname()
                , playerEntity.getNumber()
                , new Team(playerEntity.getTeam().getId(), playerEntity.getTeam().getName())
                , playerEntity.getRate());
    }

    public List<Player> toDto(List<PlayerEntity> playerEntities) {
        return playerEntities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Player> playersByTeam(Team team) {
        return toDto(playerRepository.findByTeam(new TeamEntity(team.getId(), team.getName())));
    }

}
