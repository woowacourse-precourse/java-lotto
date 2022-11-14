package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.makeRandomLotto;
import static lotto.messages.PrintMessage.createPurchaseQuantityMsg;

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
        return quantity() * 1000;
    }

    public PlaceHistory placeHistoryFor(WinningLotto winningLotto) {
        PlaceHistory placeHistory = new PlaceHistory();

        fillPlaceHistory(winningLotto, placeHistory);

        return placeHistory;
    }

    private void fillPlaceHistory(WinningLotto winningLotto, PlaceHistory placeHistory) {
        lottos.forEach(lotto -> placeHistory.updateFor(winningLotto.makeMatchResult(lotto)));
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        appendPurchaseQuantity(stringBuffer);
        appendLottos(stringBuffer);

        return stringBuffer.toString();
    }

    private void appendPurchaseQuantity(StringBuffer stringBuffer) {
        stringBuffer.append(createPurchaseQuantityMsg(quantity()));
        stringBuffer.append(System.lineSeparator());
    }

    private void appendLottos(StringBuffer stringBuffer) {
        lottos.forEach(lotto -> {
            appendLotto(stringBuffer, lotto);
        });
    }

    private void appendLotto(StringBuffer stringBuffer, Lotto lotto) {
        stringBuffer.append(lotto.toString());
        stringBuffer.append(System.lineSeparator());
    }
}
