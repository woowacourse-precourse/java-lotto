package lotto.domain.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import lotto.domain.Award;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

class AwardManagerTest {
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public final void init() {
        System.setOut(new PrintStream(out));
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("makeAwards 테스트")
    class MakeAwards {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 당첨로또와_같은_값_개수를_리스트로_잘_반환하는지_테스트(List<Award> expected, String money, String winning, String bonus) {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        final byte[] buf = String.join("\n", money, winning, bonus).getBytes();
                        System.setIn(new ByteArrayInputStream(buf));

                        UserLotto userLotto = new UserLotto();
                        WinningLotto winningLotto = new WinningLotto();
                        BonusNumber bonusNumber = new BonusNumber();

                        assertThat(AwardManager.makeAwards(winningLotto, userLotto, bonusNumber)).isEqualTo(expected);
                    },
                    List.of(1,2,3,4,5,6)
            );
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of(Award.ZERO), "1000", "7,8,9,10,11,12", "13"),
                    Arguments.of(List.of(Award.ONE), "1000", "4,7,8,9,10,11", "12"),
                    Arguments.of(List.of(Award.TWO), "1000", "1,2,7,8,9,10", "11"),
                    Arguments.of(List.of(Award.THREE), "1000", "1,2,3,7,8,9", "10"),
                    Arguments.of(List.of(Award.FOUR), "1000", "1,2,3,4,7,8", "9"),
                    Arguments.of(List.of(Award.FIVE), "1000", "1,2,3,4,5,7", "8"),
                    Arguments.of(List.of(Award.FIVE_BONUS), "1000", "1,2,3,4,5,8", "6"),
                    Arguments.of(List.of(Award.SIX), "1000", "1,2,3,4,5,6", "7")

            );
        }
    }
}