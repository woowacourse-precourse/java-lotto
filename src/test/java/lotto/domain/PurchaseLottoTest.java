package lotto.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseLottoTest {

    @Test
    void 로또_구매_금액_입력() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        String input="8000";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in =new ByteArrayInputStream(input.getBytes());
        System.setIn((in));
        purchaseLotto.inputMoney();
        Assertions.assertThat(purchaseLotto.inputMoney()).isEqualTo(8000);//입력받는 String 입력을 어떻게 하지?

    }
    @Test
    void 구매한_로또_개수_확인(){
        PurchaseLotto purchaseLotto =new PurchaseLotto();
        Assertions.assertThat(purchaseLotto.countLotto(8000)).isEqualTo(8);
    }
    @Test
    void 구매한_로또_개수_오류(){
        PurchaseLotto purchaseLotto =new PurchaseLotto();
        final RuntimeException exception=assertThrows(RuntimeException.class, () -> PurchaseLotto.countLotto(1200));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

}