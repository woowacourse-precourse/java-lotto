package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewConsoleTest {
    InputView iv = new InputViewConsole();

    @Test
    @DisplayName("구매금액 정상 입력")
    void getPurchaseAmount() {
        //given
        String inputMessage = "3000";
        InputStream is = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(is);

        //when
        int purchaseAmount = iv.askPurchaseAmount();

        //then
        Assertions.assertThat(purchaseAmount).isEqualTo(3000);
    }

    @Test
    @DisplayName("구매금액 비정상 입력")
    void getIllegalPurchaseAmount() {
        //given
        String inputMessage = "320d0";
        InputStream is = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(is);

        //when
        //then
        Assertions.assertThatThrownBy(() -> iv.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 정상 입력")
    void getWinningNumber() {
        //given
        String inputMessage = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1,2,3,4,5,6);
        InputStream is = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(is);


        //when
        List<Integer> winningNumbers = iv.askWinningNumbers();

        //then
        Assertions.assertThat(winningNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    @DisplayName("당첨 번호 비정상 입력")
    void getIllegalWinningNumber() {
        //given
        String inputMessage = ",3,2211,34";
        InputStream is = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(is);

        //when,then
        Assertions.assertThatThrownBy(()-> iv.askWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 정상 입력")
    void getBonusNumber() {
        //given
        String inputMessage = "1";
        Integer expectedNumber = 1;
        InputStream is = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(is);

        //when
        Integer bonusNumber = iv.askBonusNumber();

        //then
        Assertions.assertThat(bonusNumber).isEqualTo(expectedNumber);
    }

    @Test
    @DisplayName("보너스 번호 비정상 입력")
    void getIllegalBonusNumber() {
        //given
        String inputMessage = "d";

        InputStream is = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(is);

        //when,then
        Assertions.assertThatThrownBy(()-> iv.askBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}