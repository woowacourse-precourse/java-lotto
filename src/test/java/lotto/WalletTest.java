package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class WalletTest extends NsTest {
    @DisplayName("0보다 적은 값을 설정하면 오류가 발생한다.")
    @Test
    void setMoneyLowerThanZero() {
        assertThatThrownBy(() -> {
            Wallet wallet = new Wallet();
            wallet.setMoney("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또가 없으면 0개를 구매했다고 출력한다.")
    @Test
    void showMyLottosWithEmptyList() {
        Wallet wallet = new Wallet();
        wallet.buyLottos(Collections.emptyList());
        wallet.showMyLottos();
        assertThat(output()).contains("0개를 구매했습니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
