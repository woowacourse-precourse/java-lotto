package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 중복이 없어야함
 * 오름차순 정렬되어야 함
 * 잘못된 입력 exception
 */
class LottoGeneratorTest {

    @Test
    void lottoGenerator_SizeOfLottosIsEqualsToQuantity() {
        int size = 5;
        assertThat(new LottoGenerator(size).generateLottos().size()).isEqualTo(size);
    }

}