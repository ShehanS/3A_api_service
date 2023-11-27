package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.NASAttributeGroupEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NASAttributeGroupRepository extends JpaRepository<NASAttributeGroupEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_nas_attrgroup WHERE group_id = :id", nativeQuery = true)
    int deleteByNASAttributeGroupById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_nas_attrgroup WHERE group_id = :id", nativeQuery = true)
    Optional<List<NASAttributeGroupEntity>> findByGroupId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_nas_attrgroup")
    int getRecordCount();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO bb_nas_attrgroup (group_id, group_name, group_description) VALUES (:group_id, :group_name, :group_description);")
    void saveNasAttributeGroup(@Param("group_id") int groupId, @Param("group_name") String groupName, @Param("group_description") String description);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE bb_nas_attrgroup SET group_name=:group_name, group_description=:group_description WHERE group_id=:group_id")
    void updateNasAttributeGroup(@Param("group_id") int groupId, @Param("group_name") String groupName, @Param("group_description") String description);

}
