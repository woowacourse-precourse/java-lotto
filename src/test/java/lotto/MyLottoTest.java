package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyLottoTest {

    @DisplayName("구입 금액에 따라 로또를 생성한다.")
    @Test
    void createMyLotto() {
        MyLotto myLotto = new MyLotto(8);
        assertThat(myLotto.getMyLotto().size()).isEqualTo(8);
    }
}
