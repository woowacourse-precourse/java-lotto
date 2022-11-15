package lotto;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.UserLotto;
import lotto.util.LottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @DisplayName("lottoGenerator 사이즈만큼 생성")
    @Test
    void lottoGeneratorSizeTest(){
        //given
        int lottoSize = 3;
        //when
        List<UserLotto> userLottos = LottoNumbersGenerator.lottoGenerator(lottoSize);
        //then
        assertThat(userLottos.size()).isEqualTo(3);

    }

    @DisplayName("lottoGenerator 생성시 1부터 45")
    @Test
    void lottoGeneratorNumbersTest(){
        //given
        int lottoSize = 1;
        //when
        List<UserLotto> userLottos = LottoNumbersGenerator.lottoGenerator(lottoSize);
        //then
        for(int numberEach : userLottos.get(0).getLottoNumbers()) {
            assertThat(numberEach)
                    .isLessThanOrEqualTo(45);
        }
    }

    @DisplayName("lottoGenerator 생성시 모든 리스트의 사이즈는 6이다.")
    @Test
    void lottoGeneratorListSizeTest(){
        //given
        int lottoSize = 3;
        //when
        List<UserLotto> userLottos = LottoNumbersGenerator.lottoGenerator(lottoSize);
        //then
        for(UserLotto userLottoEach : userLottos) {
            assertThat(userLottoEach.getLottoNumbers().size())
                    .isEqualTo(6);
        }
    }
}
