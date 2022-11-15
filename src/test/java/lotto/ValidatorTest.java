package lotto;

import lotto.Domain.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ValidatorTest {


    @DisplayName("[정상] 로또 구매 금액으로 가능한 값인지 확인한다.")
    @ParameterizedTest
    @ValueSource( ints = {1000, 2000, 3000})
    void checkIsValidAmount(int purchaseAmount) {
        assertThat(Validator.checkIsValidateAmount(purchaseAmount)).isEqualTo(purchaseAmount);

    }

    @DisplayName("[예외] 로또 구매 금액으로 1000원 미만 값이면 예외.")
    @ParameterizedTest
    @ValueSource( ints = {100, 250, 300})
    void checkIsValidAmount_Ex(int purchaseAmount) {
        assertThatThrownBy(() -> Validator.checkIsValidateAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외] 로또 구매 금액으로 1000배수 값이 아니면 예외.")
    @ParameterizedTest
    @ValueSource( ints = {1500, 2500, 3020})
    void checkIsValidAmount_Ex2(int purchaseAmount) {
        assertThatThrownBy(() -> Validator.checkIsValidateAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("[정상] 로또 당첨 번호가 올바른지 확인")
    @Test
    void checkIsValidWinningNums() {
        List<Integer> winningNums = List.of(1,2,3,4,5,6);
        Validator.checkIsValidWinningNums(winningNums);
    }

    @DisplayName("[예외] 로또 당첨 번호에 중복이 있는 경우")
    @Test
    void checkIsValidWinningNums_Ex() {
        List<Integer> winningNums = List.of(1,1,3,4,5,6);
        assertThatThrownBy(() -> Validator.checkIsValidWinningNums(winningNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외] 로또 당첨 번호가 1~45 사이 값이 아닌 경우")
    @Test
    void checkIsValidWinningNums_Ex2(){
        List<Integer> winningNums = List.of(100,101,2,3,4,5,6);
        assertThatThrownBy(() -> Validator.checkIsValidWinningNums(winningNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[정상] 로또 보너스 번호가 올바른지 확인")
    @Test
    void checkIsValidBonusNums() {
        List<Integer> winningNums = List.of(1,2,3,4,5,6);
        int bonusNum = 7;
        Validator.checkIsValidBonusNum(winningNums, bonusNum);
    }

    @DisplayName("[예외] 로또 보너스 번호가 1~45사이 값이 아닌 경우")
    @Test
    void checkIsValidBonusNum_Ex1(){
        List<Integer> winningNums = List.of(1,2,3,4,5,6);
        int bonusNum = 100;
        assertThatThrownBy(() ->  Validator.checkIsValidBonusNum(winningNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외] 로또 보너스 번호가 당첨 번호와 중복인 경우")
    @Test
    void checkIsValidBonusNum_Ex2(){
        List<Integer> winningNums = List.of(1,2,3,4,5,6);
        int bonusNum = 4;
        assertThatThrownBy(() ->  Validator.checkIsValidBonusNum(winningNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
