package com.surveyapi.survey;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = surveyRepository.findAll();
        return surveys;
    }

    public Survey getSurveyById(int id) {
        return surveyRepository.findById(id);
    }

    public void saveSurvey(Survey survey) {
        try {
            surveyRepository.save(survey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete survey by id
    public void deleteSurvey(int id) {
        try {
            surveyRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
