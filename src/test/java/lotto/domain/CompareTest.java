package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWithBonus;
import org.junit.jupiter.api.Test;

class CompareTest {

    @Test
    void Compare_Test() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 13, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 13, 4, 7, 8));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 44, 15, 16));
        LottoWithBonus lottoWithBonus = new LottoWithBonus(myLotto, 8);
        lottoList.addAll(List.of(lotto, lotto1, lotto2));

        Compare compare = new Compare(lottoList, lottoWithBonus);
        compare.countCorrect();
    }
}