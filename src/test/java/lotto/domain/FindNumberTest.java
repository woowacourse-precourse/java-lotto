package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNumberTest {
    final FindNumber findNumber = new FindNumber();
    final List<Integer> answer = List.of(6, 7, 5, 4, 3, 2);


    @Nested
    class findSameNumberTest {

        @DisplayName("로또들과 당첨번호와 보너스 번호를 비교하여 몇개의 숫자가 맞는지 판별하는 테스트")
        @Test
        void compareNumber() {

            List<Lotto> lotto = List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                    new Lotto(List.of(2, 3, 4, 5, 6, 8)),
                    new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                    new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                    new Lotto(List.of(5, 6, 7, 8, 9, 10))
            );

            List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonus = 7;

            List<Integer> result = findNumber.findSameNumber(lotto, winNumbers, bonus);
            assertEquals(answer, result);

        }
    }

}