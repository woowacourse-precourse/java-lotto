package lotto;

import org.junit.jupiter.api.BeforeEach;
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

    @DisplayName("로또를 사는 돈이 1000의 배수가 아니면 예외 발생")
    @Test
    void inputWrongNum(){
        assertThatThrownBy(() -> new Buyer("15500"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 당첨 번호 입력시 6개가 넘어가면 예외발생")
    @Test

    void WinningNumRange(){
        Buyer buyer = new Buyer();
        assertThatThrownBy(() -> buyer.getWinningNum("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력시 중복이 있으면 예외발생")
    @Test

    void DuplicateWinningNum(){
        Buyer buyer = new Buyer();
        assertThatThrownBy(() -> buyer.getWinningNum("1,1,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력시 1~45범위안의 수가 아니면 예외발생")
    @Test

    void WinningNumRangeOut(){
        Buyer buyer = new Buyer();
        assertThatThrownBy(() -> buyer.getWinningNum("0,2,3,4,5,6,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
