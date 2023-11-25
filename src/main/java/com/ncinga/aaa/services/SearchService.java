package com.ncinga.aaa.services;

import com.ncinga.aaa.interfaces.ISearch;
import com.ncinga.aaa.repository.AVPRecordRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService implements ISearch {
    @Autowired
    private AVPRecordRepository avpRecordRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object search(String table, String columns, String search) {
        List<String> cols = List.of(columns.split(","));
        Query query = entityManager.createNativeQuery(generateLikeColumns(table, cols, search));
        List<Object> results = query.getResultList();
        List<Map<String, Object>> data = new ArrayList<>();
        if (results.size() > 0) {
            for (Object record : results) {
                Object[] r = (Object[]) record;
                Map<String, Object> row = new HashMap<>();
                for (int i = 0; i < r.length; i++) {
                    row.put(cols.get(i), r[i]);
                }
                data.add(row);
            }
            return data;
        }
        return null;
    }

    private String generateLikeColumns(String table, List<String> columns, String q) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        if (!columns.isEmpty()) {
            for (int i = 0; i < columns.size(); i++) {
                query.append(columns.get(i));
                if (i < columns.size() - 1) {
                    query.append(", ");
                }
            }
        } else {
            query.append("*");
        }
        query.append(" FROM  ");
        query.append(table);
        query.append(" WHERE ");
        if (!columns.isEmpty()) {
            for (int i = 0; i < columns.size(); i++) {
                query.append(columns.get(i)).append(" LIKE '%").append(q).append("%'");
                if (i < columns.size() - 1) {
                    query.append(" OR ");
                }
            }
        }

        return query.toString();
    }

}
