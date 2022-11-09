package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;

public class Application {
    final static int lottoPrice = 1000;
    final static String lottoPriceString = addComma(lottoPrice);
    final static String errorMsg1 = "[ERROR] 숫자를 입력해 주세요.";
    final static String errorMsg2 =
            "[ERROR] 구입 금액은 " + lottoPriceString + "원으로 나누어 떨어지는 자연수여야 합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static String addComma(int number) {
        final DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(number);
    }

    public static Integer readNumber() throws IllegalArgumentException{
        String userInput = Console.readLine();
        try {
            return Integer.valueOf(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(errorMsg1);
        }
    }

    public static void validateMoney(int money) throws IllegalArgumentException{
        if (money <= 0 || money % lottoPrice != 0) {
            throw new IllegalArgumentException(errorMsg2);
        }
    }
}
