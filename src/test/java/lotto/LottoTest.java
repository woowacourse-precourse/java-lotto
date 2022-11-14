package lotto;

import lotto.IO.InputManager;
import lotto.IO.message.ErrorCode;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    // 아래에 추가 테스트 작성 가능
    @Nested
    @DisplayName("로또 생성 테스트")
    class LottoGenerateTest {
        @Test
        @DisplayName("로또 번호가 seed 대로 생성되지 않으면 예외가 발생한다.")
        void generateRandomLottoNumber() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        assertThat(Lotto.generateRandomLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                    },
                    List.of(1, 2, 3, 4, 5, 6)
            );
        }

        @Test
        @DisplayName("생성된 로또 번호를 정렬한다.")
        void sortLottoNumberAsc() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        assertThat(Lotto.generateRandomLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                    },
                    List.of(6, 5, 4, 3, 2, 1)
            );
        }
    }

    @Nested
    @DisplayName("로또 비교 테스트")
    class LottoCompareTest {
        @Test
        @DisplayName("1등 당첨 테스트")
        void compareWithAnswerZero() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,5,6));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 0);
        }

        @Test
        @DisplayName("2등 당첨 테스트")
        void compareWithAnswerOne() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,5,7));
            int bonus = 6;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 1);
        }

        @Test
        @DisplayName("3등 당첨 테스트")
        void compareWithAnswerTwo() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,5,7));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 2);
        }

        @Test
        @DisplayName("4등 당첨 테스트")
        void compareWithAnswerThree() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,4,7,8));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 3);
        }

        @Test
        @DisplayName("5등 당첨 테스트")
        void compareWithAnswerFour() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,3,7,8,9));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == 4);
        }

        @Test
        @DisplayName("미당첨 테스트1")
        void compareWithAnswerMinus1() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(1,2,7,8,9,10));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == -1);
        }

        @Test
        @DisplayName("미당첨 테스트2")
        void compareWithAnswerMinus2() {
            Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
            Lotto answer = new Lotto(List.of(7,8,9,10,11,12));
            int bonus = 45;

            assertThat(myLotto.compareWithAnswer(answer, bonus) == -1);
        }
    }

    @Nested
    @DisplayName("입력 예외처리 테스트")
    class IOTest {
        @Test
        @DisplayName("")
        void wrongInput() {
            //
        }
    }
}
