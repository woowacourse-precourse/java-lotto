package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 가진_돈으로_살_수있는_로도_개수_반환() throws Exception {
        User user = new User("4000");
        Integer lottoMountPerPrice = user.getLottoMountPerPrice(1000);
        assertThat(lottoMountPerPrice).isEqualTo(4);
    }

    @Test
    void 가진_돈으로_로또를_사면_가진_돈이_줄어든다() throws Exception {
        User user = new User("4520");
        user.getLottoMountPerPrice(1000);
        assertThat(user.getMoney()).isEqualTo(520);
    }

    @Test
    void 가진_돈을_반환한다() throws Exception {
        User user = new User("4560");
        assertThat(user.getMoney()).isEqualTo(4560);
    }

    @Test
    void 구매한_로또를_할당받는다() throws Exception {
        User user = new User("1000");
        List<PaidLotto> paidLottoList = List.of(
            new PaidLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        user.setPaidLottoList(paidLottoList);
        assertThat(user.getPaidLottoList()).isEqualTo(paidLottoList);
    }


}