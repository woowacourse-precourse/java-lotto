package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoLottoSellerTest {
    final AutoLottoSeller autoLottoSeller = new AutoLottoSeller();

    @Nested
    class buyLotto {


        @DisplayName("2000원 넣었을때 로또 2장 뽑히는지 확인")
        @Test
        void moneyInput2000() {
            int cnt = 2;
            int cntResult = (autoLottoSeller.buyLotto(2000)).size();

            assertEquals(cnt, cntResult);

        }

        @DisplayName("8000원 넣었을때 로또 8장 뽑히는지 확인")
        @Test
        void moneyInput8000() {
            int cnt = 8;
            int cntResult = (autoLottoSeller.buyLotto(8000)).size();

            assertEquals(cnt, cntResult);

        }
    }

}