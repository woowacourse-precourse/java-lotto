package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseServiceTest extends NsTest {

    PurchaseService purchaseService;

    public PurchaseServiceTest() {
        this.purchaseService = new PurchaseService();
    }

    @Test
    @DisplayName("로또 8개 사기")
    void test1() {
        // given
        run("8000");

        // when
        List<Lotto> lottos = purchaseService.purchase();

        // then
        assertEquals(8, lottos.size());
        assertThat(output()).contains("8개를 구매했습니다.");
    }

    @Override
    protected void runMain() {

    }
}