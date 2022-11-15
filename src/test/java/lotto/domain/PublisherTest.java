package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PublisherTest extends NsTest {
    
    @DisplayName("로또 구매 금액이 1000 단위가 아니면 예외가 발생한다.")
    @Test
    void createPublisherByWrongNumber() {
        assertThatThrownBy(() -> new Publisher(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 발행이 정상적으로 되는지 확인한다.")
    @Test
    void createLotteries() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    public void runMain() {
        Publisher publisher = new Publisher(8000);
        for (Lotto lotto : publisher.getLotteries()) {
            System.out.println(lotto);
        }
    }
}
