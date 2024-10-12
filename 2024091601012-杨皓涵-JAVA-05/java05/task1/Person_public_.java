package task1;

public class Person_public_ {
    public static void main(String[] args) {
        Person person = new Person("yang", 18, 1);//假设1表示男性

    }
}

class Person {
    private String name;
    private int age;
    private int sex;

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    //在对象被销毁时将其从计数中删去
    //注意这只能在java8以前的jdk版本中实现
    @Override
    protected void finalize() throws Throwable {
        count--;
        super.finalize(); // 调用父类的finalize方法
    }

    public Person() {
        count++;
    }

    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        count++;
    }

    // 复制对象的构造方法
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.sex = other.sex;
        count++;
    }

    public void eat() {
        System.out.println(name+"正在吃东西");
    }

    void sleep() {
        System.out.println(name+"正在睡觉");
    }

    private void dadoudou() {
        System.out.println(name + "正在打豆豆");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


}