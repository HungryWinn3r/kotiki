package app.repository;

import app.entity.FriendsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendsRepository extends CrudRepository<FriendsEntity, Integer> {
    @Query("FROM FriendsEntity ")
    List<FriendsEntity> findAll();
}
