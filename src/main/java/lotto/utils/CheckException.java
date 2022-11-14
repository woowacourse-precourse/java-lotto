package lotto.utils;

public class CheckException {
    public static void checkAmount(int amount) throws IllegalArgumentException {
        try {
            if (amount <= 0 || (amount % 1000) > 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}
