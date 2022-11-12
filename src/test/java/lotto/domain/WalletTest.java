package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WalletTest {

    @DisplayName("Wallet에 구매하기로한 갯수만큼 Lotto가 있어야한다.")
    @Test
    void checkLottoSizeInWallet() throws Exception {
        int lottoSize = 12;

        Wallet wallet = new Wallet(lottoSize);
        Field privateFiled = wallet.getClass().getDeclaredField("lottos");
        privateFiled.setAccessible(true);
        List<Lotto> lottos = (List<Lotto>) privateFiled.get(wallet);

        assertThat(lottos.size()).isEqualTo(lottoSize);
    }

}