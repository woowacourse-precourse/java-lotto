package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Customer 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerTest {

    @Test
    void buyLottoTicketTo_메서드는_가지고_있는_금액을_모두_소비하여_로또를_구매한다() {
        Customer customer = new Customer(Money.wons(2000));

        customer.buyLottoTicketTo(new LottoSeller());

        assertThat(customer.getLottoTicket()).isNotNull();
    }

    @Test
    void check_메서드는_LottoMachine을_입력받아_LottoMachine의_check_메서드를_호출한다() {
        Customer customer = new Customer(Money.wons(2000));
        customer.buyLottoTicketTo(new LottoSeller());

        LottoMachine lottoMachine = mock(LottoMachine.class);
        customer.check(lottoMachine);

        verify(lottoMachine, only()).check(customer.getLottoTicket());
    }

    @Test
    void check_메서드는_티켓이_없는경우_IllegalStateException을_던진다() {
        Customer customer = new Customer(Money.wons(2000));

        LottoMachine lottoMachine = mock(LottoMachine.class);
        assertThatThrownBy(() -> customer.check(lottoMachine))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getLottoTicket_메서드는_구매한_티켓을_반환한다() {
        Customer customer = new Customer(Money.wons(2000));
        customer.buyLottoTicketTo(new LottoSeller());

        assertThat(customer.getLottoTicket()).isNotNull();
    }

    @Test
    void getLottoTicket_메서드는_티켓이_없는경우_IllegalStateException을_던진다() {
        Customer customer = new Customer(Money.wons(2000));

        assertThatThrownBy(customer::getLottoTicket)
                .isInstanceOf(IllegalStateException.class);
    }
}
