package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {

    private final List<Lotto> lottoGroup = new ArrayList<>();

    public LottoGroup(int purchaseCount) {
        makeLottoGroup(purchaseCount);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    private void makeLottoGroup(int purchaseCount) {
        for (int count = 0; count < purchaseCount; count++) {
            lottoGroup.add(new Lotto(LotteryDrawMachine.drawLotteryNumbers()));
        }
    }
}
