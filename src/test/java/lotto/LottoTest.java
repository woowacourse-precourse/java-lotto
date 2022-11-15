package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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

    @DisplayName("6개의 숫자가 ','로 제대로 구별되어 입력됐는지 확인한다.")
    @Test
    void checkValidFormat() {
        String input = "1,2,7,4,3 6";

        assertThatThrownBy(()->
                Lotto.validateWinningNumbers(input) )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 1~45 범위 내에서 입력됐는지 확인한다.")
    @Test
    void checkRangeOfSixWinningNumbers(){
        String input = "1,2,3,4,0,5";

        assertThatThrownBy(()-> Lotto.toIntegerNumbersWithoutComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 숫자가 아닌 다른 문자로 입력됐는지 확인한다.")
    @Test
    void checkInvalidInput(){
        String input=("나,는,숫,자,가, 아니야~:) 😗 ");

        assertThatThrownBy(()-> Lotto.toIntegerNumbersWithoutComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 없는지 확인한다.")
    @Test
    void checkBonusNumberIsNothing(){
        String input ="";
        List<Integer> numbers = new ArrayList<>();

        assertThatThrownBy(()-> Lotto.validateBonusNumber(input, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 공백인지 확인한다.")
    @Test
    void checkBonusNumberIsVacant(){
        String input = " ";
        List<Integer> numbers = new ArrayList<>();

        assertThatThrownBy(()-> Lotto.validateBonusNumber(input, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 숫자인지 확인한다.")
    @Test
    void checkBonusNumberIsNumber(){
        String input="t";
        List<Integer> numbers = new ArrayList<>();

        assertThatThrownBy(()-> Lotto.validateBonusNumber(input, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 입력값이 1~45 범위내에 있는지 확인한다.")
    @Test
    void checkBonusNumberIsInRange(){
        String input = "77";
        List<Integer> numbers = new ArrayList<>();

        assertThatThrownBy(()-> Lotto.validateBonusNumber(input, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 구매하는 돈의 최소 단위가 1000원 이상인지 확인한다.")
    @Test
    void checkPaymentInUnitsOfAThousand(){
        String input ="17820";

        assertThatThrownBy(()-> Lotto.validateMoneyForLottos(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입을 위해 입력한 돈이 유효한 타입인지 확인한다.")
    @Test
    void checkPaymentIsValid(){
        String input="정수가 아닌 값 입력 시 오류 발생";

        assertThatThrownBy(()-> Lotto.validateMoneyForLottos(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
