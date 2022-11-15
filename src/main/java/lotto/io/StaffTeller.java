package lotto.io;

import lotto.Lotto;

import java.util.List;

public interface StaffTeller {
    public void tellPurchasedNumberOfLotto(int numberOfLottoPurchased);
    public void tellLottos(List<Lotto> lottos);
}
