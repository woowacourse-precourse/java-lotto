package lotto.LottoGame;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.winning.WinningStatistical;
import lotto.winning.WinningStatisticalFormatter;

public class LottoGameKoreanConsolePrinter implements LottoGamePrinter {
    private final WinningStatisticalFormatter winningStatisticalFormatter;

    public LottoGameKoreanConsolePrinter(WinningStatisticalFormatter winningStatisticalFormatter) {
        this.winningStatisticalFormatter = winningStatisticalFormatter;
    }

    @Override
    public void printRequestBuyingPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printBoughtLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }

    @Override
    public void printRequestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printRequestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void printWinningStatistical(WinningStatistical winningStatistical) {
        System.out.println(winningStatisticalFormatter.format(winningStatistical));
    }
}
