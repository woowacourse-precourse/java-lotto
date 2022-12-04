package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest extends NsTest{
    static LottoList lottos;
    @BeforeAll
    static void createLottoList() {
        lottos = new LottoList(8000L);
    }

    @Test
    void 로또랜덤갯수생성_테스트() {
        assertThat(lottos.getLottoCount()).isEqualTo(8L);
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
