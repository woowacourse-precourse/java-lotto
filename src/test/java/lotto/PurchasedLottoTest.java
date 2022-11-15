package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PurchasedLottoTest {

    @DisplayName("로또 구입 금액이 정상인 경우 아무일도 일어나지 않는다.")
    @Test
    void 구입금액이_정상인_경우() {
        assertThat(new PurchasedLotto(14000));
    }

    @DisplayName("로또 구입 금액이 1000의 배수가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입금액이_1000의_배수가_아닌_경우() {
        assertThatThrownBy(() -> new PurchasedLotto(1400))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void 구입금액이_음수인_경우() {
        assertThatThrownBy(() -> new PurchasedLotto(-3000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 정상인 경우 발급된 로또 개수 확인")
    @Test
    void 구입금액이_정상인_경우_() {
        Integer cost = 14000;
        PurchasedLotto purchasedLotto = new PurchasedLotto(cost);

        assertThat(purchasedLotto.getPurchasedLottoNumbers().size()).isEqualTo(cost / 1000);
    }



    @DisplayName("발행된 로또 정렬 확인")
    @Test
    void 발행된_로또_번호_정렬_확인(){
        PurchasedLotto purchasedLotto = new PurchasedLotto(10000);
        List<Lotto> lottos = purchasedLotto.getPurchasedLottoNumbers();
        boolean flag = true;
        for (Lotto lotto: lottos){
            List<Integer> numbers = lotto.getNumbers();
            Integer before = 0;
            for (Integer i: numbers){
                if(before>=i){
                    flag = false;
                    break;
                }
                before = i;
            }
        }
        assertThat(flag).isTrue();
    }
}