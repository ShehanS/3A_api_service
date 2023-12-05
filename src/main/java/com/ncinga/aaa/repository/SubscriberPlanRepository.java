package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.SubscriberParameterEntity;
import com.ncinga.aaa.entity.SubscriberPlanEntity;
import jakarta.transaction.Transactional;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriberPlanRepository extends JpaRepository<SubscriberPlanEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_subscriber_plan WHERE subscriber_id = :id", nativeQuery = true)
    int deleteSubscriberParameter(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_subscriber_plan WHERE subscriber_id = :id", nativeQuery = true)
    Optional<List<SubscriberPlanEntity>> findBySubscriberId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_subscriber_plan")
    int getRecordCount();
}
