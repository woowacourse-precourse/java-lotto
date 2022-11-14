package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage);
        }
    }

    private void start() {

        LottoAmount lottoAmount = inputAmount();
        List<List<Integer>> lotto = buyLotto(lottoAmount);
        Lotto lottoNumber = inputLotto();
        BonusNumber bonusNumber = inputBonusNumber();
        WinningNumbers winningNumbers = resultNumbers(lottoNumber.getLottoNumber(), bonusNumber.getBonusNumber());
        statistics(winningNumbers, lotto);
        calculator(winningNumbers, lottoAmount);
    }

    private LottoAmount inputAmount() {
        int number = inputView.getPurchaseAmount();
        LottoAmount lottoAmount = new LottoAmount(number);
        outputView.printBuyLottoTicket(number); // @@개를 구매했습니다.
        return lottoAmount;
    }

    private List<List<Integer>> buyLotto(LottoAmount lottoAmount) {
        List<List<Integer>> lottoNumbers = lottoAmount.buyLotto();
        outputView.printBuyLotto(lottoNumbers); // 구매 로또 목록
        return lottoNumbers;
    }
    private Lotto inputLotto() {
        List<Integer> numbers = inputView.getWinningNumbers();
        return new Lotto(numbers);
    }

    private BonusNumber inputBonusNumber() {
        int number = inputView.getBonusNumber();
        return new BonusNumber(number);
    }

    private WinningNumbers resultNumbers(List<Integer> lottoNumber, int bonusNumber) {
        return new WinningNumbers(lottoNumber, bonusNumber);
    }

    private void statistics (WinningNumbers winningNumbers, List<List<Integer>> buyLottoNumbers) {
        winningNumbers.makeResult(buyLottoNumbers);
        Map<Rank, Integer> totalResult = winningNumbers.getTotalResult();
        outputView.printStatistics(totalResult);
    }

    private void calculator(WinningNumbers winningNumbers, LottoAmount lottoAmount) {
        double percentage = winningNumbers.calculatorRevenue(lottoAmount.getPurchaseAmount());
        outputView.printPercentage(percentage);
    }
}
