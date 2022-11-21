package lotto;

import lotto.domain.Lotto;
import lotto.model.User;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DomainTest {
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

    @DisplayName("입력 금액에 숫자가 아닌것이 포함되어있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000j","124j123"})
    void inputMoneyWithNotNumber(String input){
        assertThatThrownBy(()->new User().validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000으로 나누어 지지 않는경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"100","1001","2030","1100","10"})
    void inputMoneyNotDividedByThousand(String input){
        assertThatThrownBy(()->new User().validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복된경우 예외가 발생한다.")
    @Test
    void includeBonusNumberIntoWinningNumber(){
        assertThatThrownBy(()->new WinningLotto(List.of(1,2,3,4,5,6)).inputBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45사이의 값이 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberOutOfRange(){
        assertThatThrownBy(()->new WinningLotto(List.of(1,2,3,4,5,6)).inputBonusNumber(47))
                .isInstanceOf(IllegalArgumentException.class);
    }







}
