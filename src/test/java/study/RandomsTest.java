package study;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomsTest {
    @Test
    @DisplayName("랜덤하고 중복되지 않는 숫자들이 생성된다.")
    public void pickRandomUniqueNumbers() {
        int count = 6;
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(1, 45, count);
        Set<Integer> uniqueNubmers = new HashSet<>(numbers);

        assertThat(uniqueNubmers.size()).isEqualTo(count);
    }
}
