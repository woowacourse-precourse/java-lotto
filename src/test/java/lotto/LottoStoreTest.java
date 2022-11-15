package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest extends NsTest {
    @DisplayName("당첨번호를 6개 이상 입력하면 예외가 발생한다.")
    @Test
    void setWinNumberByOverSize() {
        assertThatThrownBy(() -> {
                    LottoStore lottoStore = new LottoStore();
                    lottoStore.setWinNumbers("1,2,3,4,5,6,7");
                }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
