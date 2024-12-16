package WS;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project_ObjectService {
    public static void main(String[] args) {
        String msv = "B21DCCN093" , qCode = "p6XShR5U";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project> prj = port.requestListProject(msv, qCode);

        List<Project> res = new ArrayList<>();
        String targetDate = LocalDate.now().plusDays(15).toString();
        LocalDate today = LocalDate.now();
        System.out.println(targetDate);
        for (Project p : prj) {
            String dueDate = p.getDueDate().toString().substring(0,10);
            if (p.getCompletionPercentage() > 80 && compareDate(dueDate, targetDate) <= 0 && compareDate(dueDate, today.toString()) >= 0) {
                res.add(p);
                System.out.println(dueDate + " " + targetDate + " " + today);
            }
        }

        port.submitListProject(msv, qCode, res);
    }

    public static int compareDate(String a, String b) {
        String[] arr1 = a.substring(0,10).split("-");
        int year1 = Integer.parseInt(arr1[0]);
        int month1 = Integer.parseInt(arr1[1]);
        int day1 = Integer.parseInt(arr1[2]);

        String[] arr2 = b.substring(0,10).split("-");
        int year2 = Integer.parseInt(arr2[0]);
        int month2 = Integer.parseInt(arr2[1]);
        int day2 = Integer.parseInt(arr2[2]);

        if (year1 != year2) return year1 - year2;
        if (month1 != month2) return  month1 - month2;
        if (day1 != day2) return  day1 - day2;
        return 0;
    }
}
