package lotto;

import lotto.numbers_generator.Context;
import lotto.numbers_generator.LottoNumberGeneratorSequenceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVendorTest {

    @Test
    void 로또3장구매() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> lotto3 = List.of(3, 4, 5, 6, 7, 8);
        Context.setLottoNumberGenerator(new LottoNumberGeneratorSequenceImpl(
                List.of(lotto1, lotto2, lotto3)
        ));
        LottoVendor lottoVendor = new LottoVendor();
        List<List<Integer>> lottos = lottoVendor.purchase(3000);
        assertThat(lottos).contains(lotto1, lotto2, lotto3);
    }

    @Test
    void 로또구매금액이1000의배수가아닐때예외발생(){
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> lotto3 = List.of(3, 4, 5, 6, 7, 8);
        Context.setLottoNumberGenerator(new LottoNumberGeneratorSequenceImpl(
                List.of(lotto1, lotto2, lotto3)
        ));
        LottoVendor lottoVendor = new LottoVendor();
        assertThatThrownBy(()-> lottoVendor.purchase(3001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}