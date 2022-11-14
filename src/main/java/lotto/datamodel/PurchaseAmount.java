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
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
        }
        return check;
    }

    private int moneyValid(int money){
        if (money % STANDARD_MONEY != 0 || money == 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 1000의 배수여야 합니다.");
        }
        return money / STANDARD_MONEY;
    }
}
