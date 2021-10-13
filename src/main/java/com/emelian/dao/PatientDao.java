package com.emelian.dao;

import com.emelian.model.Patient;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDao {
    private final JdbcTemplate jdbcTemplate;

    public PatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Patient> index(){
        return jdbcTemplate.query("select * from patients", new BeanPropertyRowMapper<>(Patient.class));
    }
}
