package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.lottogenerator.LottoGenerator;
import org.junit.jupiter.api.Test;

class SellerTest {

    class MockLottoGenerator implements LottoGenerator {

        @Override
        public List<PaidLotto> generateLottoList(Integer lottoMountPerPrice) {
            List<PaidLotto> lottos = new ArrayList<>();
            lottos.add(new PaidLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
            lottos.add(new PaidLotto(new Lotto(List.of(7, 8, 9, 10, 11, 12))));
            lottos.add(new PaidLotto(new Lotto(List.of(13, 14, 15, 16, 17, 18))));
            return lottos;
        }
    }

    @Test
    void 판매자는_사용자의_돈으로_로또번호를_만들어서_준다() throws Exception {
        MockLottoGenerator lottoGenerator = new MockLottoGenerator();
        Seller seller = new Seller(lottoGenerator);
        User user = new User("3000");
        seller.sellLotto(user);

        assertThat(user.getPaidLottoList()).usingRecursiveComparison()
            .isEqualTo(lottoGenerator.generateLottoList(3));
    }
}