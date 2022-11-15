package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class PresenterTest {
    @DisplayName("당첨 로또 번호 입력이 잘 되는지 확인")
    @Test
    void when_inputWinLottoNumbers_Expect_ListValue() {
        String inputWinLottoNumbers = "1,4,17,43,29,7";
        InputStream inputStream = new ByteArrayInputStream(inputWinLottoNumbers.getBytes());
        System.setIn(inputStream);
        assertThat(String.valueOf(Presenter.inputWinLottoNumber())).contains("[1, 4, 17, 43, 29, 7]");
    }

    @DisplayName("보너스 번호 입력이 잘 되는지 확인")
    @Test
    void when_inputBonusNumbers_Expect_IntValue() {
        String bonusNumber = "7";
        InputStream inputStream = new ByteArrayInputStream(bonusNumber.getBytes());
        System.setIn(inputStream);
        assertThat(Presenter.inputBonusNumber()).isEqualTo(7);
    }
}
