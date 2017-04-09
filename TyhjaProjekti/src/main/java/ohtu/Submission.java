package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private String name;
    private String term;
    private String[] aAll;
    private String hours;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;
    private String a10;
    private String a11;
    private String a12;
    private String week1;
    private String week2;
    private String week3;
    private String weeknbr;
    private String max;

    public String getStudent_number() {
        return student_number;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }
    
    public void setWeeknbr() {
        if (this.week.matches("" + 1)) {
            max = week1;
        } else if (this.week.matches("" + 2)) {
            max = week2;
        } else if (this.week.matches("" + 3)) {
            max = week3;
        }
    }
    
    public void setWeeks(String week1, String week2, String week3) {
        this.week1 = week1;
        this.week2 = week2;
        this.week3 = week3;
    }
    
    public String[] getWeeks() {
        String[] a = new String[3];
        a[0] = this.week1;
        a[1] = this.week2;
        a[2] = this.week3;
        return a;
    }
    
    public void setName(String name) {
        this.term = term;
    }
    
    public String getTerm() {
        return term;
    }
    
    public String getName() {
        return name;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        addTo();
        String done = showDone();
        int cnt = countDone();
        String ret = "viikko " + week + ": tehtyja tehtavia yhteensa: " + cnt + " (maksimi " + this.max + "), aikaa kului " + hours + " tuntia, tehdyt tehtavat: " + done;
        return ret;
    }
    
    public int countDone() {
        addTo();
        int cnt = 0;
        for (int i = 0; i < 12; i++) {
            if (aAll[i] != null) {
                if (aAll[i].matches("true")) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public int getHours() {
        try {
            return Integer.parseInt(this.hours);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public String showDone() {
        addTo();
        String done = "";
        for (int i = 0; i < 12; i++) {
            if (aAll[i] != null) {
                if (aAll[i].matches("true")) {
                    int nbr = i + 1;
                    done = done + nbr + " "; 
                }
            }
        }
        return done;
    }
    
    public void addTo() {
        aAll = new String[12];
        aAll[0] = a1;
        aAll[1] = a2;
        aAll[2] = a3;
        aAll[3] = a4;
        aAll[4] = a5;
        aAll[5] = a6;
        aAll[6] = a7;
        aAll[7] = a8;
        aAll[8] = a9;
        aAll[9] = a10;
        aAll[10] = a11;
        aAll[11] = a12;
    }
}