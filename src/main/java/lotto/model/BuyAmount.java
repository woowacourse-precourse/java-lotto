package lotto.model;

public class BuyAmount {

    private final int MONEY;

    public BuyAmount(String userInput) {
        validate(userInput);
        this.MONEY = Integer.parseInt(userInput);
    }

    private void validate(String userInput) {
        Utility.intValidate(userInput);
        notDivideValidate(Integer.parseInt(userInput));
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
