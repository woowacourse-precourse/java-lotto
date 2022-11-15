package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CasherTest {

    @Tag("issueTickets")
    @DisplayName("1000원 단위로 티켓을 발행한다.")
    @Test
    void issueTickets() {
        int money = 8000;
        int expected = 8;
        assertThat(Casher.calculateTicketsNumber(money)).isEqualTo(expected);
    }

    @Tag("issueTickets")
    @DisplayName("잘못된 금액을 입력할 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"8001", "8000j"})
    void wrongInputToIssueTickets(String wrongInput) {
        assertThatThrownBy(() -> Casher.calculateTicketsNumber(Integer.parseInt(wrongInput)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
