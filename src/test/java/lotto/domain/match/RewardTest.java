package lotto.domain.match;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RewardTest {

    static Stream<Arguments> provideFindArguments() {
        return Stream.of(
                Arguments.of(7, false, null),
                Arguments.of(6, false, Reward.FIRST),
                Arguments.of(5, true, Reward.SECOND),
                Arguments.of(5, false, Reward.THIRD),
                Arguments.of(4, false, Reward.FOURTH),
                Arguments.of(3, false, Reward.FIFTH),
                Arguments.of(2, false, null),
                Arguments.of(1, false, null),
                Arguments.of(0, false, null),
                Arguments.of(-1, false, null),
                Arguments.of(4, true, Reward.FOURTH));
    }

    @ParameterizedTest
    @MethodSource("provideFindArguments")
    void find(int match, boolean requireBonus, Reward expect) {
        Reward reward = Reward.find(match, requireBonus);

        assertThat(reward).isEqualTo(expect);
    }
}