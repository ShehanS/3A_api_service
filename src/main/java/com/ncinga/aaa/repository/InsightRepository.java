package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.DataUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsightRepository extends JpaRepository<DataUsageEntity, Integer> {
    @Query(value = "SELECT * FROM bb_subscriber_data_usage WHERE report_date BETWEEN :startDate AND :endDate AND subscriber_id = :subscriberId ORDER BY report_date ASC", nativeQuery = true)
    Optional<List<DataUsageEntity>> getUsageByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("subscriberId") int subscriberId);


}
