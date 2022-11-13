package lotto.domain;

public class Money {
    private static final String ONLY_NUMBER = "[0-9]+";
    private final int money;

    public Money(String money){
        if(validateMony(money))
            money = "0";
        this.money = convertToInt(money);
    }

    public Boolean validateMony(String money){
        return  !money.matches(ONLY_NUMBER);
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] " + e);
        }
    }
}
