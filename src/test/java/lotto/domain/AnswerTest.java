package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerTest {

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 1등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.compare(lotto);
        assertThat(lottoResult.isFirst()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 2등 결과를 반환하는 기능")
    @Test
    void calculateAnswerSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.compare(lotto);
        assertThat(lottoResult.isSecond()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 3등 결과를 반환하는 기능")
    @Test
    void calculateAnswerThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.compare(lotto);
        assertThat(lottoResult.isThird()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 4등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.compare(lotto);
        assertThat(lottoResult.isFourth()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 5등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFifth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 7));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.compare(lotto);
        assertThat(lottoResult.isFifth()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 이외의 결과를 반환하는 기능")
    @Test
    void calculateAnswerElse() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.compare(lotto);
        assertThat(lottoResult.isElse()).isTrue();
    }

    @MethodSource("provideLottosAnswer")
    @ParameterizedTest
    void calculateLottosAnswer(int index, LottoResult lottoResult) {
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        Answer answer = new Answer(List.of(1, 2, 3, 4, 5, 6), 7);
        Lottos lottos = new Lottos(List.of(firstLotto, secondLotto, thirdLotto));

        List<LottoResult> results = answer.compare(lottos);
        assertThat(results.get(index)).isEqualTo(lottoResult);
    }

    private static List<Arguments> provideLottosAnswer() {
        return List.of(
                Arguments.of(0, LottoResult.FIRST),
                Arguments.of(1, LottoResult.SECOND),
                Arguments.of(2, LottoResult.THIRD)
        );
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외 발생")
    @Test
    void bonusOutRange() {
        assertThatThrownBy(() -> new Answer(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호 중 같은 번호가 있으면 예외 발생")
    @Test
    void answerContainsBonusNumber() {
        assertThatThrownBy(() -> new Answer(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 정답 번호와 중복되면 안됩니다.");
    }
}