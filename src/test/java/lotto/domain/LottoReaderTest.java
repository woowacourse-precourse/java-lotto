package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoReaderTest {
    LottoReader lottoReader = new LottoReader();

    @DisplayName("로또에 숫자가 포함되어 있는지 판단하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또에_해당_숫자가_포함되어_있는지_판단하는_기능_테스트(int intArg) {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoReader.isIncludedNumber(testLotto, intArg)).isTrue();
    }

    @DisplayName("로또에 숫자가 포함되지 않았다고 판단하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 500, 9, 10, 11, 2000})
    void 로또에_해당_숫자가_포함되지_않았다고_판단하는_기능_테스트(int intArg) {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoReader.isIncludedNumber(testLotto, intArg)).isFalse();
    }


}