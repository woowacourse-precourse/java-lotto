package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Nested
    @DisplayName("당첨 로또 생성 테스트")
    class CreateTest {
        @Test
        void 당첨_로또_생성_성공() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;

            //when then
            assertThatNoException()
                    .isThrownBy(() -> new WinningLotto(numbers, bonusNumber));
        }

        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
            int bonusNumber = 7;

            //when then
            assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
            int bonusNumber = 7;

            //when then
            assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 당첨 번호가 존재합니다.");
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다2() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 6;

            //when then
            assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 당첨 번호가 존재합니다.");
        }
    }

    @Nested
    @DisplayName("번호 비교 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class MatchTest {

        @ParameterizedTest
        @MethodSource("lottoTestCases")
        void 번호_비교_테스트(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber, Rank expect) {
            //given
            Lotto lotto = new Lotto(numbers);
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            //when
            Rank rank = winningLotto.match(lotto);

            //then
            assertThat(rank).isEqualTo(expect);
        }

        /*
        * 로또 번호, 당첨 번호, 보너스 번호, 결과 등수
        * */
        private Stream<Arguments> lottoTestCases() {
            return Stream.of(
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(1, 2, 3, 4, 5, 6), 7, NOTHING),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(1, 2, 3, 4, 5, 6), 9, FIFTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 2, 3, 4, 5, 6), 7, FIFTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 4, 5, 6), 7, FOURTH),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 6), 7, THIRD),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 6), 9, SECOND),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 9), 7, FIRST)
            );
        }
    }
}