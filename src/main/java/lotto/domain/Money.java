package lotto.domain;

public class Money {
    private static final String Input_Money_Nope = "[ERROR] Input only number";
    private static final String ONLY_NUMBER = "[0-9]+";
    private int money;

    public Money(String money){
        this.money = -1;
        if (validateMoney(money))
            this.money = convertToInt(money);
    }

    private void Input_Nope(){
        System.out.println(Input_Money_Nope);
    }
    public  boolean validateMoney(String money){
        if (!money.matches(ONLY_NUMBER)) {
            Input_Nope();
            return false;
        }
        return true;
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] " + e);
        }
    }

    public int Get_money(){
        return money;
    }
}
