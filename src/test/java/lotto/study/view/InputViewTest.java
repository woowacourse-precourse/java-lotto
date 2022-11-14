package lotto.study.view;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {
    private final InputView inputView = new InputView();


    @DisplayName("구입금액 공백 입력")
    @Test
    void 공백_금액_입력() {

        // given
        String userInput = "\0";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputPayment();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금 숫자 이외 문자 입력")
    @Test
    void 숫자가_아닌_문자_금액_입력() {

        // given
        String userInput = "9000a";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputPayment();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 정상 입력")
    @Test
    void 정상_금액_입력() {

        // given
        String userInput = "12000";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        //when
        int result = inputView.inputPayment();

        //then
        assertThat(result).isEqualTo(12000);
    }

    @DisplayName("당첨번호 공백 입력")
    @Test
    void 공백_당첨번호_입력() {

        // given
        String userInput = "\0";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputLuckyBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 공백 포함")
    @Test
    void 당첨번호_입력_시_공백_포함() {

        // given
        String userInput = "1,2,3,4,5, 5";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputLuckyBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 문자 포함")
    @Test
    void 당첨번호_입력_패턴_이외_문자() {

        // given
        String userInput = "1,2,3,A,5,6";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputLuckyBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 정상 입력")
    @Test
    void 정상_당첨번호() {

        // given
        String userInput = "1,2,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        //when
        List<Integer> result = inputView.inputLuckyBalls();

        //then
        assertThat(result).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("보너스 번호 공백 입력")
    @Test
    void 공백_보너스_입력() {

        // given
        String userInput = "\0";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputBonus();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 숫자 이외 문자 입력")
    @Test
    void 숫자가_아닌_문자_보너스_입력() {

        // given
        String userInput = "a";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            inputView.inputBonus();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 정상 입력")
    @Test
    void 정상_보너스_입력() {

        // given
        String userInput = "12";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        //when
        int result = inputView.inputBonus();

        //then
        assertThat(result).isEqualTo(12);
    }

}