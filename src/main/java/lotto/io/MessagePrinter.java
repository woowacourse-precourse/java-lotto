package lotto.io;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class MessagePrinter {
    public static void printMoneyInputRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printGeneratedLottoQuantity(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void printGeneratedLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningNumbersInputRequest() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputRequest() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningDetails(Map<Integer, Integer> winningDetails) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개\n", winningDetails.get(5_000)) +
                String.format("4개 일치 (50,000원) - %d개\n", winningDetails.get(50_000)) +
                String.format("5개 일치 (1,500,000원) - %d개\n", winningDetails.get(1_500_000)) +
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningDetails.get(30_000_000)) +
                String.format("6개 일치 (2,000,000,000원) - %d개", winningDetails.get(2_000_000_000)));
    }

    public static void printEarningRate(double earningRate) {
        String roundedEarningRate = String.format("%.1f", earningRate);
        System.out.println("총 수익률은 " + roundedEarningRate +"%입니다.");
    }

    public static void printErrorMessage(Exception exception) {
        String errorMessage = exception.getMessage();
        System.out.println(errorMessage);
    }
}
