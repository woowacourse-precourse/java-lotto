package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    private List<Lotto> lottos;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1,2,3,4,5,6));
        lottos.add(lotto);
    }

    @DisplayName("숫자가 아닌 것을 입력하면 예외가 발생한다.")
    @Test
    void inputByNotNumber() {
        assertThatThrownBy(() -> new User("ABC", lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 것을 입력하면 예외가 발생한다.")
    @Test
    void inputByNotDividedBy1000() {
        assertThatThrownBy(() -> new User("15001", lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
