package lotto;

import lotto.domain.*;
import lotto.service.LottoRankAggregation;
import lotto.view.InputView;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame(new LottoShop(new Lotto(new ArrayList<>())), new WinningLotto(new LottoRankAggregation()));
        Customer customer = new Customer();

        try {
            int amount = InputView.readAmount();
            game.start(customer, amount);
            game.winningHistory(customer, amount);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
