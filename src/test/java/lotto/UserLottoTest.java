package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoTest {
    @DisplayName("UserLotto 생성자 테스트")
    @Test
    void userLottoConstructorTest() {
        //given
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);

        //when
        UserLotto userLotto = new UserLotto(lottoNumbers);

        //then
        assertThat(userLotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }
}
