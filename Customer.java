public class Customer {
    private int id;
    private static int total;
    private String name;
    private int discount;

    public Customer(String name, int discount) throws Exception {
        if (name == null || discount < 0)
            throw new Exception("TU É BURRO?");
        
        total++;
        this.id = total;

        this.name = name;
        this.discount = discount;
    }

    public static int getTotal() {
        return total;
    }

    public String getName() {
        return this.name;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", discount=" + discount + "]";
    }

    public static void main(String[] args) {
        
    }
}
