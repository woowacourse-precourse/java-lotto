package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    LottoService service = new LottoServiceImpl(new LottoFactory());

    @DisplayName("구매 금액으로 구매 수량 계산하기")
    @Test
    public void 구매금액에_따른_구매수량_계산하기()throws Exception {
        //given
        int orderPrice = 10000;

        //when
        int orderQuantity = service.getOrderQuantity(orderPrice);

        //then
        assertThat(orderQuantity).isEqualTo(10);
    }

    @DisplayName("구매수량만큼의 로또리스트 생성 테스트")
    @Test
    public void 구매수량만큼의_로또리스트_생성_테스트() throws Exception {
        //given
        int orderQuantity = 10;

        //when
        List<Lotto> lottos = service.createLottos(orderQuantity);

        //then
        assertThat(lottos.size()).isEqualTo(orderQuantity);
    }
}
