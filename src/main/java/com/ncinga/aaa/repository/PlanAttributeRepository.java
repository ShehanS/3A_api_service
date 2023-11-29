package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.PlanAttributeEntity;
import com.ncinga.aaa.entity.PlanParameterEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanAttributeRepository extends JpaRepository<PlanAttributeEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_plan_attribute WHERE plan_id = :id", nativeQuery = true)
    int deleteByPlanId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_plan_attribute WHERE plan_id = :id", nativeQuery = true)
    List<PlanAttributeEntity> findByPlanId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_plan_attribute")
    int getRecordCount();
}
