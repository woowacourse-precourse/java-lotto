package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.model.Cashier;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Statistics;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    Cashier cashier = new Cashier();
    Statistics statistics = new Statistics();
    List<Lotto> lottoTicket = new ArrayList<>();

    public void playLotto() {
        try {
            getPlayerInput();
            Map<String, Integer> prizeSet = calculatePrizeQuantity();
            float stat = statistics.myStat(cashier.getReceivedMoney());
            printResult(prizeSet, stat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Map<String, Integer> calculatePrizeQuantity() {
        return statistics.checkPrizeQuantity(cashier.getAnswerNumber(), cashier.getBonusNumber(), lottoTicket);
    }

    private void printResult(Map<String, Integer> PrizeSet, float statistics) {
        Output.printYourStatistics(
            PrizeSet,
            statistics);
    }

    private void getPlayerInput() {
        cashier.inputPlayerMoney(Input.getYourMoney());
        generateLottoTickets(cashier.getReceivedMoney());
        cashier.inputPlayerAnswerNumber(Input.getAnswerNumbers());
        cashier.inputPlayerBonusNumber(Input.getBonusNumber());
    }

    public List<Lotto> generateLottoTickets(int receivedMoney) {
        List<List<Integer>> tickets = LottoGenerator.createLottos(receivedMoney);
        for (List<Integer> value : tickets) {
            System.out.println(value);
            lottoTicket.add(new Lotto(value));
        }
        return lottoTicket;
    }
}
