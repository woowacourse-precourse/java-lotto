package lotto.domain.compare;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.settlementsysyem.Ranking;
import lotto.domain.settlementsysyem.Score;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CompareLottoTest {


    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:7",
    }, delimiterString = ":")
    void 두_개의_랜덤로또와_정답_로또를_비교합니다(String randomLottoInput, String answerLottoInput, String bonusNumberInput) {
        var randomLotto = this.stringToLotto(randomLottoInput);
        var answerLotto = this.stringToLotto(answerLottoInput);

        var answer = new AnswerLotto(answerLotto, this.stringToBonusNumber(bonusNumberInput));

        Score score = CompareLotto.compare(answer, randomLotto);

        var actual = score.generateRank();
        Assertions.assertThat(actual).isEqualTo(Ranking.FIRST_WINNING);
    }


    private LottoNumber stringToBonusNumber(final String input) {
        return new LottoNumber(Integer.parseInt(input));
    }

    private Lotto stringToLotto(final String input) {
        var number = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(number);
    }
}