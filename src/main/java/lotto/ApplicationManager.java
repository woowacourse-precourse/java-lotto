package lotto;

public class ApplicationManager {

    public void proceed() {
        UserAmount userAmount = new UserAmount(Input.inputUserAmount());
        Output.printLottoCount(userAmount);
        LottoNumbers lottoNumbers = new LottoNumbers(LottoFactory.createLottoByMoney(userAmount));
        Output.printLottoNumber(lottoNumbers);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(Lotto.from(Input.inputLottoWinningNumber()),
                new LottoBonusNumber(Input.inputLottoBonusNumber()));
        Results results = new Results();
        results.addDefaultValue();
        int totalAmount = lottoNumbers.compareResult(lottoWinningNumber, results);
        printResults(results, totalAmount, userAmount);
    }

    private void printResults(Results totalLottoRankingCount, int totalAmount, UserAmount money) {
        Output.printRankingMsg();
        for (Ranking ranking : Ranking.values()) {
            Output.printRanking(ranking, totalLottoRankingCount);
        }
        Output.printProfitsRate(totalAmount, money);
    }

}
