package lotto;

import Domain.BonusNumber;
import Domain.Lotto;
import Domain.LottoList;
import Domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("당첨 번호 리스트에 숫자가 적절하지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByNumberIsOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,56,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 리스트에 구분자 개수가 적절하지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumbersBySeparatorCountIsIncorrect() {
        assertThatThrownBy(() -> new WinningNumbers(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 리스트에 구분자 사이에 숫자가 없으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByHaveNothingBetweenSeparator() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 리스트에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,6,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 리스트에 문자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByHavingAlphabet() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,a,6,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호 리스트 생성시, 금액이 로또 1장 가격보다 작으면 예외가 발생한다.")
    @Test
    void createLottoListByLowerMoney() {
        assertThatThrownBy(() -> new LottoList("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또번호 리스트 생성시, 금액이 로또 1장 가격의 배수가 아니면 예외가 발생한다.")
    @Test
    void createLottoListByNotMultipleLottoPrice() {
        assertThatThrownBy(() -> new LottoList("9900"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또번호 리스트 생성시, 입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void createLottoListByNotNumericInput() {
        assertThatThrownBy(() -> new LottoList("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호 생성시, 입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotNumericInput() {
        assertThatThrownBy(() -> new BonusNumber("asd", new WinningNumbers("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호 생성시, 입력이 당첨번호와 중복이면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateNumber() {
        assertThatThrownBy(() -> new BonusNumber("4", new WinningNumbers("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호 생성시, 정수입력범위를 벗어난 입력이라면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber("46", new WinningNumbers("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
