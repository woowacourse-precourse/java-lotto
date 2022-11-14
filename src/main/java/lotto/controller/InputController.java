package lotto.controller;

import lotto.Env;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Raffle;
import lotto.model.database.Draw;
import lotto.model.database.Ticket;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoNumberInputView;
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

        for (int count = 0; count < quantity; count++) {
            ticket.insert(Lotto.fromRandomNumbers());
        }
    }

    public void showLottoNumberInput() {
        View view = new LottoNumberInputView();
        view.show();

        String response = view.getResponse();
        Draw draw = Draw.getInstance();
        draw.insert(this.createRaffle(response));
    }

    private Raffle createRaffle(String response) {
        Lotto lotto = Lotto.from(response);
        return new Raffle(lotto);
    }

    public void showBonusNumberInput() {
        View view = new BonusNumberInputView();
        view.show();

        String response = view.getResponse();
        Draw draw = Draw.getInstance();

        this.updateRaffleBonus(draw.getLatest(), response);
    }

    private void updateRaffleBonus(Raffle raffle, String response) {
        Bonus bonus = Bonus.from(response);
        raffle.setBonus(bonus);
    }
}
