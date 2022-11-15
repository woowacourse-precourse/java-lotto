package lotto.model;

import lotto.message.PrintError;

public class Money {
    private final int number;

    public Money(String inputMoney){
        int money = convertNumber(inputMoney);
        validateMoney(money);

        this.number = money/1000;
    }

    // 필드값으로 저장된 보너스 번호 반환하는 메서드
    public int getMoney () {
        return this.number;
    }

    // 입력된 문자열을 숫자로 변환하는 메서드
    public int convertNumber (String inputMoney) {
        int money;

        isRealNumber(inputMoney);
        money = Integer.parseInt(inputMoney);
        return money;
    }

    // 입력된 돈이 1000으로 딱 나누어지는지 확인
    public void validateMoney(int money) {
        if (money % 1000 != 0){
            PrintError.MONEY_NUMBER.print();
            throw new IllegalArgumentException();
        }
        validateMoneyRange(money);
    }

    // 입력된 돈이 1000이상인지 확인
    public void validateMoneyRange (int money){

        if (money < 1000) {
            PrintError.MONEY_RANGE.print();
            throw new IllegalArgumentException();
        }
    }

    // 입력된 문자열이 전부 숫자인지 확인하는 메서드
    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 48 || element > 57) {
                PrintError.NUMBER_SIZE.print();
                throw new IllegalArgumentException();
            }
        }
    }
}
