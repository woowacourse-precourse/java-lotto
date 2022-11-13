package lotto;

import lotto.numbers_generator.LottoNumberGeneratorSequenceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    @Test
    void 로또3장구매() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> lotto3 = List.of(3, 4, 5, 6, 7, 8);
        Context.setLottoNumberGenerator(new LottoNumberGeneratorSequenceImpl(
                List.of(lotto1, lotto2, lotto3)
        ));
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchase(3000);
        assertThat(lottos).contains(new Lotto(lotto1), new Lotto(lotto2), new Lotto(lotto3));
    }

    @Test
    void 로또구매금액이1000의배수가아닐때예외발생(){
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> lotto3 = List.of(3, 4, 5, 6, 7, 8);
        Context.setLottoNumberGenerator(new LottoNumberGeneratorSequenceImpl(
                List.of(lotto1, lotto2, lotto3)
        ));
        LottoService lottoService = new LottoService();
        assertThatThrownBy(()-> lottoService.purchase(3001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}