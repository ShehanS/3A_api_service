package com.ncinga.aaa.repository;

import com.ncinga.aaa.dtos.AccountFilterDto;
import com.ncinga.aaa.entity.AccountEntity;
import com.ncinga.aaa.entity.AccountFilterEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountFilterRepository extends JpaRepository<AccountFilterEntity, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_accounting_record_filter WHERE attrgroup_id = :id", nativeQuery = true)
    int deleteByAttrGroupId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM bb_accounting_record_filter WHERE attrgroup_id = :id", nativeQuery = true)
    List<AccountFilterEntity> findByAttributeGroupId(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = :schemaName", nativeQuery = true)
    List<String> getColumns(@Param("schemaName") String schemaName);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_accounting_record_filter")
    int getRecordCount();
}
