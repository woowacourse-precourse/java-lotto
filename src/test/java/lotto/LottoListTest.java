package lotto;

import lotto.domain.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoListTest {

    @DisplayName("입력한 돈이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoListNotDivisionBy1000() {

        assertThatThrownBy(() -> new LottoDto(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 돈/1000 과 LottoList 사이즈는 같다.")
    @Test
    void createLottoListEqualSize() {
        LottoDto result = new LottoDto(9000);

        assertThat(result.getLottoList().size()).isEqualTo(9);
    }

    @Test
    void createLottoListToStringBy0() {
        LottoDto result = new LottoDto(0);
        String resultString = "0개 구매하셨습니다.";

        assertThat(resultString).isEqualTo(result.toString());
    }

    @Test
    void createLottoListToStringBy1() {
        LottoDto result = new LottoDto(1000);
        String resultString = "1개 구매하셨습니다."
                + "\n" + result.getLottoList().get(0).getNumbers();

        assertThat(resultString).isEqualTo(result.toString());
    }

    @Test
    void createLottoListToStringBy2() {
        LottoDto result = new LottoDto(2000);
        String resultString = "2개 구매하셨습니다."
                + "\n" + result.getLottoList().get(0).getNumbers()
                + "\n" + result.getLottoList().get(1).getNumbers();

        assertThat(resultString).isEqualTo(result.toString());
    }

}