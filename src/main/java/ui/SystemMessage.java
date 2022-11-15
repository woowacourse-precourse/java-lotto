package ui;

import domain.Prize;
import lotto.Lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 시스템의 출력을 담당하는 클래스
public class SystemMessage {

    public static void printPrizeResult(Map<Prize, Integer> resultMap) {
        List<Prize> prizes = Arrays.stream(Prize.values())
                .filter(prize -> prize.ranking > 0)
                .sorted(Comparator.comparing(Prize::getRanking).reversed())
                .collect(Collectors.toList());

        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : prizes) {
            Integer numberOfPrize = resultMap.get(prize);
            System.out.println(prize.systemMessage + " - " + numberOfPrize + "개");
        }
    }

    public static void printPublishLottoResult(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getUserLottoNumbers()));
    }

    public static void printBuyLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public static void printEarnRate(double earnRate) {
        System.out.println("총 수익률은 " + earnRate + "%입니다.");
    }

    public static void askBuyLotto() {
        System.out.println("구매금액을 입력해 주세요");
    }

    public static void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public static void askBonusNumbers() {
        System.out.println("보너스 번호를 입력해주세요");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
