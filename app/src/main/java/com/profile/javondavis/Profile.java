package com.profile.javondavis;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Javon Davis
 *         Created by Javon Davis on 28/01/16.
 */
public class Profile {

    /**
     * name : Javon Davis
     * imageurl : http://s22.postimg.org/4ur276ylt/grey.jpg
     * skills : ["Android Development","Java Programming","Python Programming","API Development","Swift Programming","C/C++ programming"]
     * title : Software Developer, Android Lover
     * summary : Android Developer with 2 years of professional experience developing Android applications locally for companies in Jamaica. I have done 3 years of freelance Android application development for clients and 1 year of freelance Calculus tutoring along with voluntary Mathematics tutoring in my community. I possess a strong interest in competitive programming and a passion for building efficient and beautiful Android apps.
     * emails : ["javonldavis14@gmail.com","javon@uwimonacs.com"]
     * workexperiences : [{"employer":"Mona Institute of Technology Services","start":"Jun 2014","end":"Present","position":"Software Developer Intern","location":"Kingston, Jamaica","responsibilities":["Develop Android application for the University of the West Indies, Mona Campus from inception to release.","Monitor the performance of project team members, providing and documenting performance feedback."]},{"employer":"Artuvic IT Solutions","start":"January 2015","end":"September 2015","position":"Android Developer","location":"Kingston, Jamaica","responsibilities":["Modify existing Android applications to correct errors, allow it to adapt to older versions of the Android API, and to improve its performance.","Work with the Play! framework to build an API to communicate with new and existing Android Applications."]},{"employer":"University of the West Indies, Mona Campus","start":"September 2014","end":"Present","position":"Lab Assistant","location":"Kingston, Jamaica","responsibilities":["Provide guidance to first year students on their Python and Java assignments.","Grade first year students Python and Java lab assignments","Provide valuable feedback on courses to Lecturer's based on interactions with students."]}]
     * projects : [{"title":"Chatois","url":"https://play.google.com/store/apps/details?id=com.chatois.app","description":"A Jamaican word guesssing game. Users are given a hint in standard english and then will have to guess the correct Jamaican patois equivalent."},{"title":"Lab Assistant","url":"https://github.com/JA-VON/Lab-Assistant","description":"As a Lab Assistant at the University of the West Indies, Mona Campus one of my responsibilities is to assist students with their python and Java Assignments and at the end of the lab sessions evaluate the student\u2019s program and assign a fair grade to the student based on the criteria of the lab and the implementation done by the student. These grades were recorded using pen and paper and then at the end of a certain time period one of the lab assistants would have the responsibility of manually posting the students grades onto the web platform used by the university named OurVLE, which is a site powered by Moodle. I developed an Android application and a small web application in javascript to automate the process. The Android application was used to record the grades and send them off to database powered by Parse and then javascript was written on Parse to handle automatically publishing students grades onto the school web platform."},{"title":"UWI Research Days 2016","url":"https://github.com/JA-VON/UWI-Research-Days-Android","description":"The University of the West Indies, Mona Campus has an annual event where the University showcases all the research being done at the institution. A few weeks prior to the event I was tasked with assembling and leading a small team to develop a companion app for the three day event held. The application was well received by staff at the University and those who attended the event."},{"title":"Mobile OurVLE","url":"https://github.com/JA-VON/Mobile-OurVLE","description":"Students at the University of the West Indies, Mona Campus interact with course content published by our lecturers mainly through our online learning platform OurVLE(Our Virtual Learning Environment), which is powered by Moodle. While working at Mona Information Technology Services, which operates through the University, I was tasked with building an Android Application for the platform from start to delivery."},{"title":"J Wray & Nephew Wine app","url":"","description":"An Android application for internal use by sales representatives of J Wray & Nephew in Jamaica."},{"title":"HarvestSMS","url":"","description":"This was the application that won the local leg of the Agrihack talent Initiative in October 2014. The application provided a way for farmers to gather valuable information about their crops or cattle using a text based system built by incorporating Nexmo Apis. Farmers would be able to text in codes and receive information accordingly."}]
     * educations : [{"name":"University of the West Indies, Mona campus","start":"Sep 2013","end":"Oct 2016","degree":"Bachelor of Science","study":"Computer Science Major, Mathematics Minor"}]
     * awards : [{"title":"Dean's List Award Recipient","issuer":"Dean of the faculty of Science amp; Technology at the University of the West Indies, Mona","date":"March 2015","description":"For excellent performance in 2013/2014 academic year"}]
     */

    private String name;
    private String imageurl;
    private String title;
    private String summary;
    private List<String> skills;
    private List<String> emails;
    /**
     * employer : Mona Institute of Technology Services
     * start : Jun 2014
     * end : Present
     * position : Software Developer Intern
     * location : Kingston, Jamaica
     * responsibilities : ["Develop Android application for the University of the West Indies, Mona Campus from inception to release.","Monitor the performance of project team members, providing and documenting performance feedback."]
     */

    @SerializedName("workexperiences")
    private List<WorkExperience> workExperiences;
    /**
     * title : Chatois
     * url : https://play.google.com/store/apps/details?id=com.chatois.app
     * description : A Jamaican word guesssing game. Users are given a hint in standard english and then will have to guess the correct Jamaican patois equivalent.
     */

    private List<Project> projects;
    /**
     * name : University of the West Indies, Mona campus
     * start : Sep 2013
     * end : Oct 2016
     * degree : Bachelor of Science
     * study : Computer Science Major, Mathematics Minor
     */

    private List<Education> educations;
    /**
     * title : Dean's List Award Recipient
     * issuer : Dean of the faculty of Science amp; Technology at the University of the West Indies, Mona
     * date : March 2015
     * description : For excellent performance in 2013/2014 academic year
     */

    private List<Award> awards;

    public static Profile objectFromData(String str) {

        return new Gson().fromJson(str, Profile.class);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public String getName() {
        return name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public static class WorkExperience {
        private String employer;
        private String start;
        private String end;
        private String position;
        private String location;
        private List<String> responsibilities;

        public static WorkExperience objectFromData(String str) {

            return new Gson().fromJson(str, WorkExperience.class);
        }

        public void setEmployer(String employer) {
            this.employer = employer;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setResponsibilities(List<String> responsibilities) {
            this.responsibilities = responsibilities;
        }

        public String getEmployer() {
            return employer;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public String getPosition() {
            return position;
        }

        public String getLocation() {
            return location;
        }

        public List<String> getResponsibilities() {
            return responsibilities;
        }
    }

    public static class Project {
        private String title;
        private String url;
        private String description;

        public static Project objectFromData(String str) {

            return new Gson().fromJson(str, Project.class);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class Education {
        private String name;
        private String start;
        private String end;
        private String degree;
        private String study;

        public static Education objectFromData(String str) {

            return new Gson().fromJson(str, Education.class);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public void setStudy(String study) {
            this.study = study;
        }

        public String getName() {
            return name;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public String getDegree() {
            return degree;
        }

        public String getStudy() {
            return study;
        }
    }

    public static class Award {
        private String title;
        private String issuer;
        private String date;
        private String description;

        public static Award objectFromData(String str) {

            return new Gson().fromJson(str, Award.class);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getIssuer() {
            return issuer;
        }

        public String getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }
    }
}
