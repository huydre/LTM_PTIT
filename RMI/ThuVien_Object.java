package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ThuVien_Object {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");

        Book book = (Book) sv.requestObject("B21DCCN093", "kSII894o");
        System.out.println(book);

        // tao code
        String code = "";
        String[] nameArr = book.getAuthor().split("\\s+");
        code += String.valueOf(nameArr[0].toUpperCase().charAt(0)) + String.valueOf(nameArr[nameArr.length-1].toUpperCase().charAt(0));
        code += String.valueOf(book.getYearPublished()).substring(2);
        code += book.getTitle().length();
        code += String.format("%3d", book.getPageCount());
        System.out.println(code);
        book.setCode(code);

        sv.submitObject("B21DCCN093", "kSII894o", book);
    }
}
