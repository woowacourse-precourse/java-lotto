package lotto;

import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.standard.PresentationDirection;
import lotto.domain.ConsumerResult;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;
import org.assertj.core.util.Arrays;

public class Application {
    public static void main(String[] args) {

        PurchaseLotto purchaseLotto = new PurchaseLotto();
        LottoResult lottoResult = new LottoResult();
        ConsumerResult consumerResult = new ConsumerResult();
        int count = purchaseLotto.inputMoney();
        List<List<Integer>> totalLotto = purchaseLotto.myLotto(count);
        purchaseLotto.printMyLotto(totalLotto);
        List<Integer> lottoNumber = lottoResult.inputLottoNumber();
        int bonusNumber = lottoResult.inputBonusNumber(lottoNumber);
        List<Integer> result= purchaseLotto.myLottoResult(lottoNumber, bonusNumber, totalLotto);
        consumerResult.printResult(consumerResult.winLotto(result));
        consumerResult.printProfit(count*1000,consumerResult.winLotto(result));
    }
}
