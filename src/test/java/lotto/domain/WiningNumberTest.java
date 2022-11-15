package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiningNumberTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWiningLottoByOverSize() {
        assertThatThrownBy(() -> new WiningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWiningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WiningNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createWiningLottoByOverLength() {
        assertThatThrownBy(() -> new WiningNumber(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        WiningNumber winingNumber = new WiningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winingNumber.setBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverLength() {
        WiningNumber winingNumber = new WiningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winingNumber.setBonusNumber("50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 설정하기.")
    @Test
    void setWiningNumber() {
        //given
        List<Integer> winingNumbers = List.of(1, 2, 3, 4, 5, 6);
        WiningNumber winingNumber = new WiningNumber(winingNumbers);

        //when
        List<Integer> getLotto = winingNumber.getWiningNumber();

        //then
        assertThat(winingNumber.getWiningNumber()).isEqualTo(getLotto);
    }

    @DisplayName("보너스 번호 설정하기.")
    @Test
    void setBonusNumber() {
        //given
        List<Integer> winingNumbers = List.of(1, 2, 3, 4, 5, 6);
        WiningNumber winingNumber = new WiningNumber(winingNumbers);
        int bonusNumber = 7;

        //when
        winingNumber.setBonusNumber(String.valueOf(bonusNumber));

        //then
        assertThat(winingNumber.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
