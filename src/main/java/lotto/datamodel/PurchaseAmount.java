package lotto.datamodel;

public class PurchaseAmount {
    private static final int STANDARD_MONEY = 1000;
    private final int moneyCount;

    public PurchaseAmount(String input) {
        int money = numberValid(input);
        moneyCount = moneyValid(money);
    }

    public int getMoneyCount() {
        return moneyCount;
    }

    private int numberValid(String input) {
        int check;
        try {
            check = Integer.parseInt(input);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
        return check;
    }

    private int moneyValid(int money){
        if (money % STANDARD_MONEY != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
        return money / STANDARD_MONEY;
    }
}
