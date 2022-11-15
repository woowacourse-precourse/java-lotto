package lotto.application.service;

import lotto.application.port.in.dto.RequestBuyLottoDto;
import lotto.application.port.in.dto.RequestMatchDto;
import lotto.application.port.in.dto.ResponseBuyLottoDto;
import lotto.application.port.in.dto.ResponseMatchDto;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.reward.Reward;
import lotto.domain.reward.RewardTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void init() {
        lottoService = new LottoService();
    }

    @Test
    void matchWinningNumber() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 5, 6, 7));
        Lotto lotto2 = new Lotto(List.of(8, 21, 23, 41, 42, 43));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);

        Bonus bonus = new Bonus(7);
        Lotto winningLottoNumber = new Lotto(List.of(1, 2, 3, 5, 6, 8));

        ResponseBuyLottoDto responseBuyLottoDto = new ResponseBuyLottoDto(lottos);

        RequestMatchDto requestMatchDto = new RequestMatchDto(winningLottoNumber, bonus, responseBuyLottoDto);

        //when
        ResponseMatchDto responseMatchDto = lottoService.matchWinningNumber(requestMatchDto);
        RewardTable rewardTable = responseMatchDto.getRewardTable();

        //then
        assertThat(rewardTable.getRewards().size()).isEqualTo(1);
        assertThat(rewardTable.getRewards().get(0)).isEqualTo(Reward.SECOND);
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