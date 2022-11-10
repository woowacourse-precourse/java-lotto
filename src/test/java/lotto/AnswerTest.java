package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @MethodSource("provideLottosAnswer")
    @ParameterizedTest
    void calculateLottosAnswer(int index, GameResult gameResult) {
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Answer answer = new Answer(List.of(1, 2, 3, 4, 5, 6), 7);

        List<GameResult> results = answer.play(List.of(firstLotto, secondLotto, thirdLotto));
        assertThat(results.get(index)).isEqualTo(gameResult);
    }

    private static List<Arguments> provideLottosAnswer() {
        return List.of(
                Arguments.of(0, GameResult.FIRST),
                Arguments.of(1, GameResult.SECOND),
                Arguments.of(2, GameResult.THIRD)
        );
    }
}