package lotto.model;

import lotto.message.PrintError;

public class Money {
    private final int number;

    public Money(String inputMoney){
        int money = convertNumber(inputMoney);
        validateMoney(money);
        validateMoneyRange(money);

        this.number = money/1000;
    }

    public int getMoney () {
        return this.number;
    }

    public int convertNumber (String inputMoney) {
        int money;

        isRealNumber(inputMoney);
        money = Integer.parseInt(inputMoney);
        return money;
    }

    public void validateMoney(int money) {
        if (money % 1000 != 0){
            System.out.println(PrintError.MONEY_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public void validateMoneyRange (int money){

        if (money < 1000) {
            System.out.println(PrintError.MONEY_RANGE);
            throw new IllegalArgumentException();
        }
    }
    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 48 || element > 57) {
                System.out.println(PrintError.NUMBER_SIZE);
                throw new IllegalArgumentException();
            }
        }
    }
}
