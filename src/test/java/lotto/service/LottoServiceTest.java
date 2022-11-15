package lotto.service;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoSeller;
import lotto.domain.Money;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("LottoService 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setup() {
        LottoSeller lottoSeller = new LottoSeller();
        lottoService = new LottoService(lottoSeller);
    }

    @Test
    void buy_메서드는_사용자를_입력받아_로또를_구매하라고_메시지를_보낸_다음_구매한_로또의_정보를_반환한다() {
        Money givenAmount = Money.wons(2000);
        Customer customer = new Customer(givenAmount);

        LottoInformationDto lottoInformation = lottoService.buy(customer);

        assertThat(lottoInformation.getSize()).isEqualTo(2);
        assertThat(lottoInformation.getLottoTicket()).allMatch(lotto -> lotto.size() == LOTTO_NUMBERS_SIZE);
    }

    @Test
    void buy_메서드는_로또_구매에_실패하는_경우_IllegalArgumentException을_던진다() {
        Money givenAmount = Money.wons(2001);
        Customer customer = new Customer(givenAmount);

        assertThatThrownBy(() -> lottoService.buy(customer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_메서드는_올바르지_않은_당첨번호를_입력받는_경우_IllegalArgumentException을_던진다() {
        LottoDto lottoDto = new LottoDto(List.of(2, 2, 3, 4, 5, 6), 7);
        assertThatThrownBy(() -> lottoService.draw(lottoDto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_메서드는_당첨번호를_입력받아_LottoMachine을_반환한다() {
        LottoDto lottoDto = new LottoDto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoMachine lottoMachine = lottoService.draw(lottoDto);
        assertThat(lottoMachine).isNotNull();
    }

    @Test
    void check_메서드는_Customer가_로또를_구입하지_않은경우_IllegalStateException을_던진다() {
        Customer customer = new Customer(Money.wons(2000));
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        assertThatThrownBy(() -> lottoService.check(customer, lottoMachine))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void check_메서드는_Customer와_LottoMachine을_입력받아_LottoResultDto를_반환한다() {
        Customer customer = new Customer(Money.wons(2000));
        customer.buyLottoTicketTo(new LottoSeller());
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        assertThat(lottoService.check(customer, lottoMachine)).isInstanceOf(LottoResultDto.class);
    }
}
