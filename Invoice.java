import java.util.Arrays;

import javax.naming.directory.InvalidAttributeValueException;

public class Invoice {
    private static int total;

    public static int getTotal() {
        return total;
    }

    private int id;

    private int nProducts = 0;

    private Customer Customer;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + nProducts;
        result = prime * result + ((Customer == null) ? 0 : Customer.hashCode());
        result = prime * result + Arrays.hashCode(products);
        result = prime * result + Arrays.hashCode(quantities);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Invoice other = (Invoice) obj;
        if (id != other.id)
            return false;
        if (nProducts != other.nProducts)
            return false;
        if (Customer == null) {
            if (other.Customer != null)
                return false;
        } else if (!Customer.equals(other.Customer))
            return false;
        if (!Arrays.equals(products, other.products))
            return false;
        if (!Arrays.equals(quantities, other.quantities))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", Customer=" + Customer + ", products=" + Arrays.toString(products)
                + ", quantities=" + Arrays.toString(quantities) + "]";
    }

    public int getId() {
        return id;
    }

    public double getTotals() {
        double totals = 0;
        for (int i = 0; i < this.nProducts; i++) {
            totals += this.products[i].getPrice() * this.quantities[i];
        }
        return totals;
    }

    public Customer getCustomer() {
        return this.Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }

    public int getnProducts() {
        return this.nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = nProducts;
    }

    public Products[] getProducts() {
        return this.products;
    }

    public void setProducts(Products[] products) {
        this.products = products;
    }

    public int[] getQuantities() {
        return this.quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

    public double getTotalAfterDiscount() {
        return (1 - this.Customer.getDiscount() / 100 * this.getTotals());
    }

    public boolean addProduct(Products product, int amount) {

        for (int i = 0; i < this.nProducts; i++) {
            if (products[i].equals(product)) {
                return false;
            }
        }

        this.products[this.nProducts] = product;
        this.quantities[this.nProducts] = amount;
        this.nProducts++;
        return true;
    }

    public boolean removeProduct(Products product) {
        int index = -1;

        for (int i = 0; i < this.nProducts; i++) {
            if (products[i].equals(product)) {
                index = i;
                break;
            }
        }

        if (index > -1) {
            for (int i = 0; i < this.nProducts - 1; i++) {
                this.products[i] = this.products[i + 1];
                this.quantities[i] = quantities[i + 1];
                if (i + 1 == this.nProducts + 1) {
                    this.products[i + 1] = null;
                    this.quantities[i] = quantities[i + 1];
                }
            }
            nProducts--;
            return true;
        }
        return false;
    }
}
