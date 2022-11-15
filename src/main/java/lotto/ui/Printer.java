package lotto.ui;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class Printer {

    private Printer() {
    }


    public static void requestWinningNumber() {
        System.out.println("\n" + "당첨 번호를 입력해주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println("\n" + "보너스 번호를 입력해주세요.");

    }

    public static void requestLottoCount(int lottocount) {
        System.out.println(String.format("\n%d개를 구매했습니다", lottocount));
    }

    public static void requestMargin(double margin) {
        System.out.println("총 수익률은 " + margin + "%입니다.");
    }

    //구매한 로또 출력
    public static void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            StringBuilder stringBuilder = new StringBuilder("[");
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (int i = 0; i < lottoNumbers.size(); i++) {
                stringBuilder.append(String.valueOf(lottoNumbers.get(i)));
                if (i != lottoNumbers.size() - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");
            System.out.println(stringBuilder);
        }
    }

    public static void requestMatchResults(Map<String, Integer> lottoComparisonResults) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", lottoComparisonResults.get("fifthPlace"));
        System.out.printf("4개 일치 (50,000원) - %d개%n", lottoComparisonResults.get("fourthPlace"));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", lottoComparisonResults.get("thirdPlace"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", lottoComparisonResults.get("secondPlace"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", lottoComparisonResults.get("firstPlace"));
    }
}
