package com.example.mcourse.year;

public class Year {
    private String term_1;
    private String term_2;
    private String term_3;


    public Year() {

    }

    public Year(String term_1, String term_2, String term_3) {
        this.term_1 = term_1;
        this.term_2 = term_2;
        this.term_3 = term_3;
    }

    public String getTerm_1() {
        return term_1;
    }

    public void setTerm_1(String term_1) {
        this.term_1 = term_1;
    }

    public String getTerm_2() {
        return term_2;
    }

    public void setTerm_2(String term_2) {
        this.term_2 = term_2;
    }

    public String getTerm_3() {
        return term_3;
    }

    public void setTerm_3(String term_3) {
        this.term_3 = term_3;
    }

}
