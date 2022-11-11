package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @MethodSource("provideLottosAnswer")
    @ParameterizedTest
    void calculateLottosAnswer(int index, LottoResult lottoResult) {
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        Answer answer = new Answer(List.of(1, 2, 3, 4, 5, 6), 7);
        Lottos lottos = new Lottos(List.of(firstLotto, secondLotto, thirdLotto));

        List<LottoResult> results = answer.play(lottos);
        assertThat(results.get(index)).isEqualTo(lottoResult);
    }

    private static List<Arguments> provideLottosAnswer() {
        return List.of(
                Arguments.of(0, LottoResult.FIRST),
                Arguments.of(1, LottoResult.SECOND),
                Arguments.of(2, LottoResult.THIRD)
        );
    }
}