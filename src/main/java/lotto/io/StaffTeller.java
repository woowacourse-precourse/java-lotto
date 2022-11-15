package lotto.io;

import lotto.numbers.Lotto;

import java.util.List;

public interface StaffTeller {
    void tellPurchasedNumberOfLotto(int numberOfLottoPurchased);
    void tellLottos(List<Lotto> lottos);
    void tellLottoResult(int[] rankResult);
}
