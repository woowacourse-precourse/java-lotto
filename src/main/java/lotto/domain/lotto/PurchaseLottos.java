package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.makeRandomLotto;
import static lotto.message.TempPrintMessage.createPurchaseQuantityMsg;
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

    //로또들이 있어, 이 객체 역할: placeHistory 생성 . 출력 역할으 ㄴ또 누군감 ㅏㅌ아야 함.
    public PlaceHistory placeHistoryFor(WinningLotto winningLotto) {
        PlaceHistory placeHistory = new PlaceHistory();

        fillPlaceHistory(winningLotto, placeHistory);

        return placeHistory;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        appendPurchaseQuantity(stringBuffer);
        appendLottos(stringBuffer);

        return stringBuffer.toString();
    }

    private void fillPlaceHistory(WinningLotto winningLotto, PlaceHistory placeHistory) {
        lottos.forEach(lotto -> placeHistory.updateFor(winningLotto.makeMatchResult(lotto)));
    }

    private void appendPurchaseQuantity(StringBuffer stringBuffer) {
        stringBuffer.append(createPurchaseQuantityMsg(quantity()));
        stringBuffer.append(System.lineSeparator());
    }

    private void appendLottos(StringBuffer stringBuffer) {
        lottos.forEach(lotto -> appendLotto(stringBuffer, lotto));
    }

    private void appendLotto(StringBuffer stringBuffer, Lotto lotto) {
        stringBuffer.append(lotto.toString());
        stringBuffer.append(System.lineSeparator());
    }
}
