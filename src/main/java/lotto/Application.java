package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoVendor lottoVendor = new LottoVendor();
        Buyer buyer = new Buyer();

        // 구입 금액을 입력하여, 로또를 구입한다.
        int purchaseMoney = inputView.inputPurchaseAmount();
        buyer.purchase(lottoVendor, purchaseMoney);//특정가게에서 금액/1000개의 로또를 구입한다.
        outputView.printLottoNumbers(buyer);

        // 추첨을 진행한다.
        List<Integer> winningNumber = inputView.inputWinningNumber();
        Lotto winningLotto = new Lotto(winningNumber);
        int bonusNumber = inputView.inputBonusNumber();
        LotteryMachine lotteryMachine = new LotteryMachine(winningLotto, bonusNumber);

        // 결과 분석 의뢰
        LottoRefer lottoRefer = new LottoRefer();
        Map<LottoPrize, Integer> result = lottoRefer.analyzeResult(lotteryMachine, buyer);

        // 당첨 통계 확인
        outputView.printWinningStats(result);

        // 수익률 확인
        outputView.printRate(lottoRefer.sumPrizes(), buyer.countHoldingLotto());

    }
}