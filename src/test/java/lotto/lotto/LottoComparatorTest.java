package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoComparatorTest {

    @Test
    public void 로또_보너스_번호_테스트() {
        LottoGenerator generator = new LottoGenerator();
        Lotto answer = generator.getLotto();
        Lotto user = generator.getLotto();
        answer.getNumbers().add(user.getNumbers().get(3));

        boolean output = LottoComparator.isBonusMatched(answer.getNumbers(),
            user.getNumbers());

        assertTrue(output);
    }


    @Test
    public void 로또_맞은_개수_테스트() {
        LottoGenerator generator = new LottoGenerator();
        Lotto answer = generator.getLotto();
        Lotto user = new Lotto(answer.getNumbers());
        answer.getNumbers().add(14);

        int output = LottoComparator.getMatchedNumbers(answer.getNumbers(), user.getNumbers());

        assertEquals(output, 6);
    }
}