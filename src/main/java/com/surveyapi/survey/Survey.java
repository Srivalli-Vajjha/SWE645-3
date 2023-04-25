package com.surveyapi.survey;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="surveys")
public class Survey {

    public enum LikesAbtCampus{
        STUDENTS,
        LOCATION,
        CAMPUS,
        ATMOSPHERE,
        DORMROOMS,
        SPORTS
     }

     public enum HearAbtCampus{
        FRIENDS,
        TELEVISION,
        INTERNET,
        OTHERS
     }

     public enum Recommend{
        VERYLIKELY,
        LIKELY,
        UNLIKELY
     }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "streetAddress",nullable = false)
    private String streetAddress;

    @Column(name="city",nullable = false)
    private String city;

    @Column(name="state",nullable = false)
    private String state;

    @Column(name="zip",length=5,nullable = false)
    private Integer zip;

    @Column(name="telNum",length=10,nullable = false)
    private long telNum; 

    @Column(name="email",nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name="dateOfSurvey",nullable = false)
    private Date dateOfSurvey;

    @ElementCollection(targetClass = LikesAbtCampus.class)
    @JoinTable(name="likesAbtCampus",joinColumns=@JoinColumn(name="id"))
    @Column(name="likesAbtCampus",nullable = true)
    @Enumerated(EnumType.STRING)
    private Collection<LikesAbtCampus> likesAbtCampus;

    @Column(name="hearAbtUs",nullable = true)
    @Enumerated(EnumType.STRING)
    private HearAbtCampus hearAbtUs;


    @Column(name="recommend",nullable = true)
    @Enumerated(EnumType.STRING)
    private Recommend recommend;

    @Column(name="comments",nullable = true)
    private String comments;



    public long getTelNum() {
        return telNum;
    }

    public void setTelNum(long telNum) {
        this.telNum = telNum;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Recommend getRecommend() {
        return recommend;
    }

    public void setRecommend(Recommend recommend) {
        this.recommend = recommend;
    }

    
    public HearAbtCampus getHearAbtUs() {
        return hearAbtUs;
    }

    public void setHearAbtUs(HearAbtCampus hearAbtUs) {
        this.hearAbtUs = hearAbtUs;
    }

    public Collection<LikesAbtCampus> getLikesAbtCampus() {
        return likesAbtCampus;
    }

    public void setLikesAbtCampus(Collection<LikesAbtCampus> likesAbtCampus) {
        this.likesAbtCampus = likesAbtCampus;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
public String toString() {

    return "Student{" +
    "id=" + id +
    ", firstName='" + firstName + '\'' +
    ", lastName='" + lastName + '\'' +
    ", streetAddress='" + streetAddress + '\'' +
    ", city='" + city + '\'' +
    ", state='" + state + '\'' +
    ", zip='" + zip + '\'' +
    ", telNum='" + telNum + '\'' +
    ", dateOfSurvey='" + dateOfSurvey + '\'' +
    ", email='" + email + '\'' +
    ", hearAbtCampus='" + hearAbtUs + '\'' +
    ", Recommend='" + recommend + '\'' +
    ", comments='" + comments + '\'' +
    '}';
}

    
}
