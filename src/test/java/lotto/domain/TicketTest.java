package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {

    @DisplayName("구입금액에 따라 로또 개수를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "100000:100"}, delimiter = ':')
    void getLottoCountByMoney(int money, int lottoCount) {
        assertThat(new Ticket(money).getLottoCount()).isEqualTo(lottoCount);
    }

    @DisplayName("구입금액이 1000원 단위가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1500, 3372})
    void getLottoCountByNotUnitOf1000Won(int money) {
        assertThatThrownBy(() -> new Ticket(money).getLottoCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 오름차순으로 정렬된다.")
    @Test
    void getLottosByIncreasingOrder() {
        Ticket ticket = new Ticket(1000);
        assertThat(isIncreasingOrder(ticket.getLottos().get(0)))
                .isEqualTo(true);
    }

    private boolean isIncreasingOrder(Lotto lotto) {
        int before = 0;
        for (int number : lotto.getNumbers()) {
            if (before > number) {
                return false;
            }
            before = number;
        }
        return true;
    }
}