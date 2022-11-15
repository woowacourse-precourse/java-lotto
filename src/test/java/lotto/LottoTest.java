package lotto;

import static lotto.lotto.LottoGenerator.generateLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.lotto.BonusNumberDuplicationError;
import lotto.exception.lotto.LottoNumberException;
import lotto.exception.lotto.WrongLengthException;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<LottoNumber> numbers = convertIntegerListToLottoNumberList(
                List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<LottoNumber> numbers = convertIntegerListToLottoNumberList(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 5개 이하이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        List<LottoNumber> numbers = convertIntegerListToLottoNumberList(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(WrongLengthException.class);
    }

    @DisplayName("로또 번호가 1이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(LottoNumberException.class);
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(LottoNumberException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(LottoNumberException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복될시 예외가 발생한다.")
    @Test
    void bonusNumberDuplication() {
        List<LottoNumber> winningNumbers = convertIntegerListToLottoNumberList(
                List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(BonusNumberDuplicationError.class);
    }

    @DisplayName("로또 생성 테스트")
    @RepeatedTest(10)
    void generateLotto() {
        generateLottos(10)
                .forEach(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }

    private List<LottoNumber> convertIntegerListToLottoNumberList(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
