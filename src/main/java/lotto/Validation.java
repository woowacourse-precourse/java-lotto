package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final String numberPattern = "^[0-9]+$";

    public static void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 사이즈가 6이 아닙니다.");
        }
    }

    public static int numberValidate(String number){
        if(!(Pattern.matches(numberPattern, number))){
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }
        return Integer.parseInt(number);
    }

    public static int moneyValidate(String number){
        int convertNumber = numberValidate(number);

        if(convertNumber % 1000 != 0 || convertNumber < 1000){
            throw new IllegalArgumentException("[ERROR] 1000원 이상이고 1000원으로 나누어떨어지는 금액이어야 합니다.");
        }

        return convertNumber;
    }
}
