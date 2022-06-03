package app.repository;

import app.entity.OwnerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Integer> {
    @Query("select e from OwnerEntity e where e.passportCode = :code")
    OwnerEntity findOwnerByPassport(@Param("code") int code);

    @Query("FROM OwnerEntity")
    List<OwnerEntity> findAll();
}
