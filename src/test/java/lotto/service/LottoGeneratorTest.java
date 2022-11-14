package lotto.service;

import lotto.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoGeneratorTest {

    private List<Lotto> lotto = LottoGenerator.generateMyLotto(1);
    private List<Integer> numbers = lotto.get(0).getNumbers();

    @Test
    @DisplayName("구매 개수에 맞게 로또가 생성된다.")
    void lottoSizeTest() {
        // given
        int purchaseCount = 3;

        // when
        List<Lotto> lotto = LottoGenerator.generateMyLotto(purchaseCount);

        // then
        assertEquals(purchaseCount, lotto.size());
    }

    @Test
    @DisplayName("랜덤으로 생성된 로또 번호는 정렬되어 있다.")
    void sortTest() {
        // then
        for (int i = 0; i < numbers.size() - 1; i++) {
            int curNumber = numbers.get(i);
            int nextNumber = numbers.get(i + 1);
            assertTrue(curNumber < nextNumber);
        }
    }

    @Test
    @DisplayName("랜덤으로 생성된 로또 번호는 6개이다.")
    void numbersSizeTest() {
        // then
        assertEquals(6, numbers.size());
    }

    @Test
    @DisplayName("랜덤으로 생성된 로또 번호는 중복이 없다.")
    void duplicationTest() {
        // when
        long deduplicatedCount = numbers.stream().distinct().count();

        // then
        assertEquals(numbers.size(), deduplicatedCount);
    }
}
