package lotto;

import static lotto.enums.Numbers.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final BanknoteSlot banknoteSlot;
    private final List<Lotto> lottoTickets;

    public LottoMachine() {
        banknoteSlot = new BanknoteSlot();
        lottoTickets = new ArrayList<>();
    }

    public void receiveMoney() {
        banknoteSlot.receiveMoney();
    }

    public void createLottoTickets() {
        int numberOfLotto = getNumberOfLotto();
        for (int index = 0; index < numberOfLotto; index++) {
            Lotto lotto = new Lotto(NumberGenerator.createRandomNumber());
            lottoTickets.add(lotto);
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public void printLottoTickets() {
    }

    private int getNumberOfLotto() {
        int money = banknoteSlot.getMoney();
        return money / LOTTO_PRICE.getValue();
    }
}
