package application.repository;

import application.dto.Player;
import application.dto.Team;
import application.entity.PlayerEntity;
import application.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {


    List<PlayerEntity> findByTeam(TeamEntity teamEntity);
}
