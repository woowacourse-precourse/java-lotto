package lotto;

import lotto.domain.LottoLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoLogicTest {
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
        assertThatThrownBy(() -> lottoLogic.setPrizeNumbers(List.of("1", "2", "3", "4", "5", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 문자가 있을 경우 예외가 발생한다.")
    @Test
    void inputPrizeNumbersContainChar() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        assertThatThrownBy(() -> lottoLogic.setPrizeNumbers(List.of("1", "2", "3", "4", "5", "k")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void inputPrizeNumbersByOverRange() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        assertThatThrownBy(() -> lottoLogic.setPrizeNumbers(List.of("1", "2", "3", "4", "5", "46")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호를 입력할 경우 예외가 발생한다.")
    @Test
    void inputBonusNumberByDuplicatedNumberByPrizeNumbers() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        lottoLogic.setPrizeNumbers(List.of("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> lottoLogic.setBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 보너스 번호를 입력할 경우 예외가 발생한다.")
    @Test
    void inputBonusNumbersContainChar() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        lottoLogic.setPrizeNumbers(List.of("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> lottoLogic.setBonusNumber("k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void inputBonusNumberByOverRange() {
        LottoLogic lottoLogic = new LottoLogic("1000");
        lottoLogic.setPrizeNumbers(List.of("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> lottoLogic.setBonusNumber("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 알맞은 개수의 로또가 생성된다.")
    @Test
    void createLottoByRightPriceNumber() {
        LottoLogic lottoLogic = new LottoLogic("3000");
        assertThat(lottoLogic.getMyLottos().size())
                .isEqualTo(3);

    }
}

