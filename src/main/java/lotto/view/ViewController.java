package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InputConfig;
import lotto.domain.Lotto;
import lotto.domain.Winner;
import lotto.util.InputMapper;

import java.util.List;

public class ViewController {
    private final long LOTTO_PRICE = InputConfig.LOTTO_PRICE;
    private final String SPLIT_REGEX = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final InputMapper inputMapper;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputMapper = new InputMapper();
    }

    public void printStatisticsStart() {
        outputView.printStatisticStart();
    }

    public void printStatisticsByRank(Winner winner, int count) {
        outputView.printStatisticsByRank(winner, count);
        outputView.flush();
    }

    public long inputPurchaseAmount() {
        inputView.printInputPurchaseAmount();
        String amount = Console.readLine();
        InputConfig.checkPurchaseInput(amount);
        return Long.parseLong(amount) / LOTTO_PRICE;
    }

    public void printPurchasedLotto(List<Lotto> lottoList) {
        outputView.printPurchaseCount(lottoList.size());
        outputView.printAllLotto(lottoList);
        outputView.flush();
    }

    public List<Integer> inputPrizeLotto() {
        List<Integer> prizeLotto = inputPrizeLottoNumber();
        return prizeLotto;
    }

    private List<Integer> inputPrizeLottoNumber() {
        inputView.printInputPrizeLottoNumber();
        String input = Console.readLine();
        List<Integer> prize = inputMapper.splitBy(input, SPLIT_REGEX);
        return prize;
    }

    public int inputBonusNumber() {
        inputView.printInputBonusNumber();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
