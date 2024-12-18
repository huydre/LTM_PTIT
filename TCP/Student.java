package TCP;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String code, gpaLetter;
    private float gpa;
    private static final long serialVersionUID = 20151107;

    public Student(int id, float gpa, String gpaLetter, String code) {
        this.id = id;
        this.gpa = gpa;
        this.gpaLetter = gpaLetter;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGpaLetter() {
        return gpaLetter;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", gpaLetter='" + gpaLetter + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
