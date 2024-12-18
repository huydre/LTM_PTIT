package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaGiamGia_Object {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        String msv = "B21DCCN713", qCode = "ICLV8auI";
        ProductX product = (ProductX) sv.requestObject(msv, qCode);
        System.out.println(product);

        int discount = 0;
        int tmp = 0;
        for (Character x : product.getDiscountCode().toCharArray()) {
            if (Character.isDigit(x)) {
                discount += (x - '0');
            }
        }

        product.setDiscount(discount);
        System.out.println(product);
        sv.submitObject(msv, qCode, product);
    }
}
