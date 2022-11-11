package lotto;

public class Money {
    public final int number;

    public Money(String inputMoney){
        int money = convertNumber(inputMoney);
        validateMoney(money);

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
            throw new IllegalArgumentException("[ERROR]: 로또를 구매할 돈의 최소 단위는 반드시 1000원이어야 합니다.");
        }
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR]: 로또를 구매할 돈은 반드시 1000원 이상이어야 합니다.");
        }
    }

    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 48 || element > 57) {
                throw new IllegalArgumentException("[ERROR]: 숫자만 입력할 수 있습니다.");
            }
        }
    }
}
