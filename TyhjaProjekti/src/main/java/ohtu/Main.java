package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "123456789";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        int cnt = 0;
        int hr = 0;
        String ret = "opiskelijanumero: " + studentNr;
        System.out.println(ret);
        System.out.println("");
        for (Submission submission : subs) {
            System.out.println(submission);
            cnt += submission.countDone();
            hr += submission.getHours();
        }
        System.out.println("");
        System.out.println("yhteensa: " + cnt + " tehtavaa " + hr + " tuntia");
    }
}