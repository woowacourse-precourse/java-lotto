package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UserInterface {
    public static void printPurchaseMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int inputPurchaseMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static void printWinNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> inputWinNumbers() {
        String inputNumbers = Console.readLine();
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            winNumbers.add(Integer.parseInt(number));
        }
        return winNumbers;
    }

    public static void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.\n", lottoList.size());
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getLottoNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printWinResult(HashMap<LottoRank, Integer> winResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winResult.getOrDefault(LottoRank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winResult.getOrDefault(LottoRank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winResult.getOrDefault(LottoRank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winResult.getOrDefault(LottoRank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winResult.getOrDefault(LottoRank.FIRST, 0));
    }

    public static void printIncomePercent(float incomePercent) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", incomePercent);
    }
}
