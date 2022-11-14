package lotto;

import static lotto.view.Input.inputBonusNumber;
import static lotto.view.Input.inputPurchaseAmount;
import static lotto.view.Input.inputWinningNumbers;
import static lotto.view.Print.printBonusLottoNumberInput;
import static lotto.view.Print.printLottoResult;
import static lotto.view.Print.printPublishedLottoNumbers;
import static lotto.view.Print.printPurchaseMoneyInput;
import static lotto.view.Print.printPurchaseQuantity;
import static lotto.view.Print.printWinningLottoNumbersInput;
import static lotto.view.Print.printYield;

import java.util.List;
import java.util.Map;

public class LottoGameController {
    private LottoMachine lottoMachine = new LottoMachine();
    private LottoReader lottoReader = new LottoReader();

    public void start() {
        printPurchaseMoneyInput();
        int purchaseAmount = inputPurchaseAmount();

        List<Lotto> publishedAllLotto = publishLotto(purchaseAmount);

        // 당첨 로또 및 보너스 번호 발행
        printWinningLottoNumbersInput();
        Lotto winningLotto = lottoMachine.publishWinningLotto(inputWinningNumbers());
        printBonusLottoNumberInput();
        Bonus bonus = lottoMachine.publishBonus(inputBonusNumber(), winningLotto);

        // 구매한 로또의 당첨 결과 산출
        Map<LottoRank, Integer> lottoResult = lottoReader.createLottoResult(publishedAllLotto, winningLotto, bonus);
        printLottoResult(lottoResult);
        String lottoYield = lottoReader.calculateYield(purchaseAmount);
        printYield(lottoYield);
    }

    private List<Lotto> publishLotto(int purchaseAmount) {
        lottoMachine.inputMoney(purchaseAmount);
        List<Lotto> publishedAllLotto = lottoMachine.publishLotto();

        printPurchaseQuantity(publishedAllLotto.size());
        printPublishedLottoNumbers(publishedAllLotto);

        return publishedAllLotto;
    }
}
