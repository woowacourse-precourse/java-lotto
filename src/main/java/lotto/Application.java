package lotto;

import java.util.List;
import lotto.domain.BuyLotto;
import lotto.domain.Output;
import lotto.domain.Rank;
import lotto.domain.WonAnalysis;
import lotto.domain.WonNumber;

public class Application {


    public static void main(String[] args) {
        try {
            Output output = new Output();
            BuyLotto by = new BuyLotto();

            output.printInputMoney();
            by.inputPrice();
            by.GenerateLottoNumber();
            output.printBuyLotto(by.lottoList);
            output.printInputMessage();

            WonNumber wonNumber = new WonNumber();
            output.inputBonusNumber();
            wonNumber.bonusNumber();
            WonAnalysis wonAnalysis = new WonAnalysis();
            List<Rank> Result = wonAnalysis.Result(wonNumber.wonNumber, by.lottoList);
            output.printLottoResult(Result);
            String percent = wonAnalysis.Percent(Result);
            output.printPercent(percent);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
