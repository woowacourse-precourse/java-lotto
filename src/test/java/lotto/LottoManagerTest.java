package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoManagerTest extends NsTest {
    // 사용자 입력 테스트
    @DisplayName("입력 금액이 1,000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 입력_금액_1000원_단위_테스트() {
        assertThatThrownBy(() -> new LottoManager().insertMoney("1001")).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("입력 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void 입력_금액_정수_테스트() {
        assertThatThrownBy(() -> new LottoManager().insertMoney("1000j")).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> new LottoManager().insertMoney("abcd")).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("입력 금액이 자연수가 아니면 예외가 발생한다.")
    @Test
    void 입력_금액_자연수_테스트() {
        assertThatThrownBy(() -> new LottoManager().insertMoney("-1000")).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("당첨번호가 6자리가 아니면 예외가 발생한다.")
    @Test
    void 입력_당첨번호_갯수_테스트() {
        assertThatThrownBy(() -> new LottoManager().insertWinningNumber("1,2,3,4,5")).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("당첨번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void 입력_당첨번호_자연수_테스트() {
        assertThatThrownBy(() -> new LottoManager().insertMoney("1,2,3,4,5,a")).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("당첨번호가 1~45자연수가 아니면 예외가 발생한다.")
    @Test
    void 입력_당첨번호_범위_테스트() {
        assertThatThrownBy(() -> new LottoManager().insertMoney("0,2,3,4,5,6")).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> new LottoManager().insertMoney("46,2,3,4,5,6")).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> new LottoManager().insertMoney("45,2,3,4,5,6"));
        assertThatThrownBy(() -> new LottoManager().insertMoney("1,2,3,4,5,6"));
    }


    @Override
    protected void runMain() {

    }
}
