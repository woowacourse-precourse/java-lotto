package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoLogic;
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
    @DisplayName("로또 번호가 1~45 사이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 단위로 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void buyLottoByMoneyNotDividedByThousand() {
        assertThatThrownBy(() -> new LottoLogic("3500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void inputPrizeNumbersByDuplicatedNumber() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        assertThatThrownBy(() -> lottoLogic.setPrizeNumbers(List.of("1","2","3","4","5","5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 문자가 있을 경우 예외가 발생한다.")
    @Test
    void inputPrizeNumbersContainChar() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        assertThatThrownBy(() -> lottoLogic.setPrizeNumbers(List.of("1","2","3","4","5","k")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호를 입력할 경우 예외가 발생한다.")
    @Test
    void inputBonusNumberByDuplicatedNumberByPrizeNumbers() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        lottoLogic.setPrizeNumbers(List.of("1","2","3","4","5","6"));
        assertThatThrownBy(() -> lottoLogic.setBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
