package lotto.service;

import lotto.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("랜덤으로 번호를 100번 생성할 때 어떤 번호가 가장 많이 뽑힐까")
    void numberCount() {
        Map<Integer, Integer> numberAndCnt = initMap();

        List<Lotto> lotto = LottoGenerator.generateMyLotto(100);
        for (Lotto myLotto : lotto) {
            increaseMatchingNumberCount(numberAndCnt, myLotto.getNumbers());
        }

        List<Integer> maxAppearance = getMaxAppearanceNumbers(numberAndCnt);
        System.out.println("# Max Appearance Numbers: " + maxAppearance);
        System.out.println("# Count: " + numberAndCnt.get(maxAppearance.get(0)));
    }

    private Map<Integer, Integer> initMap() {
        Map<Integer, Integer> numberAndCnt = new HashMap<>();
        for (int i = 1; i < 46; i++) {
            numberAndCnt.put(i, 0);
        }
        return numberAndCnt;
    }

    private void increaseMatchingNumberCount(Map<Integer, Integer> numberAndCnt, List<Integer> numbers) {
        for (int number : numbers) {
            numberAndCnt.merge(number, 1, Integer::sum);
        }
    }

    private List<Integer> getMaxAppearanceNumbers(Map<Integer, Integer> numberAndCnt) {
        int maxCnt = 0;
        List<Integer> maxAppearance = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            int cnt = numberAndCnt.get(i);
            System.out.println(i + ": " + cnt);

            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxAppearance.clear();
                maxAppearance.add(i);
            } else if (maxCnt == cnt) {
                maxAppearance.add(i);
            }
        }
        return maxAppearance;
    }
}
