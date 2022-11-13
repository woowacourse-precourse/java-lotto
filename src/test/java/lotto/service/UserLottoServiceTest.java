package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.constant.IntConstant;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoServiceTest {

    @DisplayName("money에 따라서 생성되는 리스트의 개수가 적절한지 확인한다.")
    @Test
    void createUserLotto() {
        List<Lotto> lottoNumber = UserLottoService.createLottoNumber( 10);
        Assertions.assertThat(lottoNumber.size()).isEqualTo(10);
    }
}