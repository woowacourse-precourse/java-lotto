package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InputConfig;
import lotto.domain.Lotto;
import lotto.mapper.InputMapper;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;

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

    public long inputPurchaseAmount() {
        inputView.printInputPurchaseAmount();
        String amount = Console.readLine();
        InputConfig.checkPurchaseInput(amount);
        return Long.parseLong(amount) / LOTTO_PRICE;
    }

    public void printPurchasedLotto(List<Lotto> lottoList) {
        outputView.printPurchaseCount(lottoList.size());
        outputView.printAllLotto(lottoList);
    }

    public Set<Integer> inputPrizeLottoNumber() {
        inputView.printInputPrizeLottoNumber();
        String input = Console.readLine();
        Set<Integer> prize = inputMapper.stringToSetSplitBy(input, ",");
        //InputConfig
        return prize;
    }

    public int inputBonusNumber() {
        inputView.printInputBonusNumber();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
