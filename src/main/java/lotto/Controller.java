package lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private User user;
    private Store store;
    private Tv tv;
    private Detail detail;
    private List<List<Integer>> tickets;
    private List<Integer> winnerNumber;
    private int quantity;
    private int bonusNumber;

    public void startApplication() {
        user = new User();
        store = new Store();
        tv = new Tv();
        detail = new Detail();
        tickets = new ArrayList<>();
        winnerNumber = new ArrayList<>();

        quantity = inputMoney();
        if (quantity == 0) {
            return;
        }
        store.makeLottoTickets(quantity, tickets);
        detail.showLottoTickets(tickets);
        winnerNumber = tv.inputWinnerNumber();
        bonusNumber = tv.inputBonusNumber();
        detail.compareLottoNumbers(winnerNumber, bonusNumber, tickets);

    }

    public int inputMoney() {
        return user.purchaseLotto();
    }
}
