package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static lotto.constant.Message.ERROR_MESSAGE;
import static lotto.constant.Message.INVALID_WINNING_LOTTO_INPUT_FORMAT_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "123456"})
    void 당첨_번호_입력_형식_예외_처리(String input) {
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> inputView.inputWinningLottoNumber());

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INVALID_WINNING_LOTTO_INPUT_FORMAT_MESSAGE);
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void 당첨_번호_입력_형식_옳은_경우(String lottoInput, String bonusInput) {
        InputView inputView = new InputView();

        InputStream in = createInputStrea(lottoInput, bonusInput);
        System.setIn(in);
        WinningLotto winningLotto = inputView.inputWinningLottoNumber();

        assertEquals(List.of(9, 2, 3, 4, 5, 1), winningLotto.getNumbers());
    }

    private InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("9,2,3,4,5,1\n", "7")
        );
    }

    private InputStream createInputStrea(String lottoInput, String bonusInput) {
        List<InputStream> streams = Arrays.asList(
                generateInput(lottoInput),
                generateInput(bonusInput)
        );
        return new SequenceInputStream(Collections.enumeration(streams));
    }
}
