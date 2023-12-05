package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.NASWhitelistEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NASWhitelistRepository extends JpaRepository<NASWhitelistEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_subscriber_nas_wihitelist WHERE subscriber_id = :id AND nas_id_pattern=:pattern", nativeQuery = true)
    int deleteNasWhitelist(@Param("id") int id, @Param("pattern") String pattern);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_subscriber_nas_wihitelist WHERE subscriber_id = :id", nativeQuery = true)
    List<NASWhitelistEntity> findBySubScriberId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_subscriber_nas_wihitelist")
    int getRecordCount();
}
