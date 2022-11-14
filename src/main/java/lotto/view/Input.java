package lotto.view;

public class Input {
    public static int getPrice() {
        System.out.println(Message.PURCHASE_AMOUNT.print());
        return getNumber();
    }
    
}
