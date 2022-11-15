package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InputConfig;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.InputMapper;

import java.util.List;
import java.util.Map;

public class ViewController {
    private final long LOTTO_PRICE = InputConfig.LOTTO_PRICE;

    private final InputView inputView;
    private final OutputView outputView;
    private final InputMapper inputMapper;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputMapper = new InputMapper();
    }

    public void printStatisticsByRank(Map<Rank, Integer> result) {
        outputView.printStatisticStart();

        result.entrySet().stream().forEach(entry -> outputView.printStatisticsByRank(entry.getKey(), entry.getValue()));
        outputView.flush();
    }

    public void printProfitPercentage(float profit) {
        outputView.printTotalProfitPercent(profit);
        outputView.flush();
    }

    public long inputPurchaseAmount() {
        inputView.printInputPurchaseAmount();
        String input = Console.readLine().trim();
        InputConfig.checkPurchaseInput(input);

        inputView.printNewLine();
        return Long.parseLong(input) / LOTTO_PRICE;
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
        String input = Console.readLine().trim();

        List<Integer> prize = inputMapper.splitByComma(input);
        InputConfig.checkPrizeLotto(prize);

        inputView.printNewLine();
        return prize;
    }

    public int inputBonusNumber() {
        inputView.printInputBonusNumber();
        String input = Console.readLine().trim();
        InputConfig.checkBonusNumber(input);

        inputView.printNewLine();
        return Integer.parseInt(input);
    }
}
