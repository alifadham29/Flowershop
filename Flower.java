public class Flower{
    public String colour;
    public String name;
    public double price;
    public int quantity;


    public Flower(){
        this.name= "";
        this.colour= "";
        this.price= 0.0; 
        this.quantity=0;
    }
    
    public Flower(String name, String colour, double price, int quantity){
        this.name= name;
        this.colour = colour;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
        return name;
    }
    
    public String getColour(){
        return colour;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setColour(String colour){
        this.colour = colour;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public String toString(){
        return ("\nName = " + getName() + "\nColour = " + getColour() + "\nPrice = " + getPrice() + "\nQuantity = " + getQuantity());
        
    }

    public static void main(String[] args) {
        Flower daisy = new Flower("Daisy","Pink", 49.99,2);
        System.out.println(daisy);
    }
}


