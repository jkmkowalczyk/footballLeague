package application.repository;

import application.entity.PlayerEntity;
import application.entity.PointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRepository extends JpaRepository<PointsEntity, Integer> {
}
