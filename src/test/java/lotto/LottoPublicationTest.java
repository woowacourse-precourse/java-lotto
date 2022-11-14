package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import lotto.domain.Lotto;
import lotto.domain.LottoPublication;
import lotto.domain.Lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublicationTest {

    @DisplayName("주어진 숫자만큼 로또 발행")
    @Test
    void publicationLottoByCount(){
        Lottos lottos = LottoPublication.publicationLottos(8);
        assertThat(lottos.getLotts().size()).isEqualTo(8);
    }

    @DisplayName("로또 번호 오름차순 정렬 테스트")
    @Test
    void sortLottoNumber(){
        Lotto lotto = new Lotto(Arrays.asList(1,6,2,5,3,4));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
