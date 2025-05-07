import java.util.List;

class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber){//0
        if (allItems == null){//А
            throw new RuntimeException("allItems list can't be null!");//B
        }

        double sum = 0;//C

        for (int i = 0; i < allItems.size(); i++){//D
            Item item = allItems.get(i);//E
            if (item.getName() == null || item.getName().length() == 0){//F
                throw new RuntimeException("Invalid item!");//G
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){//H
                sum -= 30;//I
            }

            if (item.getDiscount() > 0){//J
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();//K
            }
            else {//L
                sum += item.getPrice()*item.getQuantity();//M
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {//N
            String allowed = "0123456789";//O
            char[] chars = cardNumber.toCharArray();//P
            for (int j = 0; j < cardNumber.length(); j++) {//Q
                char c = cardNumber.charAt(j);//R
                if (allowed.indexOf(c) == -1) {//S
                    throw new RuntimeException("Invalid character in card number!");//T
                }
            }
        }
        else{//U
            throw new RuntimeException("Invalid card number!");//V
        }

        return sum;//W

    }
}