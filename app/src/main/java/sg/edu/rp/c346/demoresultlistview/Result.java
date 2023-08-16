package sg.edu.rp.c346.demoresultlistview;

public class Result {
    private String Year;
    private String Type_of_Study;
    private String Enrolment;

    public Result(String Year, String Type_of_Study, String enrolment) {
        this.Year = Year;
        this.Type_of_Study = Type_of_Study;
        this.Enrolment=enrolment;
    }

    public String getYear() {
        return Year;
    }

    public String getType_of_Study() {
        return Type_of_Study;
    }

    public String getEnrolment() {
        return Enrolment;
    }


    public void setYear(String Year) {
        this.Year = Year;
    }

    public void setType_of_Study(String Type_of_Study) {
        this.Type_of_Study = Type_of_Study;
    }

    public void setEnrolment(String Enrolment) {
        this.Enrolment = Enrolment;
    }

    public String toString() {
        return Year+ ": " + Type_of_Study+ ": " + Enrolment ;
    }
}



