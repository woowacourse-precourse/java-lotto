package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class Output {

    public void printGetMoney() {
        System.out.println("구매금액을 입력해주세요.");
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printGetWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void pringGetWinningBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoResultTitle() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printLottoResultAboutRank(int matchNumber, int priceMoney, int countOfMatch) {
        System.out.println(matchNumber + "개 일치 (" + priceMoney + ") - " + countOfMatch + "개");
    }

    public void printLottoResultAboutRankWithBonus(int matchNumber, int priceMoney, int countOfMatch) {
        System.out.println(matchNumber + "개 일치, 보너스 볼 일치 (" + priceMoney + ") - " + countOfMatch + "개");
    }

    public void printTotalRate(double totalRate) {
        System.out.println("총 수익률은 " + totalRate + "%입니다.");
    }

    public static void printErrorAndExit(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println("게임을 종료합니다");
    }
}
