package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("입력한 돈이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoListNotDivisionBy1000() {

        assertThatThrownBy(() -> new LottoMachine(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 돈/1000 과 LottoList 사이즈는 같다.")
    @Test
    void createLottoListEqualSize() {
        LottoMachine result = new LottoMachine(9000);

        assertThat(result.getLottoList().size()).isEqualTo(9);
    }

    @Test
    void createLottoListToStringBy0() {
        LottoMachine result = new LottoMachine(0);
        String resultString = "0개를 구매했습니다.";

        assertThat(resultString).isEqualTo(result.toString());
    }

    @Test
    void createLottoListToStringBy1() {
        LottoMachine result = new LottoMachine(1000);
        String resultString = "1개를 구매했습니다."
                + "\n" + result.getLottoList().get(0).getNumbers();

        assertThat(resultString).isEqualTo(result.toString());
    }

    @Test
    void createLottoListToStringBy2() {
        LottoMachine result = new LottoMachine(2000);
        String resultString = "2개를 구매했습니다."
                + "\n" + result.getLottoList().get(0).getNumbers()
                + "\n" + result.getLottoList().get(1).getNumbers();

        assertThat(resultString).isEqualTo(result.toString());
    }

    @DisplayName("금액이 0원 이하일 때 예외 발생")
    @Test
    void createLottoByDuplicatedCharacter() {
        assertThatThrownBy(() -> new LottoMachine(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

}