package src.main.java; 

public class Medicine {
    private String image;
    private String name;
    private double cost;

    // Default constructor
    public Medicine() {
    }

    // Parameterized constructor
    public Medicine(String image, String name, double cost) {
        this.image = image;
        this.name = name;
        this.cost = cost;
    }

    // Getters and setters for image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for cost
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString method
    @Override
    public String toString() {
        return "Medicine{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
