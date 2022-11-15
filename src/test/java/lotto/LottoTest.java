package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 제공된_함수가_진짜_unique_하게_숫자를_추출하는가() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Set<Integer> numberSet = new HashSet<>(numbers);
            Assertions.assertThat(numberSet.size()).isEqualTo(numbers.size());
        }

    }

    @Test
    void Set_을_이용해_중복여부판별() {
        List<Integer> overlapList = List.of(1, 2, 2, 3, 4, 5);
        Set<Integer> set = new HashSet<>(overlapList);
        Assertions.assertThat(set.size()).isNotEqualTo(overlapList.size());
    }

    @Test
    void 부동소수점() {
        int cost = 8000;
        int prize = 5000;
        Assertions.assertThat(String.format("%.1f", (prize * 100.0 / cost))).isEqualTo("62.5");
    }

    @Test
    void 형변환실패하면_무슨예외발생하더라() {
        String brokenNumber = "a12";
        assertThatThrownBy(() -> Integer.parseInt(brokenNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
