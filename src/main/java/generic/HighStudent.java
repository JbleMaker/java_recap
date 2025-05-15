package generic;

public class HighStudent extends Student {
    private String highSchoolName;

    public String getHighSchoolName() {
        return highSchoolName;
    }

    public void setHighSchoolName(String highSchoolName) {
        this.highSchoolName = highSchoolName;
    }

    @Override
    public String toString() {
        return "HighStudent{" +
                "highSchoolName='" + highSchoolName + '\'' +
                '}' + super.toString();
    }
}
