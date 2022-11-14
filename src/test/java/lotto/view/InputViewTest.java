package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    InputView inputView;
    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "123456"})
    void 당첨_번호_입력_형식_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> inputView.inputWinningLottoNumber());

        assertEquals(exception.getMessage(), ERROR_MESSAGE + INVALID_WINNING_LOTTO_INPUT_FORMAT_MESSAGE);
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void 당첨_번호_입력_형식_옳은_경우(String lottoInput, String bonusInput) {
        InputStream in = createInputStream(lottoInput, bonusInput);
        System.setIn(in);
        WinningLotto winningLotto = inputView.inputWinningLottoNumber();

        assertEquals(List.of(9, 2, 3, 4, 5, 1), winningLotto.getNumbers());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5","1,1,2,3,4,5"})
    void 당첨_번호_중복_시_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5","1,2,3,4,5,46"})
    void 당첨_번호_범위_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5","1,2,3,4,5"})
    void 당첨_번호_6개_아닐_시_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideNotDigitInput")
    void 보너스_번호_숫자_아닐_시_예외_처리(String lotto, String bonus) {
        InputStream in = createInputStream(lotto, bonus);
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateInput")
    void 보너스_번호_중복_시_예외_처리(String lotto, String bonus) {
        InputStream in = createInputStream(lotto, bonus);
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "a"})
    void 구매_금액_입력_형식_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputPurchasedAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2200", "1111"})
    void 구매_금액_단위_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputPurchasedAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1"})
    void 구매_금액_최소값_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.inputPurchasedAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static Stream<Arguments> provideDuplicateInput() {
        return Stream.of(
                Arguments.of("9,2,3,4,5,1\n", "1"),
                Arguments.of("9,2,3,4,5,1\n", "9"),
                Arguments.of("9,2,3,4,5,1\n", "2")
        );
    }

    private static Stream<Arguments> provideNotDigitInput() {
        return Stream.of(
                Arguments.of("9,2,3,4,5,1\n", "a"),
                Arguments.of("9,2,3,4,5,1\n", "ㅈ"),
                Arguments.of("9,2,3,4,5,1\n", "g")
        );
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("9,2,3,4,5,1\n", "7")
        );
    }


    private InputStream createInputStream(String lottoInput, String bonusInput) {
        List<InputStream> streams = Arrays.asList(
                generateInput(lottoInput),
                generateInput(bonusInput)
        );
        return new SequenceInputStream(Collections.enumeration(streams));
    }
}
