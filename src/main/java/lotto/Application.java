package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final static String inputPriceMessage = "구입금액을 입력해 주세요.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static String readPrice(String outputMessage) {
        System.out.println(outputMessage);
        return Console.readLine();
    }
}
