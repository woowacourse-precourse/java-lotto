package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class LottoStoreTest {

    LottoStore lottoStore = new LottoStore();

    @DisplayName("1000원으로 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void buyLottoByInvalidMoney() {
        Assertions.assertThatThrownBy(() -> lottoStore.buyLottoNumber(7900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 부족하여 구매할 수 없을 경우 예외가 발생한다.")
    @Test
    void buyLottoByNoMoney() {
        Assertions.assertThatThrownBy(() -> lottoStore.buyLottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2000원 지불시, 로또 2장 구매 메세지가 출력된다.")
    @Test
    void buyLottoBy2000(){
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lottoStore.buyLottoNumber(2000);

        Assertions.assertThat(outputStream.toString()).contains("2개를 구매했습니다.");
    }
}