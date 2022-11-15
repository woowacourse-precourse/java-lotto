package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;

import java.util.List;

import static lotto.util.LottoUtils.printEnter;
import static lotto.values.Constants.Console.*;

public class LottoUi {

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

    public static int inputBonusNumber() {
        LottoService lottoService = LottoService.getLottoService();
        int bonusNumber = lottoService.generateBonusNumber();

        printInputBonusNumberMessage();
        printEnter();

        return bonusNumber;
    }

    public static List<Lotto> purchaseLotto(Money money) { // 구매 관련 이름으로 리팩터링
        LottoService lottoService = LottoService.getLottoService();
        int lottoCnt = lottoService.getLottoCntByMoney(money);
        List<Lotto> lottos = lottoService.generateLottos(lottoCnt);

        printLottoCnt(lottoCnt);
        printLottoNumbers(lottos);
        printEnter();

        return lottos;
    }

    public static Lotto inputWinningLotto() {
        LottoService lottoService = LottoService.getLottoService();
        Lotto winningLotto = lottoService.generateWinningLotto();

        printInputWinningNumberMessage();
        printEnter();

        return winningLotto;
    }
}
