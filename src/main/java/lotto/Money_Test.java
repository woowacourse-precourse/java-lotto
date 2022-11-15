package lotto;

import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Money_Test {
        @DisplayName("돈이 1000원 단위가 아니면 예외가 발생한다.")
        @org.junit.jupiter.api.Test
        void MoneySize() {
            assertThatThrownBy(() -> new Money("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
