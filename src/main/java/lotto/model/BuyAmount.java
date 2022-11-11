package lotto.model;

public class BuyAmount {

    private final int MONEY;

    public BuyAmount(String userInput) {
        Utility.intValidate(userInput);
        int money = Integer.parseInt(userInput);
        notDivideValidate(money);
        this.MONEY = money;
    }

    private void notDivideValidate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나우어 떨어지지 않습니다.");
        }
    }

    public int getMONEY() {
        return MONEY;
    }

}
