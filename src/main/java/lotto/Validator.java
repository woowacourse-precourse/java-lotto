package lotto;

public class Validator {
    public static boolean isNumeric(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 숫자로 입력해주세요.");
        }
        return true;
    }

    public static boolean isThousands(String input) throws IllegalArgumentException {
        int num = Integer.parseInt(input);
        if(num % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력해주세요.");
        }
        return true;
    }

}