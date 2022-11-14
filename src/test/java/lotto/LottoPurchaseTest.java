package lotto;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoPurchase;

import lotto.views.LottoPurchaseView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {

    @DisplayName("로또 구입 시 숫자를 입력받지 않으면 익셉션을 발생한다.")
    @Test
    void casePurchaseInputNotInteger(){
        assertThatThrownBy(() -> new LottoPurchase("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 시 음수 값을 입력 받으면 익셉션을 발생한다.")
    @Test
    void casePurchaseInputNegative(){
        assertThatThrownBy(() -> new LottoPurchase("-2000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 시 로또 가격 단위로 받지 않을 시 오류를 발생한다.")
    @Test
    void casePurchaseInputNotCorrectPriceUnit(){
        assertThatThrownBy(() -> new LottoPurchase("1800"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 맞게 알맞은 로또 발행 개수를 리턴한다.")
    @Test
    void getLottoPublicationCount(){
        LottoPurchase purchase = new LottoPurchase("2000");
        assertThat(purchase.getLottoPublicationCount()).isEqualTo(2);
    }

    @DisplayName("발행된 로또를 알맞게 출력하는지 확인")
    @Test
    void checkPublicationLottoOutputView(){
        Lotto lotto1 = new Lotto((List.of(1,2,3,4,5,6)));
        Lotto lotto2 = new Lotto((List.of(7,8,9,10,11,12)));

        Lottos lottos = new Lottos();

        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        LottoPurchaseView.printPurchaseLottoNumber(lottos);

        assertThat(out.toString()).isEqualTo("2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n");
    }
}
