package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    List<Integer> randomLotto = new ArrayList<>();
    TreeSet<Integer> sortedRandomLotto = new TreeSet<>();

    @DisplayName("TreeSet 의 오름차순 정렬을 확인하는 테스트")
    @Test
    void sortRandomLotto() {
        // 오름차순 정렬 1, 2, 15, 32, 41, 43
        sortedRandomLotto.add(2);
        sortedRandomLotto.add(41);
        sortedRandomLotto.add(15);
        sortedRandomLotto.add(43);
        sortedRandomLotto.add(32);
        sortedRandomLotto.add(1);

        assertEquals(6, sortedRandomLotto.size());
        assertTrue(sortedRandomLotto.last() == 43);
        assertFalse(sortedRandomLotto.first() == 15);
    }

    @DisplayName("1~45의 범위에서 서로 다른 6개의 번호를 뽑는지 확인하는 테스트")
    @Test
    void generateRandomLotto() {
        randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertEquals(6,randomLotto.size());
    }
}