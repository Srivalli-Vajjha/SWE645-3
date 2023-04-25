package com.surveyapi.survey;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface SurveyRepository extends JpaRepository<Survey,Integer>{

    List<Survey> findAll();
    Survey findById(int id);
    int deleteById(int id);
}
