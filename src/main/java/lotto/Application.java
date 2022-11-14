package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final static String inputPriceMessage = "구입금액을 입력해 주세요.";
    public static void main(String[] args) {
        int price = readPrice(inputPriceMessage);
    }

    private static int readPrice(String outputMessage) {
        System.out.println(outputMessage);
        try {
            return parseInt(Console.readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }
}
