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
        int count = purchaseLotto.inputMoney();//금액입력
        List<List<Integer>> totalLotto = purchaseLotto.myLotto(count);//나의로또번호저장
        purchaseLotto.printMyLotto(totalLotto);//나의로또출력
        List<Integer> lottoNumber = lottoResult.inputLottoNumber();//당첨로또번호입력
        int bonusNumber = lottoResult.inputBonusNumber(lottoNumber);//보너스 입력
        List<Integer> totalResult = consumerResult.winLotto(totalLotto,lottoNumber,bonusNumber);
        consumerResult.printResult(totalResult);
        consumerResult.printProfit(count*1000,totalResult);
    }
}
