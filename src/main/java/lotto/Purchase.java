package lotto;

public class Purchase {
    public int price;
    public Purchase(String price){
        validatePurchase();
        this.price = Integer.parseInt(price);
    }
    private void validatePurchase(){

    }
}
