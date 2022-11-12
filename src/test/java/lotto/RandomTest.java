package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @DisplayName("랜덤 값이 잘 들어가는지 체크")
    @Test
    void getRandomTest() {
        List<Integer> randomnum = Random.randomList();
        assertThat(randomnum).isNotNull();
    }
}
