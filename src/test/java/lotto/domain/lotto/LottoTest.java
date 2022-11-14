package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5,6,7"})
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(final String input) {

        var numbers = stringToIntegerList(input);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,1,1,1", "1,1,1,1,1,2", "1,1,1,1,2,3", "1,1,1,2,3,4", "1,1,2,3,4,5"})
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(final String input) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        var numbers = stringToIntegerList(input);
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining(Lotto.ERROR_LOTTO_NUMBER_DUPLICATED);
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(input))
                .withMessageContaining(Lotto.ERROR_LOTTO_NUMBER_DUPLICATED);
    }


    // 아래에 추가 테스트 작성 가능
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "6,5,4,3,2,1,", "10,9,8,7,6,5"})
    void 로또_번호는_정렬된_상태여야_합니다(final String input) {

        var generatedIntegerNumberLotto = new Lotto(stringToIntegerList(input));
        var generatedStringLotto = new Lotto(input);
        
        assertThat(generatedIntegerNumberLotto.numbers()).isSorted();
        assertThat(generatedStringLotto.numbers()).isSorted();

    }

    private List<Integer> stringToIntegerList(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
