package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoPurchaser;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        try{
            LottoPurchaser lottoPurchaser = new LottoPurchaser();
            LottoGenerator lottoGenerator = new LottoGenerator(lottoPurchaser.getPurchaseAmount());
            WinningNumbers winningNumbers = new WinningNumbers();
            Statistics statistics = new Statistics(winningNumbers, lottoGenerator.getLottos());
            System.out.println(statistics.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
