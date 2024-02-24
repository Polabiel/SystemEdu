import java.io.InvalidClassException;

public class Products {
    private static int total;
    private int id;
    private String name;

    private Double price;

    public Products(String name, Double price) throws InvalidClassException {
        if (name == null || price == null) {
            throw new InvalidClassException("Invalid parameters!");
        }

        if (price < 0)
            throw new IllegalArgumentException("tu é burro", null);

        total++;
        this.id += total;
        this.name = name;
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
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
        Products other = (Products) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    public static void main(String[] args) throws InvalidClassException {
        try {
            Products c1 = new Products("null", 2.5);
            Products c2 = new Products("pinoi", 2.5);
            System.out.println("\n\n\n");
            System.out.println(c1.toString());
            System.out.println(c2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}