package online.luffyk.domain;

public class Product {
    private Integer PRODUCT_ID;
    private String PRODUCT_NAME;
    private String PRODUCT_DESCRIPTION;
    private Integer PRODUCT_PRICE;
    private Integer PRODUCT_STOCK;
    private Integer PRODUCT_PID;
    private Integer PRODUCT_CID;
    private String PRODUCT_FILENAME;

    public Product() {
    }

    public Product(Integer PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_DESCRIPTION, Integer PRODUCT_PRICE, Integer PRODUCT_STOCK, Integer PRODUCT_PID, Integer PRODUCT_CID, String PRODUCT_FILENAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_STOCK = PRODUCT_STOCK;
        this.PRODUCT_PID = PRODUCT_PID;
        this.PRODUCT_CID = PRODUCT_CID;
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public Integer getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(Integer PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public Integer getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(Integer PRODUCT_STOCK) {
        this.PRODUCT_STOCK = PRODUCT_STOCK;
    }

    public Integer getPRODUCT_PID() {
        return PRODUCT_PID;
    }

    public void setPRODUCT_PID(Integer PRODUCT_PID) {
        this.PRODUCT_PID = PRODUCT_PID;
    }

    public Integer getPRODUCT_CID() {
        return PRODUCT_CID;
    }

    public void setPRODUCT_CID(Integer PRODUCT_CID) {
        this.PRODUCT_CID = PRODUCT_CID;
    }

    public String getPRODUCT_FILENAME() {
        return PRODUCT_FILENAME;
    }

    public void setPRODUCT_FILENAME(String PRODUCT_FILENAME) {
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    @Override
    public String toString() {
        return "Product{" +
                "PRODUCT_ID=" + PRODUCT_ID +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                ", PRODUCT_DESCRIPTION='" + PRODUCT_DESCRIPTION + '\'' +
                ", PRODUCT_PRICE=" + PRODUCT_PRICE +
                ", PRODUCT_STOCK=" + PRODUCT_STOCK +
                ", PRODUCT_PID=" + PRODUCT_PID +
                ", PRODUCT_CID=" + PRODUCT_CID +
                ", PRODUCT_FILENAME='" + PRODUCT_FILENAME + '\'' +
                '}';
    }
}
