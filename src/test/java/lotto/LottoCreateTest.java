package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCreateTest {

    @Test
    void Lotto_success_create_test(){
        LottoCreate lottoCreate = new LottoCreate();
        Lotto lotto = new Lotto(lottoCreate);
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

}