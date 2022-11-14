package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class LottoConsole {

    public static String readPurchaseAmount() {
        return Console.readLine();
    }

    public static String readWinningNumber() {
        return Console.readLine();
    }

    public static String readBonusNumber() {
        return Console.readLine();
    }

    public static void printPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요");
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.getLottos().size());
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberStr() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<LottoRank, Integer> winCount = lottoResult.getWinCount();
        List<LottoRank> lottoRanks = LottoRank.getLottoRankList();
        StringBuilder sb = new StringBuilder();
        for(LottoRank lottoRank : lottoRanks) {
            sb.append(lottoRank.getCorrectCount())
                .append("개 일치");
            if(lottoRank.isBonus()) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (")
                .append(lottoRank.getRewardStr())
                .append("원) - ")
                .append(winCount.get(lottoRank))
                .append("개\n");
        }
        System.out.print(sb.toString());
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoResult.getYield());
    }

    public static void printError(RuntimeException exception) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ERROR] ")
            .append(exception.getMessage());
        System.out.println(sb.toString());
    }
}
