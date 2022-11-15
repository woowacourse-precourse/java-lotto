package lotto.model.lotto;

import lotto.model.customer.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 로또번호_구매_갯수_검증() {
        //given
        LottoResult lottoResult = new LottoResult();
        Customer customer = new Customer(8000);
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        customer.changeLottos(lottos);
        //when
        lottoResult.create(List.of(1,2,3,4,5,6), 7, customer);

        //then
        assertThat(lottoResult.getRankResult().get(Rank.FIRST)).isEqualTo(1);
    }
}