package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.assertj.core.api.Assertions;

public class LottoMachineTest {

    @Test
    @DisplayName("당첨 번호 String 을 받아서 List<Integer> 로 변환 테스트")
    void convertStringToNumberTest() {
        String numbers = "1,2,3,4,5,6";
        List<Integer> lottoNumbers = LottoMachine.convertStringToNumber(numbers);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        for (int i = 0; i < lottoNumbers.size(); i++) {
            Assertions.assertThat(lottoNumbers.get(i)).isEqualTo(expected.get(i));
        }
    }

    @Test
    @DisplayName("당첨 번호 객체 생성 테스트")
    void initLottoMachineNumberTest() {
        String numbers = "1,2,3,4,5,6";
        LottoMachine lottoMachine = LottoMachine.initLottoMachineNumber(numbers).get();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        for (int i = 0; i < lottoMachine.getNumbers().size(); i++) {
            Assertions.assertThat(lottoMachine.getNumbers().get(i)).isEqualTo(expected.get(i));
        }

        String bonusNumber = "30";
        lottoMachine.addBonusNumber(bonusNumber);
        Assertions.assertThat(lottoMachine.getBonusNumber()).isEqualTo(30);
    }

    @Test
    @DisplayName("보너스 숫자 예외 테스트(보너스 숫자가 당첨 번호와 중복되는 경우)")
    void DuplicatedBonusExceptionTest() {
        String numbers = "20,10,3,2,41,24";
        LottoMachine lottoMachine = LottoMachine.initLottoMachineNumber(numbers).get();

        String bonusNumber = "10";
        Assertions.assertThatThrownBy(() -> lottoMachine.addBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 예외 테스트(보너스 숫자가 1~45 범위를 벗어나는 경우)")
    void OutOfRangeBonusExceptionTest() {
        String numbers = "20,10,3,2,41,24";
        LottoMachine lottoMachine = LottoMachine.initLottoMachineNumber(numbers).get();

        String bonusNumber = "46";
        Assertions.assertThatThrownBy(() -> lottoMachine.addBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 예외 테스트(보너스 숫자 입력이 숫자로 변환이 안되는 케이스)")
    void BonusNumericalExceptionTest() {
        String numbers = "20,10,3,2,41,24";
        LottoMachine lottoMachine = LottoMachine.initLottoMachineNumber(numbers).get();

        String bonusNumber = "4a";
        Assertions.assertThatThrownBy(() -> lottoMachine.addBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}