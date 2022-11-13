package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    private LottoController lottoController = new LottoController();

    @DisplayName("사용자가 잘못된 당첨번호 혹은 보너스 번호를 입력했을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10,2,30,40,5,6\n700", "1,2,30,40,5,6,7\n7", "1,2,30,40,5,6,7\n\n"
            , "1,2,3,4,5\n6", "1,2,3,a,4,5\n6", "1,2,3,4,5,6\na"})
    void createWinningLottoWithWrongInput(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        Assertions.assertThatThrownBy(() -> lottoController.createWinningLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}