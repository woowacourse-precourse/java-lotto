package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.makeRandomLotto;
import static lotto.value.MoneyUnit.KRW;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.statistics.PlaceHistory;

public class PurchaseLottos {

    private final List<Lotto> lottos;

    public PurchaseLottos(int quantity) {
        lottos = new ArrayList<>(quantity);

        for (int count = 0; count < quantity; ++count) {
            lottos.add(makeRandomLotto());
        }
    }

    public int quantity() {
        return lottos.size();
    }

    public int calculateAmount() {
        return quantity() * KRW.getPrice();
    }

    public List<Lotto> list() {
        return new ArrayList<>(lottos);
    }

    public PlaceHistory placeHistoryFor(WinningLotto winningLotto) {
        PlaceHistory placeHistory = new PlaceHistory();

        fillPlaceHistory(winningLotto, placeHistory);

        return placeHistory;
    }

    private void fillPlaceHistory(WinningLotto winningLotto, PlaceHistory placeHistory) {
        lottos.forEach(lotto -> placeHistory.updateFor(winningLotto.makeMatchResult(lotto)));
    }
}
