package lotto.utils.Advice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.model.FirstPlace;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.checkSize(List.of(1, 2, 3, 4, 5, 6, 7)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Length Is Incorrect. SIZE : 7");
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.checkSize(List.of(1, 2, 3, 4, 5)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Length Is Incorrect. SIZE : 5");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.checkDuplication(List.of(1, 2, 3, 4, 5, 1)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Duplicate Number.");
    }

    @DisplayName("로또 번호에 1보다 작은 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutBoundNumberUnderZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(0, 1, 2, 3, 4, 5)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Out Bound Number.");
    }

    @DisplayName("로또 번호에 45보다 큰 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutBoundNumberOverFortyFive() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(46, 1, 2, 3, 4, 5)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Out Bound Number.");
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다.")
    @Test
    void createFirstPlaceByNotDivideCommas1(){
        String firstPlace = "1,2,3,4,5,6,,,";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표랑 다른 구분자 있을 때")
    @Test
    void createFirstPlaceByNotDivideCommas2() {
        String firstPlace = "1,2,3,4/5/6";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표가 없을 때")
    @Test
    void createFirstPlaceByNotExistCommas() {
        String firstPlace = "1/2/3/4/5/6";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 공백이 있을 때")
    @Test
    void createFirstPlaceByNotExistSpace() {
        String firstPlace = "1, 2, 3, 4, 5, 6";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }
}