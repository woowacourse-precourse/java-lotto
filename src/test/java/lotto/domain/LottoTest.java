package lotto.domain;

import static lotto.domain.LottoPrize._1ST_PRIZE;
import static lotto.domain.LottoPrize._2ND_PRIZE;
import static lotto.domain.LottoPrize._3RD_PRIZE;
import static lotto.domain.LottoPrize._4TH_PRIZE;
import static lotto.domain.LottoPrize._5TH_PRIZE;
import static lotto.domain.LottoPrize._NOTHING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Lotto 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개_미만인_경우에도_IllegalArgumentException_예외를_던진다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void value_메서드는_로또_번호_리스트를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.value()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @MethodSource("winningNumberAndCheckResult")
    void check_메서드는_번호를_입력받아_LottoPrize를_반환한다(Lotto winningNumber, LottoNumber bonusNumber, LottoPrize prize) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.check(winningNumber, bonusNumber)).isEqualTo(prize);
    }

    static List<Arguments> winningNumberAndCheckResult() {
        return Arrays.asList(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7), _1ST_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 43)), LottoNumber.valueOf(6), _2ND_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), LottoNumber.valueOf(7), _3RD_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 40, 41)), LottoNumber.valueOf(7), _4TH_PRIZE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 40, 41, 42)), LottoNumber.valueOf(7), _5TH_PRIZE),
                Arguments.of(new Lotto(List.of(37, 38, 39, 40, 41, 42)), LottoNumber.valueOf(7), _NOTHING)
        );
    }
}
