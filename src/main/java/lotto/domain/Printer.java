package lotto.domain;

import lotto.util.ResultPrice;

import java.util.List;
import java.util.Map;

import static lotto.util.ResultPrice.*;

public class Printer {

    public static void printLottoGroup(List<Lotto> lottoGroup) {
        System.out.println(lottoGroup.size() + "개를 구매했습니다.");
        lottoGroup.forEach(lotto -> {
            System.out.println(lotto.getLotto());
        });
    }

    public static void printInfoMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printInfoInputResult() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInfoInputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printTotalScore(Map<ResultPrice, Integer> totalScore) {
        System.out.println(
                "당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - " + totalScore.get(FIFTH) + "개\n" +
                        "4개 일치 (50,000원) - " + totalScore.get(FOURTH) + "개\n" +
                        "5개 일치 (1,500,000원) - " + totalScore.get(THIRD) + "개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalScore.get(SECOND) + "개\n" +
                        "6개 일치 (2,000,000,000원) - " + totalScore.get(FIRST) + "개"
        );
    }

    public static void printMoneyReturn(Double moneyReturn) {
        System.out.println("총 수익률은 " + moneyReturn + "%입니다.");
    }
}
