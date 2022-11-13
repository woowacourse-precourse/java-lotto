package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {
    @DisplayName("당첨 번호에 ',' 과 숫자가 아닌 다른 값이 있으면 예외 발생 1).")
    @Test
    void checkAnswerException1() {
        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,a";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6.a";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 숫자가 범위 내 숫자가 6개가 들어있는지 확인.")
    @Test
    void checkAnswerException2() {
        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,0";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,46";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,12,a";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5, ,12";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 ',,' 가 있는 경우 예외 발생).")
    @Test
    void checkAnswerException3() {
        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,,6";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 ',' 로 끝나는 경우.")
    @Test
    void checkAnswerException4() {
        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복되는 숫자가 있는 경우.")
    @Test
    void checkAnswerException5() {
        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "1,2,3,5,6,6";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String inputAnswer = "6,6,6,6,6,6";
            Answer.inputValidity(inputAnswer);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}