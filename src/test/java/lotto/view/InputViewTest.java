package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    public InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("숫자 입력 테스트")
    @ValueSource(strings = {"6000","가나다"})
    void checkInput(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        assertThat(InputView.priceInput()).isEqualTo(input);
    }

}