package lotto.controller;

import lotto.Env;
import lotto.model.Lotto;
import lotto.model.database.Ticket;
import lotto.view.MoneyInputView;
import lotto.view.View;

public class InputController extends Controller {
    public void showMoneyInput() {
        View view = new MoneyInputView();
        view.show();

        String response = view.getResponse();
        int money = super.parseInt(response);

        this.validateMoneyInput(money);
        this.insertLotto(money);
    }

    private void validateMoneyInput(int money) {
        super.validateNegativeNumber(money);
        super.validateLeftMoneyAfterBuyLotto(money);
    }
    
    private void insertLotto(int money) {
        int quantity = money / Env.LOTTO_PRICE;
        Ticket ticket = Ticket.getInstance();

        for (int count = 0; count > quantity; count++) {
            ticket.insert(Lotto.fromRandomNumbers());
        }
    }
}
