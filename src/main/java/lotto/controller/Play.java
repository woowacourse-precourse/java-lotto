package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Cashier;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Statistics;
import lotto.view.Input;

public class Play {
    Cashier cashier = new Cashier();
    Statistics statistics = new Statistics();
    List<Lotto> lottoTicket = new ArrayList<>();

    public void play() {
        getPlayerInput();

    }

    private void getPlayerInput() {
        cashier.inputPlayerMoney(Input.getYourMoney());
        generateLottoTickets();
        cashier.inputPlayerAnswerNumber(Input.getAnswerNumbers());
        cashier.inputPlayerBonusNumber(Input.getBonusNumber());
    }

    private void generateLottoTickets() {
        List<List<Integer>> tickets = LottoGenerator.createLottos(cashier.getReceivedMoney());
        for (List<Integer> value : tickets) {
            System.out.println(value);
            lottoTicket.add(new Lotto(value));
        }
    }

    public static void main(String[] args) {
        new Play().play();

    }
}
