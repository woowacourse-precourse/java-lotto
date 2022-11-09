package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ViewController {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public long inputPurchaseAmount() {
        inputView.printInputPurchaseAmount();
        String amount = Console.readLine();
        //TODO config 구현
        return Long.parseLong(amount);
    }

    public void dsf(List<List<Integer>> lottoList){
        // TODO n개를 구매했습니다 출력
        outputView.printAllLotto(lottoList);
    }

    public List<Integer> inputPrizeLottoNumber() {
        inputView.printInputPrizeLottoNumber();
        String input = Console.readLine();
        // TODO mapper, config 구현
        List<Integer> prize = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return prize;
    }

    public int inputBonusNumber() {
        inputView.printInputBonusNumber();
        String input = Console.readLine();
        // TODO config 구현
        return Integer.parseInt(input);
    }
}
