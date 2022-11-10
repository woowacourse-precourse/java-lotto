package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("6개의 랜덤 로또 번호 생성 및 저장")
    @Test
    void generateLottoTest() {
        String money = "4000";
        LottoGenerator lottoGenerator = new LottoGenerator();
        ArrayList<List<Integer>> lotteries;

        lottoGenerator.generateLotto(money);
        lotteries = lottoGenerator.getLotteries();

        assertEquals(lotteries.size(),4);

        for(int i=0; i<lotteries.size(); i++) {
            assertEquals(lotteries.get(i).size(), 6);
            assertThat(lotteries.get(i).stream().allMatch(v -> v >= 1 && v <= 45));
        }

        for(int i=1; i<lotteries.size(); i++) {
            assertNotEquals(lotteries.get(i), lotteries.get(i-1));
        }
    }
}