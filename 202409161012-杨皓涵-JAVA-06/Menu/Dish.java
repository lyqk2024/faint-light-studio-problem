package Menu;

public abstract class Dish implements Order {
    private String name;//菜品名称
    private double price;//菜品价格

    public abstract void profile();

    @Override
    public void cook() {
        System.out.println("输出烹饪方法");
    }

    public Dish(){}

    Dish(String name, double price) {
        setName(name) ;
        setPrice(price);
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}