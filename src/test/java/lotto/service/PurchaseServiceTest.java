package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseServiceTest extends NsTest {

    PurchaseService purchaseService;

    public PurchaseServiceTest() {
        this.purchaseService = new PurchaseService();
    }

    @Test
    @DisplayName("로또 사기")
    void test1() {
        run("8000");

        List<Lotto> purchase = purchaseService.purchase();
    }

    @Override
    protected void runMain() {

    }
}