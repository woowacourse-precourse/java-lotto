package lotto;

import lotto.Model.Bonus;
import lotto.Model.Lotto;
import lotto.Model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또번호와 겹치면 예외가 발생한다.")
    @Test
    void createBonusDuplicateByFirstPlace() {
        assertThatThrownBy(() -> new Bonus(new Lotto("33,34,35,36,37,38"), "33"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void createFirstPlaceByOutBoundNumber2() {
        String firstPlace = "1,37,42,9,48,25";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수량 입력 시 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Pay = {0}")
    @ValueSource(strings = {"1,111", " 1234", "3 456", "34 56 7", "a234", "5-+*"})
    void purchaseLottoQtyCheckInput(String input) {
        assertThatThrownBy(() -> new Price(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("복권 구입 시 금액을 천원 단위로 입력하지 않을 시 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Pay = {0}")
    @ValueSource(strings = {"1200", "1", "00200", "123456789"})
    void purchaseLottoQtyCheckReminder(String input) {
        assertThatThrownBy(() -> new Price(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
