package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoSeller 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoSellerTest {

    private LottoSeller lottoSeller = new LottoSeller();

    @ParameterizedTest
    @CsvSource(value = {"1000", "2000", "3000", "4000"})
    void sell_메서드는_금액을_받고_로또_티켓을_반환한다(int amount) {
        assertThat(lottoSeller.sell(amount)).isInstanceOf(LottoTicket.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 2345})
    void sell_메서드는_입력받은_금액이_부족하거나_구매하고_남은_금액이_존재하는_경우_IllegalArgumentException을_던진다(int amount) {
        Assertions.assertThatThrownBy(() -> lottoSeller.sell(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
