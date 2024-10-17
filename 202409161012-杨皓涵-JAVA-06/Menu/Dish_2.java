package Menu;

public class Dish_2 extends Dish implements Order{

    public Dish_2() {
        super("宫保鸡丁",1888);
    }

    @Override
    public void cook(){
        System.out.println("加入鸡丁爆炒。");
    }

    @Override
    public void profile(){
        System.out.println("宫保鸡丁是一道闻名中外的特色传统名菜。以其" +
                "麻辣鲜香、酸甜可口的特点深受人们喜爱。");
    }
}
