package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("보너스 숫자와 6개의 숫자 중복 예외처리")
    @Test
    public void 보너스_중복_예외() throws Exception {
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4, 5, 6, 7), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 초과한 값(1~45)을 입력 받으면 예외처리")
    @Test
    public void 범위_초과_예외() throws Exception {
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4, 5, 6, 46), 7))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4, 5, 6, 0), 7))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4, 5, 6, 7), 0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4, 5, 6, 7), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}