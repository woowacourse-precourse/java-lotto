package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("티켓의 번호를 출력 시 오름차순 정렬이 되어야 함.")
    @Test
    void testToString() {
        Lotto ticket = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        String output = ticket.toString();
        assertThat(output).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}