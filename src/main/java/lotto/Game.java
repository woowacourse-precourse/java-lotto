package lotto;

public class Game {

    static UI ui = new UI();
    static Validation validation = new Validation();
    static int purchase;

    static void setPurchase(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        purchase = Integer.parseInt(input);
        validation.checkDividable(purchase);
    }

}
