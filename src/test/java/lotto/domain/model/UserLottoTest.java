package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @DisplayName("구매한 수량의 로또의 결과를 계산하여 리턴한다.")
    @Test
    void compareLottoNumber(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        LottoNumber lottoNumber = new LottoNumber("1,2,3,4,5,6", "7");
        List<LottoRank> result = List.of(LottoRank.THREE_MATCHES);
        Assertions.assertThat(new UserLotto(lottos).compareLottoNumber(lottoNumber)).isEqualTo(result);
    }

    @DisplayName("구매한 수량의 로또의 결과를 계산하여 리턴한다.: 6개 일치 8개")
    @Test
    void compareLottoNumber2(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        LottoNumber lottoNumber = new LottoNumber("1,2,3,4,5,6", "7");
        List<LottoRank> result = List.of(LottoRank.SIX_MATCHES, LottoRank.SIX_MATCHES, LottoRank.SIX_MATCHES,
                LottoRank.SIX_MATCHES, LottoRank.SIX_MATCHES, LottoRank.SIX_MATCHES, LottoRank.SIX_MATCHES,
                LottoRank.SIX_MATCHES);
        Assertions.assertThat(new UserLotto(lottos).compareLottoNumber(lottoNumber)).isEqualTo(result);
    }

    @DisplayName("구매한 수량의 로또의 결과를 계산하여 리턴한다. : 모든 결과")
    @Test
    void compareLottoNumber3(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 13)),
                new Lotto(List.of(1, 3, 4, 5, 6, 11)),
                new Lotto(List.of(3, 4, 5, 6, 8, 9)),
                new Lotto(List.of(2, 5, 6, 7, 8, 13)),
                new Lotto(List.of(6, 7, 8, 9, 10, 13))
        );
        LottoNumber lottoNumber = new LottoNumber("1,2,3,4,5,6", "13");
        List<LottoRank> result = List.of(LottoRank.SIX_MATCHES,
                LottoRank.FIVE_BONUS_MATCHES,
                LottoRank.FIVE_MATCHES,
                LottoRank.FOUR_MATCHES,
                LottoRank.THREE_MATCHES);
        Assertions.assertThat(new UserLotto(lottos).compareLottoNumber(lottoNumber)).isEqualTo(result);
    }

    @Test
    void purchaseLottoCheckQTY() {
        Pay input = new Pay("15000");

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        assertThat(new UserLotto(input).getUserLottoSize()).isEqualTo(lottos.size());
    }
}