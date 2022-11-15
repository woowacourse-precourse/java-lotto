package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoIssueTest {

    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("금액에 맞게 로또를 발급한다")
    void getRightAmountOfLotto() {
        assertEquals(lottoService.issueLottoNumberGroup(10000).size(), 10);
    }
}
