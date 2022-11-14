package lotto.datamodel;

public class PurchaseAmount {
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
        if (money % 1000 != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }
}
