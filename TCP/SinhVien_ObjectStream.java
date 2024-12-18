package TCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SinhVien_ObjectStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        String code = "B21DCCN713;ljn466lt";
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject(code);
        Student student = (Student) in.readObject();
        System.out.println(student);
        student.setGpaLetter(convertGPA(student.getGpa()));

        out.writeObject(student);

    }

    public static String convertGPA(float x) {
        if (x <= 1) return "F";
        if (x <= 2) return "D";
        if (x <= 3) return "C";
        if (x <= 3.7) return "B";
        return "A";
    }
}
