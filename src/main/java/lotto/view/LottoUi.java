package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;

import java.util.List;

import static lotto.util.LottoUtils.printEnter;
import static lotto.values.Constants.Console.*;

public class LottoUi {
    private static final LottoUi lottoUi = new LottoUi();
    public static LottoUi getLottoUi(){
        return lottoUi;
    }
    private final LottoService lottoService = LottoService.getLottoService();


    public static void printInputWinningNumberMessage(){
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumberMessage(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoCnt(int lottoCnt) {
        System.out.printf(OUTPUT_CNT_MESSAGE, lottoCnt);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumbers().toString()));
    }

    public static void printTotalProfitMessage(String percent) {
        System.out.printf(TOTAL_PROFIT_PERCENT_MESSAGE, percent);
    }

    public int inputBonusNumber() {
        int bonusNumber;

        printInputBonusNumberMessage();
        bonusNumber = lottoService.generateBonusNumber();
        printEnter();

        return bonusNumber;
    }

    public List<Lotto> purchaseLotto(Money money) {
        int lottoCnt = lottoService.getLottoCntByMoney(money);
        List<Lotto> lottos = lottoService.generateLottos(lottoCnt);

        printLottoCnt(lottoCnt);
        printLottoNumbers(lottos);
        printEnter();

        return lottos;
    }

    public Lotto inputWinningLotto() {
        Lotto winningLotto;

        printInputWinningNumberMessage();
        winningLotto = lottoService.generateWinningLotto();
        printEnter();

        return winningLotto;
    }
}
