package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseLottoTest {
    /**
     * input값을 따로 지정해주는 경우
     *
    @Test
    void inputParchaseMeony_Test() {
        ParchaseLotto parchaseLotto = new ParchaseLotto();
        assertEquals(parchaseLotto.inputParchaseMeony("3000"),3);
        assertThrows(IllegalArgumentException.class,()->{
            parchaseLotto.inputParchaseMeony("ab10");
        });
        assertThrows(IllegalArgumentException.class,()->{
            parchaseLotto.inputParchaseMeony("12345");
        });
    }
    */
    @DisplayName("적절한 갯수의 lotto를 생성하는지")
    @Test
    void LOTTO_생성(){
        List<Lotto> lottos = PurchaseLotto.drawLotto(3);
        assertThat(3).isEqualTo(lottos.size());
    }
}