package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    LottoController lc = new LottoController();

    @DisplayName("입력된 금액이 천원으로 나누어지는 수가 아닐시 예외 발생")
    @Test
    void isRemainderZeroWhenDividedByThousand() {
        assertThatThrownBy(() -> lc.readUserMoney("1760"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 0일시 예외 발생")
    @Test
    void isInputNumberNotZero() {
        assertThatThrownBy(() -> lc.readUserMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수가 아닌 문자가 입력될시 예외 발생")
    @Test
    void isInputNumberConsistOfDigit() {
        assertThatThrownBy(() -> lc.readUserMoney("1칠60"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("형식에 맞지 않는 당첨 번호 입력시 예외 발생")
    @Test
    void isWinNumberUnvalid() {
        assertThatThrownBy(() -> lc.readWinNumber("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lc.readWinNumber("0,1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("형식에 맞는 번호 입력시 로또가 생성")
    @Test
    void isWinNumberValid() {
        //given
        Lotto validLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        //when
        Lotto createdLotto = lc.readWinNumber("6,5,4,3,2,1");

        //then
        assertThat(createdLotto.toString()).isEqualTo(validLotto.toString());
    }
}
