package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        String url2 = "https://ohtustats2017.herokuapp.com/courses/1.json";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String otherText = Request.Get(url2).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        System.out.println("json-muotoinen data:");
        System.out.println( otherText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Submission sub2 = mapper.fromJson(otherText, Submission.class);
        String[] a;
        int cnt = 0;
        int hr = 0;
        System.out.println("Kurssi: " + sub2.getName() + ", " + sub2.getTerm());
        System.out.println("");
        String ret = "opiskelijanumero: " + studentNr;
        System.out.println(ret);
        System.out.println("");
        for (Submission submission : subs) {
            a = sub2.getWeeks();
            submission.setWeeks(a[0], a[1], a[2]);
            submission.setWeeknbr();
            System.out.println(submission);
            cnt += submission.countDone();
            hr += submission.getHours();
        }
        System.out.println("");
        System.out.println("yhteensa: " + cnt + " tehtavaa " + hr + " tuntia");
    }
}