package com.surveyapi.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SurveyController {

    @Autowired
    SurveyRepository surveyRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String Test() {
        return "test1";
    }

    @CrossOrigin
    @RequestMapping(value = "/surveys", method = RequestMethod.GET)
    @ResponseBody
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/survey", method = RequestMethod.POST)
    @ResponseBody
    public Survey addSurvey(@RequestBody Survey survey) {
        try{
        return surveyRepository.save(survey);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/findsurvey", method = RequestMethod.GET)
    @ResponseBody
    public Survey findSurvey(@RequestParam("surveyId") int surveyId) {
        return surveyRepository.findById(surveyId);
    }

    @RequestMapping(value = "/updatesurvey", method = RequestMethod.GET)
    @ResponseBody
    public Survey updateStudent(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    @RequestMapping(value = "/deletesurvey", method = RequestMethod.GET)
    @ResponseBody
    public int deleteStudent(@RequestParam("surveyId") int surveyId) {
        return surveyRepository.deleteById(surveyId);
    }

}
