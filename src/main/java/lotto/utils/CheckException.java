package lotto.utils;

public class CheckException {
    public static Integer checkAmount(String input) throws IllegalArgumentException {
        try {
            int amount = Integer.parseInt(input);
            if ((amount % 1000) > 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
            }
            return amount;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}
