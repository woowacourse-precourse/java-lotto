package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InputConfig;
import lotto.domain.Lotto;
import lotto.domain.Winner;
import lotto.mapper.InputMapper;
import lotto.service.LottoComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public void printPrizeStatistics() {
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

    public LottoComparator createComparator() {
        Set<Integer> prizeLottoSet = inputPrizeLottoNumber();
        int bonusNumber = inputBonusNumber();
        InputConfig.checkPrizeLottoWithBonus(prizeLottoSet, bonusNumber);

        List<Integer> prizeLottoList = new ArrayList<>(prizeLottoSet);
        return new LottoComparator(prizeLottoList, bonusNumber);
    }

    private Set<Integer> inputPrizeLottoNumber() {
        inputView.printInputPrizeLottoNumber();
        String input = Console.readLine();
        List<Integer> prize = inputMapper.splitBy(input, SPLIT_REGEX);
        return prize;
    }

    private int inputBonusNumber() {
        inputView.printInputBonusNumber();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
