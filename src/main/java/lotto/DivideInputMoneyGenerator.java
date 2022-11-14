package lotto;

public class DivideInputMoneyGenerator {
    public static boolean divideInputMoney(int inputMoney) {
        int remainder = inputMoney % 1000;
        if(remainder != 0) {
            return false;
        }
        return true;
    }
}
