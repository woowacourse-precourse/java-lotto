package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {
    private final int AMOUNT = 16000;
    private final int NUM_OF_LOTTO = 16;
    private LottoSeller lottoSeller = new LottoSeller();

    @DisplayName("주어진 금액에 해당하는 로또의 개수만큼 로또가 생성되었는지 확인한다.")
    @Test
    void getNumOfLotto() {
        List<Lotto> lotto = lottoSeller.sellTo(AMOUNT);
        assertThat(lotto.size()).isEqualTo(NUM_OF_LOTTO);
    }
}