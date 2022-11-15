package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static lotto.domain.LottoSetting.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {
    @RepeatedTest(100)
    @DisplayName("자동 로또 생성 성공 테스트")
    void whenLottoAutoThenSuccessTest() {
        int size = LottoAutoGenerator.generate().getNumbers().size();
        assertThat(size).isEqualTo(LOTTO_NUMBER_COUNT.getSetting());
    }

    @RepeatedTest(100)
    @DisplayName("자동 로또 생성 번호 범위 성공 테스트")
    void whenLottoAutoNumberRangeThenSuccess() {
        List<Integer> autoNumbers = LottoAutoGenerator.generate().getNumbers();
        assertThat(autoNumbers).allMatch(number ->
                LOTTO_MIN_NUMBER.getSetting() <= number && number <= LOTTO_MAX_NUMBER.getSetting());
    }
}