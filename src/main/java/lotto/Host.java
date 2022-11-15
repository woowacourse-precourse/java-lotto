package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Host {

    List<Integer> winNumbers;
    int bonusNumber;

    List<List<Integer>> issuanceHistory;

    public Host() {
        issuanceHistory = new ArrayList<>();
    }

    public void registerWinningInformation(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto issueLotto() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers;
        while (true) {
            numbers = numberGenerator.generateSixRandomNumbers();
            if (!isIssued(numbers)) {
                issuanceHistory.add(numbers);
                break;
            }
        }
        return new Lotto(numbers);
    }

    private boolean isIssued(List<Integer> numbers) {
        return issuanceHistory.stream().anyMatch(e -> e.equals(numbers));
    }

    public void showWinResult(User user) {
        System.out.println("당첨 통계\n---");
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer(winNumbers, bonusNumber);
        DecimalFormat df = new DecimalFormat("###,###");
        List<Lotto> userLotto = user.getWholeLotto();
        int[] rankRecord = resultAnalyzer.makeRankRecord(userLotto);
        for (int i = 5; i > 0; i--) {
            Prize prize = Prize.valueOfRank(i);
            System.out.printf("%s (%s원) - %d개\n", prize.getDescription(), df.format(prize.getCashPrize()), rankRecord[i]);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", resultAnalyzer.calculateRateOfReturn(userLotto, rankRecord));
    }
}
