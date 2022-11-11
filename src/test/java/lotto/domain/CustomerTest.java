package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Customer 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerTest {

    @Test
    void buy_메서드는_가지고_있는_금액을_모두_소비하여_로또를_구매한다() {
        Customer customer = new Customer(2000);

        customer.buyLottoTicketTo(new LottoSeller());

        assertThat(customer.getLottoTicket()).isInstanceOf(LottoTicket.class);
    }
}
