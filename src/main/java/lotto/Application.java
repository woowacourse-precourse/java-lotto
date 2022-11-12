package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoPurchaser;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    public static void run(){
        LottoPurchaser lottoPurchaser = new LottoPurchaser();
        LottoGenerator lottoGenerator = new LottoGenerator(lottoPurchaser.getPurchaseAmount());
        WinningNumbers winningNumbers = new WinningNumbers();
        Statistics statistics = new Statistics(winningNumbers.getNumbers(), lottoGenerator.getLottos());
        System.out.println(statistics.toString());
    }
}
