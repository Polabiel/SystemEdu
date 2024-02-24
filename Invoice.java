import javax.naming.directory.InvalidAttributeValueException;

public class Invoice {
    private int id;
    private Customer Customer;
    private int nProducts = 0;
    private static int total;
    private Products[] products;
    private int[] quantities;

    public Invoice(Customer customer) throws InvalidAttributeValueException {

        if (customer == null) {
            throw new InvalidAttributeValueException("hahahahha");
        }

        total++;
        this.id = total;
        this.Customer = customer;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }

    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = nProducts;
    }

    public Products[] getProducts() {
        return products;
    }

    public void setProducts(Products[] products) {
        this.products = products;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }
}
