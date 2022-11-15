package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domian.UserSingleLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserSingleLottoNumberTest {

    @DisplayName("생성자 테스트")
    @Test
    void userSingleLottoNumberConstructorTest() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        UserSingleLottoNumber singleLottoNumber = new UserSingleLottoNumber(lottoNumbers);

        // then
        assertThat(lottoNumbers).isEqualTo(singleLottoNumber.getLottoNumbers());
    }


}
