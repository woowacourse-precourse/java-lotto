package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest extends NsTest {

    @Test
    void generateLottoListTest() {
        LottoShop lottoShop = new LottoShop();
        lottoShop.generateLottoList(3000);

        assertThat(output()).contains(
                "3개를 구매했습니다."
        );
    }

    @Override
    protected void runMain() {
    }
}