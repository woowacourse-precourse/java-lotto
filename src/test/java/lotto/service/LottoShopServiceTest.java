package lotto.service;

import lotto.dto.WinningLottoNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopServiceTest {

    private LottoShopService service = new LottoShopService();

    @Test
    @DisplayName("당첨 로또 번호 dto 가져오기")
    void getWinningLottoNumber() {
        // given
        String writeLottoNumber = "1,2,3,4,5,6";
        String writeBonusNumber = "7";

        // when
        WinningLottoNumberDto result = service.getWinningLottoNumber(writeLottoNumber, writeBonusNumber);

        // then
        assertThat(result.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(result.getBonusNumber()).isEqualTo(7);
    }

}