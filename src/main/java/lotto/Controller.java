package lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    User user;
    Store store;
    Tv tv;
    public Detail detail;
    public List<List<Integer>> tickets;
    public List<Integer> winnerNumber;
    public int quantity;
    public int bonusNumber;

    public void startApplication() {
        user = new User();
        store = new Store();
        tv = new Tv();
        detail = new Detail();
        tickets = new ArrayList<>();
        winnerNumber = new ArrayList<>();

        quantity = inputMoney();
        store.makeLottoTickets(quantity, tickets);
        detail.showLottoTickets(tickets);
        winnerNumber = tv.inputWinnerNumber(winnerNumber);
        bonusNumber = tv.inputBonusNumber();
        detail.compareLottoNumbers(winnerNumber, bonusNumber, tickets);

    }

    public int inputMoney() {
        return user.purchaseLotto();
    }
}
