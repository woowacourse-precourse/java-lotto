package lotto;

import lotto.domain.Rank;
import lotto.domain.User;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {

    @DisplayName("당첨 번호 입력 테스트")
    @Test
    void pickNum() {
        Winning winning = new Winning();
        command("1,2,3,4,5,6");
        winning.pickNum();
        List<Integer> numbers = winning.getNumbers();

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Test
    void pickBonus() {
        Winning winning = new Winning();
        command("6");
        winning.pickBonus();
        int bonus = winning.getBonus();

        assertThat(bonus).isEqualTo(6);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void pickNumByOverSize() {
        assertThatThrownBy(() -> {
            Winning winning = new Winning();
            command("1,2,3,4,5,6,7");
            winning.pickNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void pickNumByDuplicatedNumber() {
        assertThatThrownBy(() -> {
            Winning winning = new Winning();
            command("1,2,3,4,5,5");
            winning.pickNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 숫자 범위에 맞지 않으면 예외가 발생한다.")
    @Test
    void pickNumByIncorrectRange() {
        assertThatThrownBy(() -> {
            Winning winning = new Winning();
            command("60,2,3,4,5,5");
            winning.pickNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 숫자 범위에 맞지 않으면 예외가 발생한다.")
    @Test
    void pickBonusByIncorrectRange() {
        assertThatThrownBy(() -> {
            Winning winning = new Winning();
            command("60");
            winning.pickBonus();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 여부 테스트")
    @Test
    void compare() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    User user = new User();
                    Winning winning = new Winning();

                    command("3000", "4,5,6,7,8,9", "20");
                    user.buy();
                    winning.pickNum();
                    winning.pickBonus();

                    winning.draw(user);

                    assertThat(user.getResult().get(Rank.FOURTH)).isEqualTo(1);
                    assertThat(user.getResult().get(Rank.FIFTH)).isEqualTo(2);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(6, 7, 8, 9, 10, 11),
                List.of(4, 5, 6, 15, 16, 17)
        );
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
