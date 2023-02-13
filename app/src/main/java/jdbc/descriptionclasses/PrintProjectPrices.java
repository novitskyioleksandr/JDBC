package jdbc.descriptionclasses;

public class PrintProjectPrices {
    private int project_id;
    private int price;

    public PrintProjectPrices(int project_id, int price) {
        this.project_id = project_id;
        this.price = price;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getPrice() {
        return price;
    }
}
