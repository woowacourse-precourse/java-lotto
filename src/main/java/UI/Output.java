package UI;

import lotto.Ranking;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Output {
    private static final String INPUTPURCHASEAMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUTWINNINGNUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUTBONUSNUMBER = "보너스 번호를 입력해 주세요";
    private static final String BUYINGLOTTO = "%d개를 구매했습니다.\n";
    private static final String WINSTATISTICS = "당첨 통계\n---\n";
    private static final String NUMBEROFMATCH = "%d개 일치";
    private static final String MATCHBOUNSNUMBER = ", 보너스 볼 일치";
    private static final String PRIZEMONEY_AND_NUMBEROFWIN = " (%s원) - %d개\n";
    private static final String PROFITRATE = "총 수익률은 %.1f%%입니다.";

    public void inputPurchaseAmount() {
        System.out.println(INPUTPURCHASEAMOUNT);
    }

    public void inputWinningNumber() {
        System.out.println(INPUTWINNINGNUMBERS);
    }

    public void inputBounsNumber() {
        System.out.println(INPUTBONUSNUMBER);
    }

    public void printRandomLottoNumbers(List<List<Integer>> randomLottoNumbers) {
        int numberOfLotto = randomLottoNumbers.size();
        System.out.printf(BUYINGLOTTO, numberOfLotto);

        for (List<Integer> number : randomLottoNumbers) {
            System.out.println(number);
        }
    }

    public void printLottoRankingResult(Map<Ranking, Integer> rankingResults) {
        System.out.print(WINSTATISTICS);

        Set<Ranking> rankings = rankingResults.keySet();

        for (Ranking ranking : rankings) {
            int match = ranking.getMatch();
            String money = ranking.getMoney();
            Integer numberOfWin = rankingResults.get(ranking);

            System.out.printf(NUMBEROFMATCH, match);
            if (ranking.isBonusStatus()) {
                System.out.print(MATCHBOUNSNUMBER);
            }
            System.out.printf(PRIZEMONEY_AND_NUMBEROFWIN, money, numberOfWin);
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFITRATE, profitRate);
    }
}
