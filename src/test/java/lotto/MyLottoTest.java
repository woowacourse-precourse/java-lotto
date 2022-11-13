package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {

    @DisplayName("구입 금액에 따라 로또를 생성한다.")
    @Test
    void createMyLotto() {
        MyLotto myLotto = new MyLotto(8);
        assertThat(myLotto.getMyLotto().size()).isEqualTo(8);
    }
}
