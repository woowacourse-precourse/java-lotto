package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WinReturnResultTest {
    @DisplayName("로또를 한 개 구입하고 6개를 맞출 경우 수익률은 200000000%")
    @Test
    void 로또_1개구입_6개번호_당첨(){
        PurchasedLotto purchasedLotto = new PurchasedLotto(1000);
        List<Lotto> numbers = purchasedLotto.getPurchasedLottoNumbers();
        WinResult winResult = new WinResult(purchasedLotto, numbers.get(0).getNumbers(), 3);
        assertThat(winResult.getReturnRate()).isEqualTo(200000000);
        assertThat(winResult.getWinResult().get(WinType.SIX)).isEqualTo(1);
    }

    @DisplayName("로또를 한 개 구입하고 3개를 맞출 경우 수익률은 500%")
    @Test
    void 로또_1개구입_3개번호_당첨(){
        PurchasedLotto purchasedLotto = new PurchasedLotto(1000);
        List<Integer> numbers = purchasedLotto.getPurchasedLottoNumbers().get(0).getNumbers();
        List<Integer> mock = Arrays.asList(numbers.get(0), numbers.get(1), numbers.get(2), -1, -1, -1);
        WinResult winResult = new WinResult(purchasedLotto, mock, 3);
        assertThat(winResult.getReturnRate()).isEqualTo(500);
        assertThat(winResult.getWinResult().get(WinType.THREE)).isEqualTo(1);
    }

    @DisplayName("로또를 한 개 구입하고 당첨이 안 될 경우 수익률은 0%")
    @Test
    void 로또_1개구입_낙첨(){
        PurchasedLotto purchasedLotto = new PurchasedLotto(1000);
        List<Integer> numbers = purchasedLotto.getPurchasedLottoNumbers().get(0).getNumbers();
        List<Integer> mock = Arrays.asList(numbers.get(0), numbers.get(1), -1, -1, -1, -1);
        WinResult winResult = new WinResult(purchasedLotto, mock, 3);
        assertThat(winResult.getReturnRate()).isEqualTo(0);
        assertThat(winResult.getWinResult().get(WinType.NONE)).isEqualTo(1);
    }
}