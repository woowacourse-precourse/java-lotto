package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoSeller 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoSellerTest {

    private LottoSeller lottoSeller = new LottoSeller();

    @ParameterizedTest
    @ValueSource(longs = {1000L, 2000L, 3000L, 4000L, 15000L, 60000L})
    void sell_메서드는_금액을_받고_로또_티켓을_반환한다(long amount) {
        Money buyAmount = Money.wons(amount);
        LottoTicket lottoTicket = lottoSeller.sell(buyAmount);
        assertThat(lottoTicket.value().size()).isEqualTo(amount / 1000);
    }

    @ParameterizedTest
    @ValueSource(longs = {999L, 1001L, 2345L, 142918L})
    void sell_메서드는_입력받은_금액이_부족하거나_구매하고_남은_금액이_존재하는_경우_IllegalArgumentException을_던진다(long amount) {
        Money buyAmount = Money.wons(amount);
        Assertions.assertThatThrownBy(() -> lottoSeller.sell(buyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
