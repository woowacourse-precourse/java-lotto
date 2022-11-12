package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerLottoTest {


    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1", "2,3,4,5,6,7:2", "40,41,42,43,44,45:45"}, delimiterString = ":")
    void 정답로또는_로또와_보너스번호사이의_같은_번호가_존재할_수_없습니다(final String lottoNumberInput, final Integer bonusNumberInput) {
        var lottoNumber = Arrays.stream(lottoNumberInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        var randomLotto = new Lotto(lottoNumber);
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new AnswerLotto(randomLotto, new LottoNumber(bonusNumberInput)))
                .withMessageContaining(AnswerLotto.ERROR_DUPLICATED_BONUS_NUMBER);
    }

}