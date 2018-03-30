package application.service;

import application.dto.Points;
import application.dto.Team;
import application.entity.PointsEntity;
import application.entity.TeamEntity;
import application.repository.PointsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointsService {

    private final PointsRepository pointsRepository;

    public List<Points> findAll() {
        List<Points> points = toDto(pointsRepository.findAll());
        points.sort(Comparator.comparing(Points::getPoints).reversed());
        return points;
    }

    public PointsService(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    public void save(Points points) {
        pointsRepository.save(toEntity(points));
    }


    public Points findById(Integer id) {
        PointsEntity pointsEntity = pointsRepository.findOne(id);
        pointsRepository.findAll();
        pointsEntity.getId();
        return toDto(pointsEntity);
    }

    private PointsEntity toEntity(Points points) {
        return new PointsEntity(new TeamEntity(points.getTeam().getId(), points.getTeam().getName())
                , points.getPoints()
                , points.getWins()
                , points.getLoses()
                , points.getTies());
    }


    private List<Points> toDto(List<PointsEntity> pointsEntities) {
        return pointsEntities.stream().map(this::toDto).collect(Collectors.toList());
    }

    private Points toDto(PointsEntity pointsEntity) {
        return new Points(new Team(pointsEntity.getTeam().getId(), pointsEntity.getTeam().getName()),
                pointsEntity.getPoints(),
                pointsEntity.getWins(),
                pointsEntity.getLoses(),
                pointsEntity.getTies());
    }

}
