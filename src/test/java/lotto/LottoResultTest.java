package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    static Stream<Arguments> generateFindTestArg() {
        return Stream.of(
                Arguments.of(2, true, LottoResult.None),
                Arguments.of(2, false, LottoResult.None),
                Arguments.of(3, true, LottoResult.Match3),
                Arguments.of(3, false, LottoResult.Match3),
                Arguments.of(4, true, LottoResult.Match4),
                Arguments.of(4, false, LottoResult.Match4),
                Arguments.of(5, true, LottoResult.Match5AndBonus),
                Arguments.of(5, false, LottoResult.Match5),
                Arguments.of(6, true, LottoResult.Match6),
                Arguments.of(6, false, LottoResult.Match6)
        );
    }

    @ParameterizedTest
    @MethodSource("generateFindTestArg")
    @DisplayName("matchCount와 보너스 번호 일치여부로 로또 결과를 정확히 반환하는지 테스트")
    void findTest(int matchCount, boolean bonus, LottoResult expected) {
        assertThat(LottoResult.find(matchCount, bonus)).isEqualTo(expected);
    }
}