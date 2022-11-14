package lotto.application.service;

import lotto.application.port.in.RequestBuyLottoDto;
import lotto.application.port.in.ResponseBuyLottoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void init() {
        lottoService = new LottoService();
    }

    @Test
    void buyLotto() {
        //given
        RequestBuyLottoDto requestBuyLottoDto = new RequestBuyLottoDto("5000");
        RequestBuyLottoDto errorRequestDto = new RequestBuyLottoDto("500영");
        //when
        ResponseBuyLottoDto response = lottoService.buyLotto(requestBuyLottoDto);

        //then
        assertThat(response.getLottos().size()).isEqualTo(5);

        assertThatThrownBy(() -> lottoService.buyLotto(errorRequestDto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

}