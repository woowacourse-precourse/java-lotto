package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.makeRandomLotto;

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

    public PlaceHistory fillPlaceHistory(WinningLotto winningLotto) {
        PlaceHistory placeHistory = new PlaceHistory();
        lottos.forEach(lotto -> placeHistory.updateFor(winningLotto.makeMatchResult(lotto)));
        return placeHistory;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(createPurchaseQuantityMsg());
        stringBuffer.append('\n');
        lottos.forEach(lotto -> {
            //로또 목록 만들기
            stringBuffer.append(lotto.toString());
            stringBuffer.append('\n');
        });

        return stringBuffer.toString();
    }

    private String createPurchaseQuantityMsg() {
        return String.format("%d개를 구매했습니다.", quantity());
    }
}
