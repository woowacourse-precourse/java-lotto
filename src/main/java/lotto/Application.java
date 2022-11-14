package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final static String inputPriceMessage = "구입금액을 입력해 주세요.";

    public static void main(String[] args) {
        int price = readPrice(inputPriceMessage);
        Simulator lottoSimulator = new Simulator(price);
        printPurchaseHistory(lottoSimulator);
    }

    private static int readPrice(String outputMessage) {
        System.out.println(outputMessage);
        try {
            return parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private static void printPurchaseHistory(Simulator lottoSimulator) {
        System.out.println(lottoSimulator.getQuantity() + "개를 구매했습니다.");
        lottoSimulator.getLottos()
                .stream()
                .forEach(System.out::println);
    }
}
