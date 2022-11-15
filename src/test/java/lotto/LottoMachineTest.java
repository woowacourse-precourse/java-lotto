package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @DisplayName("1~45에 해당하는 6개의 숫자 랜덤 추출하여 로또 번호를 생성한다.")
    @Test
    void createLottoNumbers() {
        List<Integer> lottoNumbers = LottoMachine.createLottoNumbers();
        lottoNumbers.forEach(lottoNumber -> {
            assertThat(lottoNumber).isGreaterThanOrEqualTo(1);
            assertThat(lottoNumber).isLessThanOrEqualTo(45);
        });
    }

    @DisplayName("구입 금액으로 구매 가능한 로또 발행 수를 반환한다.")
    @Test
    void getNumberOfLotto() {
        Integer purchaseAmount = 8000;
        Integer numberOfLotto = LottoMachine.getNumberOfLotto(purchaseAmount);
        assertThat(numberOfLotto).isEqualTo(8);
    }

    @DisplayName("구매 가능한 로또 발행 수만큼 로또 번호를 반복해서 생성한다.")
    @Test
    void createMultipleLottoNumbers() {
        Integer purchaseAmount = 8000;
        List<List<Integer>> multipleLottoNumbers = LottoMachine.createMultipleLottoNumbers(purchaseAmount);
        assertThat(multipleLottoNumbers.size()).isEqualTo(8);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {8500, 700, 0, 1234})
    void createLottoNumbersByNonMultipleOfUnitAmount(Integer purchaseAmount) {
        assertThatThrownBy(() -> LottoMachine.createMultipleLottoNumbers(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}