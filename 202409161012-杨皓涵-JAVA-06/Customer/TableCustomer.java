package Customer;

public class TableCustomer extends Customer {
    public int tableId;//餐桌编号

    public TableCustomer() {}

    public TableCustomer(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public void ServiceDetails() {
        System.out.println("送餐到" + tableId + "号桌\n");
    }
}
