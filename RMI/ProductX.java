package RMI;

import java.io.Serializable;

public class ProductX implements Serializable {
    private String id, code, discountCode;
    private  int discount;
    private static final long serialVersionUID = 20171107;

    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductX{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", discountCode='" + discountCode + '\'' +
                ", discount=" + discount +
                '}';
    }
}
