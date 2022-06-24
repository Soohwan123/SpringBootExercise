package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO{

    
    private final JdbcTemplate jdbcTemplate;
    Person person;
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name FROM person"; 
/*             jdbcTemplate.query(sql, (resultSet, i) -> {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                return new Person(id, name);
        }, new Person[] {id, name}); 
        return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB")); */
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
    
}
