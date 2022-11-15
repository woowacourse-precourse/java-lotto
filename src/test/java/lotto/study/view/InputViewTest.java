package lotto.study.view;

import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {

    @DisplayName("구입금액 공백 입력")
    @Test
    void 공백_금액_입력() {

        // given
        String userInput = "\0";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> {
            InputView.inputPayment();
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
            InputView.inputPayment();
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
        int result = InputView.inputPayment();

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
            InputView.inputLuckyBalls();
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
            InputView.inputLuckyBalls();
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
            InputView.inputLuckyBalls();
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
        List<Integer> result = InputView.inputLuckyBalls();

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
            InputView.inputBonus();
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
            InputView.inputBonus();
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
        int result = InputView.inputBonus();

        //then
        assertThat(result).isEqualTo(12);
    }

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("에러 로그 확인")
    @Test
    void 에러_로그_테스트(){
        //given
        String userInput = "1000j";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        //when
//        int result = InputView.inputPayment();

        //then
        assertThat(output.toString().contains("[ERROR]"));
        assertThatThrownBy(() -> InputView.inputPayment())
                .isInstanceOf(IllegalArgumentException.class);


    }

}