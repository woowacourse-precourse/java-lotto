package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWithBonus;
import org.junit.jupiter.api.Test;

class CompareTest {

    @Test
    void Compare_Test() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 25, 26));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 14, 15, 8));

        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 16));
//        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(new Money(80000000));
        LottoWithBonus lottoWithBonus = new LottoWithBonus(myLotto, 6);
        lottoList.addAll(List.of(lotto, lotto1, lotto2));

        Compare compare = new Compare(new LottoVendingMachine(lottoList), lottoWithBonus);
        compare.printResult(compare.getResult());
    }
}