package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Nested
    @DisplayName("정상 동작 테스트")
    class NormalTest {

        @Test
        @DisplayName("로또의 번호 6개가 일치하여 1등이 당첨된다.")
        void createResultOfFirst() {
            Result result = Result.create(6, false);
            assertThat(result).isEqualTo(Result.FIRST);
        }

        @Test
        @DisplayName("로또의 번호 5개와 보너스 번호가 일치하여 2등이 당첨된다.")
        void createResultOfSecond() {
            Result result = Result.create(5, true);
            assertThat(result).isEqualTo(Result.SECOND);
        }

        @Test
        @DisplayName("로또의 번호 5개가 일치하여 3등이 당첨된다.")
        void createResultOfThird() {
            Result result = Result.create(5, false);
            assertThat(result).isEqualTo(Result.THIRD);
        }

        @Test
        @DisplayName("로또의 번호 4개와 보너스 번호가 일치하여 4등이 당첨된다.")
        void createResultOfFourthWithBonusNumber() {
            Result result = Result.create(4, true);
            assertThat(result).isEqualTo(Result.FOURTH);
        }

        @Test
        @DisplayName("로또의 번호 4개가 일치하여 4등이 당첨된다.")
        void createResultOfFourth() {
            Result result = Result.create(4, false);
            assertThat(result).isEqualTo(Result.FOURTH);
        }

        @Test
        @DisplayName("로또의 번호 3개와 보너스 번호가 일치하여 5등이 당첨된다.")
        void createResultOfFifthWithBonusNumber() {
            Result result = Result.create(3, true);
            assertThat(result).isEqualTo(Result.FIFTH);
        }

        @Test
        @DisplayName("로또의 번호 3개가 일치하여 5등이 당첨된다.")
        void createResultOfFifth() {
            Result result = Result.create(3, false);
            assertThat(result).isEqualTo(Result.FIFTH);
        }

        @Test
        @DisplayName("로또의 번호 2개가 일치하여 꽝이 된다.")
        void createResultOfNotingWithMatchCount2() {
            Result result = Result.create(2, false);
            assertThat(result).isEqualTo(Result.NOTING);
        }

        @Test
        @DisplayName("로또의 번호 1개가 일치하여 꽝이 된다.")
        void createResultOfNotingWithMatchCount1() {
            Result result = Result.create(1, false);
            assertThat(result).isEqualTo(Result.NOTING);
        }

        @Test
        @DisplayName("로또의 번호 0개가 일치하여 꽝이 된다.")
        void createResultOfNotingWithMatchCount0() {
            Result result = Result.create(0, false);
            assertThat(result).isEqualTo(Result.NOTING);
        }
    }
}
