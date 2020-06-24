package online.luffyk.domain;

public class Category {
    private Integer CATEGORY_ID;
    private String CATEGORY_NAME;
    private Integer CATEGORY_PARENT_ID;

    public Category() {
    }

    public Category(Integer CATEGORY_ID, String CATEGORY_NAME, Integer CATEGORY_PARENT_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.CATEGORY_PARENT_ID = CATEGORY_PARENT_ID;
    }

    public Integer getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(Integer CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public String getCATEGORY_NAME() {
        return CATEGORY_NAME;
    }

    public void setCATEGORY_NAME(String CATEGORY_NAME) {
        this.CATEGORY_NAME = CATEGORY_NAME;
    }

    public Integer getCATEGORY_PARENT_ID() {
        return CATEGORY_PARENT_ID;
    }

    public void setCATEGORY_PARENT_ID(Integer CATEGORY_PARENT_ID) {
        this.CATEGORY_PARENT_ID = CATEGORY_PARENT_ID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CATEGORY_ID=" + CATEGORY_ID +
                ", CATEGORY_NAME='" + CATEGORY_NAME + '\'' +
                ", CATEGORY_PARENT_ID=" + CATEGORY_PARENT_ID +
                '}';
    }
}
