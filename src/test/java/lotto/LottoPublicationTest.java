package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import lotto.domain.lotto.Lotto;
import lotto.domain.lottoPublication.LottoPublication;
import lotto.domain.lotto.Lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublicationTest {
    @DisplayName("주어진 숫자만큼 로또 발행")
    @Test
    void publicationLottoByCount(){
        Lottos lottos = LottoPublication.publicationLottos(8);
        assertThat(lottos.getLottos().size()).isEqualTo(8);
    }

    @DisplayName("로또 번호 오름차순 정렬 테스트")
    @Test
    void sortLottoNumber(){
        Lotto lotto = new Lotto(List.of(1,6,2,5,3,4));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
