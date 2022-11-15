package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOUtils {

    public static void requestSetAccount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void responseSetAccount(int account) {
        System.out.println(account);
    }

    public static void responseBoughtLottos(int lottos) {
        System.out.println(lottos + "개를 구매했습니다.");
    }

    public static void responseBoughtLottosList(List<List<Integer>> lottos) {
        lottos.stream().forEach(System.out::println);
    }

    public static void requestWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static String input() {
        return Console.readLine();
    }

    public static void responseResult(int[] sumResult) {
        System.out.println(PriceMessage.RIGHT_THREE.message() + sumResult[3] + "개");
        System.out.println(PriceMessage.RIGHT_FOUR.message() + sumResult[4] + "개");
        System.out.println(PriceMessage.RIGHT_FIVE.message() + sumResult[5] + "개");
        System.out.println(PriceMessage.RIGHT_FIVE_BONUS.message() + sumResult[6] + "개");
        System.out.println(PriceMessage.RIGHT_ALL.message() + sumResult[6] + "개");
    }

    public static void responseTotalYield(float yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public static void errorMessage() {
        System.out.println("[ERROR] 잘못된 입력 값입니다.");
    }
}
