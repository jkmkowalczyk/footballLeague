package application.service;

import application.dto.Score;
import application.dto.Team;
import application.entity.ScoreEntity;
import application.entity.TeamEntity;
import application.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public void save(Score score) {
        scoreRepository.save(toEntity(new Score(LocalDateTime.now()
                , score.getHome()
                , score.getAway()
                , score.getHomeGoals()
                , score.getAwayGoals())));
    }


    public List<Score> findAll() {
        List<Score> scores = toDto(scoreRepository.findAll());
        scores.sort(Comparator.comparing(Score::getLocalDateTime).reversed());
        if (scores.size() > 5)
            return scores.subList(0, 5);
        return scores;
    }

    public List<Score> toDto(List<ScoreEntity> scoreEntities) {
        return scoreEntities.stream().map(this::toDto).collect(Collectors.toList());
    }


    public Score toDto(ScoreEntity scoreEntity) {
        return new Score(scoreEntity.getId()
                , scoreEntity.getLocalDateTime().toLocalDateTime()
                , new Team(scoreEntity.getHome().getName())
                , new Team(scoreEntity.getAway().getName())
                , scoreEntity.getHomeGoals()
                , scoreEntity.getAwayGoals());
    }

    public ScoreEntity toEntity(Score score) {

        return new ScoreEntity(score.getId()
                , Timestamp.valueOf(score.getLocalDateTime())
                , new TeamEntity(score.getHome().getId(), score.getHome().getName())
                , new TeamEntity(score.getAway().getId(), score.getAway().getName())
                , score.getHomeGoals()
                , score.getAwayGoals());
    }

}
