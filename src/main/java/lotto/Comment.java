package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.Map;

public class Comment {

    public String printPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();
        return money;
    }

    public void printCountBuyingTickets(int ticketCount, LottoGroup lottoGroup) {
        System.out.println(ticketCount + "개를 구매했습니다.");
        for (Lotto lotto : lottoGroup.getAllLotteryTickets()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public String printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println();
        return winningNumbers;
    }

    public String printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }

    public void printWinningStats() {
        System.out.println("당첨 통계\n---");
    }

    public void printWinningRankCount(RankType rankType, Map<RankType, Integer> numberOfWinning) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        if (!rankType.equals(RankType.SECOND)) {
            System.out.println(rankType.getMatchCount() + "개 일치 (" + decFormat.format(rankType.getReward()) + "원) - " + numberOfWinning.get(rankType) + "개");
            return;
        }
        System.out.println(rankType.getMatchCount() + "개 일치, 보너스 볼 일치 (" + decFormat.format(rankType.getReward()) + "원) - " + numberOfWinning.get(rankType) + "개");
    }

    public void printTotalReturn(double totalReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", totalReturn) + "%입니다.");
    }

    public void printErrorMessage() {
        System.out.println("[ERROR]: 사용자의 입력이 잘못 되었습니다.");
    }
}
