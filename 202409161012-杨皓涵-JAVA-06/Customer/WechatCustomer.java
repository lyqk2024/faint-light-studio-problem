package Customer;

public class WechatCustomer extends Customer {
    public String address;//顾客地址
    public boolean takeout;//true代表该顾客是外卖，false代表该顾客是堂食

    public WechatCustomer(String address, boolean takeout) {
        this.address = address;
        this.takeout = takeout;
    }

    public WechatCustomer() {}

    @Override
    public void ServiceDetails() {
        if (takeout) {
            System.out.println("外卖送餐地址：" + address + "\n");
        }
        else{
            System.out.println("顾客到店自取订单\n");
        }

    }
}
