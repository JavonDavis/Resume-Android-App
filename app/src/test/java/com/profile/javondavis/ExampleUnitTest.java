package com.profile.javondavis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.profile.javondavis.models.Profile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    private String sampleProfile = "{\n" +
            "  \"awards\" : [ {\n" +
            "    \"date\" : \"March 2015\",\n" +
            "    \"description\" : \"For excellent performance in 2013/2014 academic year\",\n" +
            "    \"issuer\" : \"Dean of the faculty of Science amp; Technology at the University of the West Indies, Mona\",\n" +
            "    \"title\" : \"Dean's List Award Recipient\"\n" +
            "  } ],\n" +
            "  \"educations\" : [ {\n" +
            "    \"courses\" : [ \"Theory of Computation\" ],\n" +
            "    \"degree\" : \"B.Sc.\",\n" +
            "    \"end\" : \"October 2016\",\n" +
            "    \"major\" : \"Computer Science\",\n" +
            "    \"minor\" : \"Mathematics\",\n" +
            "    \"name\" : \"University of the West Indies\",\n" +
            "    \"start\" : \"September 2013\",\n" +
            "    \"study\" : \"Computer Science\"\n" +
            "  } ],\n" +
            "  \"firstname\" : \"Javon\",\n" +
            "  \"imageurl\" : \"https://firebasestorage.googleapis.com/v0/b/javon-davis.appspot.com/o/profile_pic.jpg?alt=media&token=b4e907ff-a66e-4040-988f-3dbdd165a5d5\",\n" +
            "  \"links\" : {\n" +
            "    \"emails\" : [ \"javonldavis14@gmail.com\" ],\n" +
            "    \"github\" : \"https://github.com/JA-VON/\",\n" +
            "    \"linkedin\" : \"https://linkedin.com/javonldavis\"\n" +
            "  },\n" +
            "  \"location\" : \"Kingston, Jamaica\",\n" +
            "  \"name\" : \"Javon Davis\",\n" +
            "  \"projects\" : [ {\n" +
            "    \"date\" : \"May 2016\",\n" +
            "    \"description\" : \"Python framework to generate a volume of questions based on a configuration, available on PyPi\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/QGenPY\",\n" +
            "    \"tags\" : [ \"Python\", \"Django\", \"AngularJS\" ],\n" +
            "    \"title\" : \"QGenPY\",\n" +
            "    \"url\" : \"http://104.236.42.106/\"\n" +
            "  }, {\n" +
            "    \"date\" : \"February 2016\",\n" +
            "    \"description\" : \"Android Library to animate the transitions over a number of views in a list\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/Android-View-Controller\",\n" +
            "    \"tags\" : [ \"Android\", \"Java\" ],\n" +
            "    \"title\" : \"AndroidViewController\",\n" +
            "    \"url\" : \"http://android-arsenal.com/details/1/3208\"\n" +
            "  }, {\n" +
            "    \"date\" : \"December 2015\",\n" +
            "    \"description\" : \"Interpreter for a Language defined by professor for a Language Processors course\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/Henderson-Painter-Language-HPL\",\n" +
            "    \"tags\" : [ \"Language Processors\", \"Compiler Theory\", \"Java\", \"JLex\", \"Cup\" ],\n" +
            "    \"title\" : \"HPL Interpreter\",\n" +
            "    \"url\" : \"\"\n" +
            "  }, {\n" +
            "    \"date\" : \"March 2015\",\n" +
            "    \"description\" : \"Users are given a word or phrase in English and must select Patois equivalent from a grid of letters\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/Chatois\",\n" +
            "    \"tags\" : [ \"Android\", \"Java\" ],\n" +
            "    \"title\" : \"Chatois\",\n" +
            "    \"url\" : \"https://play.google.com/store/apps/details?id=com.chatois.app\"\n" +
            "  }, {\n" +
            "    \"date\" : \"December 2015\",\n" +
            "    \"description\" : \"Android App to scan students’ ID cards and save their grades to a Moodle instance\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/Lab-Assistant\",\n" +
            "    \"tags\" : [ \"Android\", \"Javascript\", \"Parse\" ],\n" +
            "    \"title\" : \"Lab Assistant\",\n" +
            "    \"url\" : \"\"\n" +
            "  }, {\n" +
            "    \"date\" : \"February 2016\",\n" +
            "    \"description\" : \"Companion app for annual 3 day event held at the university\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/UWI-Research-Days-Android\",\n" +
            "    \"tags\" : [ \"Android\", \"Java\", \"Parse\", \"Javascript\" ],\n" +
            "    \"title\" : \"UWI Research Days\",\n" +
            "    \"url\" : \"https://play.google.com/store/apps/details?id=com.uwics.uwidiscover&hl=en\"\n" +
            "  }, {\n" +
            "    \"date\" : \"August 2015\",\n" +
            "    \"description\" : \"Android application for the eduction platform used by over 15000 students at the University of the West Indies, Mona Campus\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/Mobile-OurVLE\",\n" +
            "    \"tags\" : [ \"Android\", \"Java\" ],\n" +
            "    \"title\" : \"Mobile OurVLE\",\n" +
            "    \"url\" : \"\"\n" +
            "  }, {\n" +
            "    \"date\" : \"August 2015\",\n" +
            "    \"description\" : \"Android application for internal use to provide wine information, loaded from a MSSQL database, readily to the sales representatives of J Wray & Nephew in Jamaica.\",\n" +
            "    \"source\" : \"\",\n" +
            "    \"tags\" : [ \"Android\", \"Java\", \"MSSQL\", \"PHP\" ],\n" +
            "    \"title\" : \"J Wray & Nephew Wine app\",\n" +
            "    \"url\" : \"\"\n" +
            "  }, {\n" +
            "    \"date\" : \"December 2014\",\n" +
            "    \"description\" : \"Application that won the Jamaica leg of the Agrihack talent Initiative in October 2014. Web/SMS application for farmers to gather valuable information about their crops or cattle using a text based system built by incorporating Nexmo API. Farmers would be able to text in codes and receive information accordingly.\",\n" +
            "    \"source\" : \"https://github.com/JA-VON/HarvestSMS\",\n" +
            "    \"tags\" : [ \"SMS\", \"Javascript\", \"Nexmo\", \"PHP\" ],\n" +
            "    \"title\" : \"HarvestSMS\",\n" +
            "    \"url\" : \"\"\n" +
            "  } ],\n" +
            "  \"skills\" : {\n" +
            "    \"familiar\" : [ \"C/C++ programming\", \"Scala Programming\", \"IOS Development\", \"Swift Programming\", \"PHP Programming\", \"Play! Framework\", \"Laravel Framework\", \"Django Framework\", \"AngularJS\" ],\n" +
            "    \"proficient\" : [ \"Android Development\", \"Java Programming\", \"Python Programming\", \"API Development\", \"JLex\", \"CUP\" ]\n" +
            "  },\n" +
            "  \"summary\" : \"Android Developer with 2 years of professional experience developing android applications for local companies in Jamaica. I have done 3 years of freelance Android application development for clients and 1 year of freelance Calculus tutoring along with voluntary Mathematics tutoring in my community. I possess a strong interest in competitive programming and a passion for building efficient and beautiful Android apps. Looking to leverage my knowledge and experience into a role as an Android Developer.\",\n" +
            "  \"surname\" : \"Davis\",\n" +
            "  \"title\" : \"Software Developer, Android Lover. VP, UWI Mona Computing Society\",\n" +
            "  \"workexperiences\" : [ {\n" +
            "    \"employer\" : \"Mona School of Business and Management\",\n" +
            "    \"end\" : \"April 2016\",\n" +
            "    \"links\" : [ {\n" +
            "      \"description\" : \"Web browser for Ontology\",\n" +
            "      \"link\" : \"http://thesaurus.cdmk-caribbean.net/\"\n" +
            "    }, {\n" +
            "      \"description\" : \"Web application\",\n" +
            "      \"link\" : \"http://cdmk-caribbean.net/\"\n" +
            "    }, {\n" +
            "      \"description\" : \"Visualization of Ontology\",\n" +
            "      \"link\" : \"http://skos.cdmk-caribbean.net/\"\n" +
            "    }, {\n" +
            "      \"description\" : \"Technical document\",\n" +
            "      \"link\" : \"https://docs.google.com/document/d/1NTyG6dUjKXnuVeWETstk7gHHez056bbfdIc_T6k_tTw/edit\"\n" +
            "    } ],\n" +
            "    \"location\" : \"Kingston, Jamaica\",\n" +
            "    \"position\" : \"Software Developer Intern\",\n" +
            "    \"responsibilities\" : [ \"Built an Ontology manager using Vocbench, served the Ontology over a SPARQL endpoint using Apache Jena Fuseki, and prepared a technical document on the process\", \"Developed 3 web applications on top of the SPARQL endpoint using Maui, SKOS Play! and Skosmos\" ],\n" +
            "    \"start\" : \"January 2016\"\n" +
            "  }, {\n" +
            "    \"employer\" : \"Mona Institute of Technology Services\",\n" +
            "    \"end\" : \"January 2016\",\n" +
            "    \"links\" : [ {\n" +
            "      \"description\" : \"\",\n" +
            "      \"link\" : \"https://github.com/JA-VON/Mobile-OurVLE\"\n" +
            "    } ],\n" +
            "    \"location\" : \"Kingston, Jamaica\",\n" +
            "    \"position\" : \"Software Developer Intern\",\n" +
            "    \"responsibilities\" : [ \"Developed an Android application for an education platform used by over 15000 students at the University\", \"Monitored the performance of team members and documented performance feedback for an Android project\" ],\n" +
            "    \"start\" : \"June 2014\"\n" +
            "  }, {\n" +
            "    \"employer\" : \"Mona Technology Park\",\n" +
            "    \"end\" : \"September 2015\",\n" +
            "    \"location\" : \"Kingston, Jamaica\",\n" +
            "    \"position\" : \"Android Developer\",\n" +
            "    \"responsibilities\" : [ \"Implemented Google Cloud Messaging in an existing application for employee use, resulting in improved network performance and the company paying less for data usage\", \"Worked with the Play! framework to build an API to communicate with an existing Android application\" ],\n" +
            "    \"start\" : \"January 2015\"\n" +
            "  }, {\n" +
            "    \"employer\" : \"University of the West Indies, Mona Campus\",\n" +
            "    \"end\" : \"April 2016\",\n" +
            "    \"links\" : [ {\n" +
            "      \"description\" : \"\",\n" +
            "      \"link\" : \"https://github.com/JA-VON/UWI-Research-Days-Android\"\n" +
            "    } ],\n" +
            "    \"location\" : \"Kingston, Jamaica\",\n" +
            "    \"position\" : \"Lab Assistant\",\n" +
            "    \"responsibilities\" : [ \"Developed Android app to scan students’ ID cards with Google Play Services API and save their grades\", \"Lead a 3-member development team for an Android app for an annual 3-day event held at the University\", \"Provide valuable feedback on courses to Lecturer's based on interactions with students.\" ],\n" +
            "    \"start\" : \"September 2014\"\n" +
            "  } ]\n" +
            "}\n";
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    // Test to see if Profile is loaded correctly using Gson
    public void loadProfile_isCorrect() throws Exception
    {
        Profile profile = new GsonBuilder().create().fromJson(sampleProfile, Profile.class);
        assertEquals(profile.getName(), "Javon Davis");
        assertTrue(profile.getWorkexperiences().size() == 4);
        assertTrue(profile.getSkills().getProficient().contains("Android Development"));
        assertNotNull(profile);
    }
}