package generic;

public class AcademyStudent extends Student {
    private String academyName;

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    @Override
    public String toString() {
        return "AcademyStudent{" +
                "academyName='" + academyName + '\'' +
                '}' + super.toString();
    }
}
