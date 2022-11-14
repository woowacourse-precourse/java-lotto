package lotto;

public class DivideInputMoneyGenerator {
    public static boolean divideInputMoney(int inputMoney) throws IllegalArgumentException{
        int remainder = inputMoney % 1000;
        if(remainder != 0) {
            throw new IllegalArgumentException("[ERROR] 값을 잘못 입력하셨습니다.");
        }
        return true;
    }
}
