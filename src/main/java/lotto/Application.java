package lotto;

import java.util.List;
import lotto.domain.BuyLotto;
import lotto.domain.Output;
import lotto.domain.PrintMessages;
import lotto.domain.Rank;
import lotto.domain.WonAnalysis;
import lotto.domain.WonNumber;

public class Application {


    public static void main(String[] args) {
        try {

            System.out.println(PrintMessages.INPUT_MONEY.getMessage());

            BuyLotto by = new BuyLotto();
            by.GenerateLottoNumber();
            System.out.println(by.cntLotto + PrintMessages.LOTTO_COUNT.getMessage());
            by.showLottos();

            System.out.println(PrintMessages.INPUT_NUMBER.getMessage());
            WonNumber wonNumber = new WonNumber();
            System.out.println(PrintMessages.INPUT_BONUS_NUMBER.getMessage());
            wonNumber.bonusNumber();

            WonAnalysis wonAnalysis = new WonAnalysis();
            List<Rank> Result = wonAnalysis.Result(wonNumber.wonNumber, by.lottoList, wonNumber.bonusNumber);

            Output output = new Output();
            output.printLottoResult(Result);
            String percent = wonAnalysis.totalPercent(Result);
            output.printPercent(percent);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
