package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoIssuerTest {

    @Test
    @DisplayName("유저가 입력한 로또 구입 금액에 알맞는 로또가 발행된 경우.")
    void generateAllLotto() {
        int amounts = 15000;
        List<Lotto> lottoList = LottoIssuer.generateAllLotto(amounts);
        assertEquals(lottoList.size(), amounts / 1000);
    }


}