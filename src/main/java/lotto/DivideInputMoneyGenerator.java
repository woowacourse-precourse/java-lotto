package lotto;

public class DivideInputMoneyGenerator {
    public static boolean divideInputMoney(int inputMoney) throws IllegalArgumentException{
        int remainder = inputMoney % 1000;
        if(remainder != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위 값을 입력해주세요.");
        }
        return true;
    }
}
