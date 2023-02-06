package Models;

public class Food {
    private int IDFood, price;
    private String nameFood, DVT;

    public Food(int IDFood, String nameFood, int price, String DVT) {
        this.IDFood = IDFood;
        this.DVT = DVT;
        this.price = price;
        this.nameFood = nameFood;
    }
    public Food(){
        this.IDFood = 0;
        this.DVT = "";
        this.price = 0;
        this.nameFood = "";
    }

    public int getIDFood() {
        return IDFood;
    }

    public void setIDFood(int IDFood) {
        this.IDFood = IDFood;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }
  
}
