package online.luffyk.domain;

public class Cart {
    private Integer CART_ID;
    private String CART_P_FILENAME;
    private String CART_P_NAME;
    private Integer CART_P_PRICE;
    private Integer CART_P_NUMBER;
    private Integer CART_P_STOCK;
    private Integer CART_P_ID;
    private String CART_U_ID;
    private Integer CART_VALID;

    public Cart() {
    }

    public Cart(Integer CART_ID, String CART_P_FILENAME, String CART_P_NAME, Integer CART_P_PRICE, Integer CART_P_NUMBER, Integer CART_P_STOCK, Integer CART_P_ID, String CART_U_ID, Integer CART_VALID) {
        this.CART_ID = CART_ID;
        this.CART_P_FILENAME = CART_P_FILENAME;
        this.CART_P_NAME = CART_P_NAME;
        this.CART_P_PRICE = CART_P_PRICE;
        this.CART_P_NUMBER = CART_P_NUMBER;
        this.CART_P_STOCK = CART_P_STOCK;
        this.CART_P_ID = CART_P_ID;
        this.CART_U_ID = CART_U_ID;
        this.CART_VALID = CART_VALID;
    }

    public Integer getCART_ID() {
        return CART_ID;
    }

    public void setCART_ID(Integer CART_ID) {
        this.CART_ID = CART_ID;
    }

    public String getCART_P_FILENAME() {
        return CART_P_FILENAME;
    }

    public void setCART_P_FILENAME(String CART_P_FILENAME) {
        this.CART_P_FILENAME = CART_P_FILENAME;
    }

    public String getCART_P_NAME() {
        return CART_P_NAME;
    }

    public void setCART_P_NAME(String CART_P_NAME) {
        this.CART_P_NAME = CART_P_NAME;
    }

    public Integer getCART_P_PRICE() {
        return CART_P_PRICE;
    }

    public void setCART_P_PRICE(Integer CART_P_PRICE) {
        this.CART_P_PRICE = CART_P_PRICE;
    }

    public Integer getCART_P_NUMBER() {
        return CART_P_NUMBER;
    }

    public void setCART_P_NUMBER(Integer CART_P_NUMBER) {
        this.CART_P_NUMBER = CART_P_NUMBER;
    }

    public Integer getCART_P_STOCK() {
        return CART_P_STOCK;
    }

    public void setCART_P_STOCK(Integer CART_P_STOCK) {
        this.CART_P_STOCK = CART_P_STOCK;
    }

    public Integer getCART_P_ID() {
        return CART_P_ID;
    }

    public void setCART_P_ID(Integer CART_P_ID) {
        this.CART_P_ID = CART_P_ID;
    }

    public String getCART_U_ID() {
        return CART_U_ID;
    }

    public void setCART_U_ID(String CART_U_ID) {
        this.CART_U_ID = CART_U_ID;
    }

    public Integer getCART_VALID() {
        return CART_VALID;
    }

    public void setCART_VALID(Integer CART_VALID) {
        this.CART_VALID = CART_VALID;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CART_ID=" + CART_ID +
                ", CART_P_FILENAME='" + CART_P_FILENAME + '\'' +
                ", CART_P_NAME='" + CART_P_NAME + '\'' +
                ", CART_P_PRICE=" + CART_P_PRICE +
                ", CART_P_NUMBER=" + CART_P_NUMBER +
                ", CART_P_STOCK=" + CART_P_STOCK +
                ", CART_P_ID=" + CART_P_ID +
                ", CART_U_ID='" + CART_U_ID + '\'' +
                ", CART_VALID=" + CART_VALID +
                '}';
    }
}
