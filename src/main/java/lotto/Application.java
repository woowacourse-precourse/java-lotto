package lotto;

import lotto.LottoGame.LottoGame;
import lotto.LottoGame.LottoGameKoreanConsolePrinter;
import lotto.LottoGame.LottoGamePrinter;
import lotto.lotto.LottoGenerator;
import lotto.lotto.RandomLottoGenerator;
import lotto.winning.WinningStatisticalFormatter;
import lotto.winning.WinningStatisticalResultKoreanFormatter;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        WinningStatisticalFormatter winningStatisticalFormatter = new WinningStatisticalResultKoreanFormatter();
        LottoGamePrinter lottoGamePrinter = new LottoGameKoreanConsolePrinter(winningStatisticalFormatter);
        LottoGame lottoGame = new LottoGame(lottoGenerator, lottoGamePrinter);
        lottoGame.run();
    }
}
