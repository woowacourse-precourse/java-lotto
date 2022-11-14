package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @DisplayName("로또 구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void isNumeric() {
        assertThatThrownBy(() -> {
            User user = new User();
            command("asdf");
            user.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void isCorrectPrice() {
        assertThatThrownBy(() -> {
            User user = new User();
            command("1500");
            user.buy();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 발행 테스트")
    @Test
    void createLotto() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    User user = new User();
                    command("3000");
                    user.buy();
                    List<Lotto> lottos = user.getLottos();

                    assertThat(lottos.get(0).getNumbers())
                            .containsExactly(8, 21, 23, 41, 42, 43);
                    assertThat(lottos.get(1).getNumbers())
                            .containsExactly(3, 5, 11, 16, 32, 38);
                    assertThat(lottos.get(2).getNumbers())
                            .containsExactly(7, 11, 16, 35, 36, 44);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @DisplayName("당첨 등수 저장 테스트")
    @Test
    void saveResult() {
        User user = new User();
        user.saveResult(Rank.FIRST);
        user.saveResult(Rank.SECOND);
        user.saveResult(Rank.SECOND);

        assertThat(user.getResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(user.getResult().get(Rank.SECOND)).isEqualTo(2);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calcProfit() {
        User user = new User();
        command("8000");
        user.buy();
        user.saveResult(Rank.FIFTH);

        assertThat(user.calcProfit()).isEqualTo(62.5);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
