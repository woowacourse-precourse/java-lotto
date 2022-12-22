package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest extends NsTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("발행한 로또의 번호가 오름차순으로 정렬되는지 확인한다.")
    void IsSortedAscendingWhenIssueingLotto() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]"
                    );
                },
                List.of(43, 42, 41, 23, 21, 8),
                List.of(38, 32, 16, 11, 5, 3),
                List.of(44, 36, 35, 16, 11, 7),
                List.of(42, 41, 31, 11, 8, 1)
        );
    }

    @Test
    @DisplayName("구매 금액만큼 로또를 발행하는지 확인한다.")
    void IsIssueingLottosForPurchaseMoney() {
        run("8000");
        assertThat(output()).contains("8개를 구매했습니다.");
    }

    @Override
    public void runMain() { lottoGenerator.generate(); }
}
