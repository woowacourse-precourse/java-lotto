package lotto;

import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

/**
 * packageName : lotto
 * fileName : NumberGeneratorTest
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */
public class NumberGeneratorTest {
    @DisplayName("랜덤 번호를 부여하고 그 번호를 출력")
    @Test
    void createRandomNumberTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(NumberGenerator.createRandomNumber())
                            .contains(8, 21, 23, 41, 42, 43);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }
}
