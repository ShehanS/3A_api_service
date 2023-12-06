package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.SubscriberEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_subscriber WHERE subscriber_id = :id", nativeQuery = true)
    int deleteBySubscriberId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_subscriber WHERE subscriber_id = :id", nativeQuery = true)
    List<SubscriberEntity> findBySubscriberId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_subscriber")
    int getRecordCount();

    @Query(value = "SELECT * FROM bb_subscriber WHERE email = :email OR username = :username", nativeQuery = true)
    Optional<List<SubscriberEntity>> findByEmailOrUsername(@Param("email") String email, @Param("username") String username);

}
