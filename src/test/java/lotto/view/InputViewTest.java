package lotto.view;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    public void generateInputView() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"20000"})
    void 로또_구입_금액_입력_받기(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();

        assertThat(lottoPurchaseAmount).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20000"})
    void 로또_당첨_번호_입력_받기(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();

        assertThat(lottoWinningNumbers).isEqualTo(input);
    }
}