package com.ncinga.aaa.repository;

import com.ncinga.aaa.entity.AVPRecordEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AVPRecordRepository extends JpaRepository<AVPRecordEntity, Number> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM bb_attrgroup_accounting_avp_override")
    int getRecordCount();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bb_attrgroup_accounting_avp_override WHERE attrgroup_id = :id", nativeQuery = true)
    int deleteByAttrGroupId(@Param("id") int id);

}
