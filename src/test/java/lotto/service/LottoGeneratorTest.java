package lotto.service;

import lotto.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {

    @Test
    @DisplayName("구매 개수에 맞게 로또가 생성된다.")
    void lottoSizeTest() {
        // given
        int purchaseCount = 3;

        // when
        List<Lotto> lotto = LottoGenerator.generateMyLotto(purchaseCount);

        // then
        assertEquals(purchaseCount, lotto.size());
    }
}
