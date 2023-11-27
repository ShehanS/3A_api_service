package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.NASEventEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NASEventRepository extends JpaRepository<NASEventEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_nas WHERE event_id = :id", nativeQuery = true)
    int deleteByEventId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_nas WHERE event_id = :id", nativeQuery = true)
    List<NASEventEntity> findByEventId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_nas")
    int getRecordCount();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO bb_nas(nas_id, nas_name, nas_attrgroup, nas_secret, nas_type)VALUES(:nas_id, :nas_name, :nas_attrgroup, :nas_secret, :nas_type)")
    void saveNasEvent(@Param("nas_id") int nasId, @Param("nas_name") String nasName, @Param("nas_attrgroup") int nasAttrgroup, @Param("nas_secret") String nasSecret, @Param("nas_type") String nasType);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE bb_nas SET nas_name=:nas_name, nas_attrgroup=:nas_attrgroup, nas_secret=:nas_secret, nas_type=:nas_type WHERE nas_id=:nas_id")
    void updateNasEvent(@Param("nas_id") int nasId, @Param("nas_name") String nasName, @Param("nas_attrgroup") int nasAttrgroup, @Param("nas_secret") String nasSecret, @Param("nas_type") String nasType);


}
