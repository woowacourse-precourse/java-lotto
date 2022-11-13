package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨 번호는 6개여야 합니다.");
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
        void _1_45_외의_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(-11, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        @Test
        void 보너스_번호가_로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
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

        @DisplayName("로또 번호: 3, 21, 25, 28, 4, 9")
        @ParameterizedTest(name = "당첨 번호: {1} 맞춘 개수: {3}")
        @MethodSource("lottoTestCases")
        void 번호_비교_테스트(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber, int expect) {
            //given
            Lotto lotto = new Lotto(numbers);
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            //when
            int matchCount = winningLotto.match(lotto);

            //then
            assertThat(matchCount).isEqualTo(expect);
        }

        /*
        * 로또 번호, 당첨 번호, 보너스 번호, 맞춘 개수
        * */
        private Stream<Arguments> lottoTestCases() {
            return Stream.of(
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(1, 2, 3, 4, 5, 6), 7, 2),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 2, 3, 4, 5, 6), 7, 3),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 4, 5, 6), 7, 4),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 6), 7, 5),
                    Arguments.of(List.of(3, 21, 25, 28, 4, 9), List.of(21, 25, 3, 28, 4, 9), 7, 6)
            );
        }
    }

    @Nested
    @DisplayName("보너스 번호 있는지 테스트")
    class IsMatchedBonusNumber {

        @Test
        void 보너스_번호가_있으면_true를_반환한다() {
            //given
            List<Integer> numbers = List.of(3, 21, 25, 28, 4, 9);
            WinningLotto winningLotto = new WinningLotto(List.of(21, 25, 3, 28, 4, 6), 9);

            //when
            boolean res = winningLotto.isMatchedBonusNumber(numbers);

            //then
            assertThat(res).isTrue();
        }

        @Test
        void 보너스_번호가_없으면_false를_반환한다() {
            //given
            List<Integer> numbers = List.of(3, 21, 25, 28, 4, 9);
            WinningLotto winningLotto = new WinningLotto(List.of(21, 25, 3, 28, 4, 6), 45);

            //when
            boolean res = winningLotto.isMatchedBonusNumber(numbers);

            //then
            assertThat(res).isFalse();
        }
    }
}