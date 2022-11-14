package lotto;

import domain.InputConverter;
import domain.LottoService;
import domain.Prize;
import ui.SystemMessage;
import ui.UserInput;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoService lottoService = new LottoService();

            int numberOfLotto = getNumberOfLotto(lottoService);
            List<Lotto> lottos = publishLottos(lottoService, numberOfLotto);
            List<Integer> winningNumbers = enterWinningNumber();
            int bonusNumber = enterBonusNumber();

            Map<Prize, Integer> winningDetails = lottoService.getWinningDetails(winningNumbers, lottos, bonusNumber);
            printUserLottoResult(lottoService, winningDetails);
        } catch (IllegalArgumentException e) {
            SystemMessage.printErrorMessage(e.getMessage());
        }
    }

    private static int getNumberOfLotto(LottoService lottoService) {
        SystemMessage.askBuyLotto();
        String money = UserInput.buyLotto();
        int numberOfLotto = lottoService.getNumberOfLotto(money);
        SystemMessage.printBuyLotto(numberOfLotto);
        return numberOfLotto;
    }

    private static List<Lotto> publishLottos(LottoService lottoService, int numberOfLotto) {
        List<Lotto> lottos = lottoService.publishLotto(numberOfLotto);
        SystemMessage.printPublishLottoResult(lottos);
        System.out.println("");
        return lottos;
    }

    private static List<Integer> enterWinningNumber() {
        SystemMessage.askWinningNumbers();
        String winningNumbersInput = UserInput.enterWinningLottoNumber();
        return InputConverter.getWinningNumbers(winningNumbersInput);
    }

    private static int enterBonusNumber() {
        SystemMessage.askBonusNumbers();
        String bonusNumberInput = UserInput.enterBonusNumber();
        return InputConverter.getNumber(bonusNumberInput);
    }

    private static void printUserLottoResult(LottoService lottoService, Map<Prize, Integer> winningDetails) {
        SystemMessage.printPrizeResult(winningDetails);
        SystemMessage.printEarnRate(lottoService.getEarningRate());
    }
}
