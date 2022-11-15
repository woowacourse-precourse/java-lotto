package lotto;

import domain.InputConverter;
import domain.LottoService;
import domain.Prize;
import ui.SystemMessage;
import ui.UserInput;

import java.util.List;
import java.util.Map;

import static util.Constant.DUPLICATE_BONUS_NUMBER_ERROR;

// 어플리케이션 실행을 담당하는 클래스
public class Application {
    public static void main(String[] args) {
        try {
            LottoService lottoService = new LottoService();

            List<Lotto> lottos = getLottos(lottoService);
            List<Integer> winningNumbers = enterWinningNumber();
            int bonusNumber = enterBonusNumber();
            isDuplicatedBonusNumber(winningNumbers, bonusNumber);

            Map<Prize, Integer> winningDetails = lottoService.getWinningDetails(winningNumbers, lottos, bonusNumber);
            printUserLottoResult(lottoService, winningDetails);
        } catch (IllegalArgumentException e) {
            SystemMessage.printErrorMessage(e.getMessage());
        }
    }

    private static List<Lotto> getLottos(LottoService lottoService) {
        int numberOfLotto = getNumberOfLotto(lottoService);
        return publishLottos(lottoService, numberOfLotto);
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

    private static void isDuplicatedBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    private static void printUserLottoResult(LottoService lottoService, Map<Prize, Integer> winningDetails) {
        SystemMessage.printPrizeResult(winningDetails);
        SystemMessage.printEarnRate(lottoService.getEarningRate());
    }
}
