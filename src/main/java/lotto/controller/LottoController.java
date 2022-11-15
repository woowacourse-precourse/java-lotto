package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public LottoController() {
    }

    public void play() {
        try {
            int money = InputView.money();
            List<Lotto> ticket = LottoGenerator.automatic(LottoGenerator.maximum(money));
            OutputView.ticket(ticket);

            List<Integer> winningNumber = InputView.winningNumber();
            List<Rank> result = result(ticket, winningNumber, InputView.bonusNumber(winningNumber));
            OutputView.result(result, money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Rank> result(List<Lotto> lottosTicket, List<Integer> winningNumbers, int bonusNumber) {
        return lottosTicket.stream()
                .map(e -> e.result(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }
}
