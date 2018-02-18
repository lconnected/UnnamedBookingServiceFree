package org.ubsfree.bookingapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubsfree.bookingapp.data.entity.UserEntity;

import java.util.List;

/**
 * Created by lconnected on 30/01/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //empty

    @Query("select u from UserEntity u " +
            "where u.outerId = :outerId and u.name = :name")
    List<UserEntity> findByDetails(@Param("outerId") String outerId, @Param("name") String name);

}
