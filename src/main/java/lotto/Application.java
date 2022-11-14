package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private final static String inputPriceMessage = "구입금액을 입력해 주세요.";
    private final static String inputWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private final static String priceNonNumericErrorMessage = "[ERROR] 구입금액은 숫자여야 합니다.";
    private final static String bonusNonNumericErrorMessage = "[ERROR] 보너스 번호는 숫자여야 합니다.";

    public static void main(String[] args) {
        int price = readNumber(inputPriceMessage, priceNonNumericErrorMessage);
        Simulator lottoSimulator = new Simulator(price);
        printPurchaseHistory(lottoSimulator);
    }

    private static int readNumber(String outputMessage, String errorMessage) {
        System.out.println(outputMessage);
        try {
            return parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void printPurchaseHistory(Simulator lottoSimulator) {
        System.out.println(lottoSimulator.getQuantity() + "개를 구매했습니다.");
        lottoSimulator.getLottos()
                .stream()
                .forEach(System.out::println);
    }
}
