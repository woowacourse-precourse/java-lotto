package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {
    @DisplayName("쉼표를 기준으로 정답 로또 번호를 생성할 수 있다.")
    @Test
    void createAnswerBySemicolon() {
        String str = "1,2,19,8,14,45";
        Answer answer = new Answer();
        answer.createAnswer(str);

        assertThat(answer.getAnswer()).isEqualTo(List.of(1, 2, 19, 8, 14, 45));
    }

    @DisplayName("널이면 생성할 수 없다.")
    @Test
    void createAnswerByNull() {
        assertThat(new Answer().validate("1,,21,23,"))
                .isEqualTo(false);
    }

    @DisplayName("같은 숫자가 있으면 생성할 수 없다.")
    @Test
    void createAnswerByDuplicatedNumber() {
        assertThat(new Answer().validate("1,2,2,3,9,11"))
                .isEqualTo(false);
    }

    @DisplayName("범위를 벗어나면 생성할 수 없다.")
    @Test
    void createAnswerByNotInRange() {
        assertThat(new Answer().validate("1,2,8,3,9,49"))
                .isEqualTo(false);
    }

    @DisplayName("숫자 외의 것이 들어오면 생성할 수 없다.")
    @Test
    void createAnswerByNotDigit() {
        assertThat(new Answer().validate("1,2,널,3,9,11"))
                .isEqualTo(false);
    }

    @DisplayName("보너스를 생성할 수 있다.")
    @Test
    void canCreateBonus() {
        String str = "1,2,19,8,14,45";
        Answer answer = new Answer();
        answer.createAnswer(str);
        answer.createBonus("4");

        assertThat(answer.getBonus()).isEqualTo(4);
    }

    @DisplayName("숫자 이외의 것으로 보너스를 생성할 수 없다.")
    @Test
    void createBonusByNotDigit() {
        assertThat(new Answer().validateBonus("일"))
                .isEqualTo(false);
    }

    @DisplayName("널로 보너스를 생성할 수 없다.")
    @Test
    void createBonusByNull() {
        assertThat(new Answer().validateBonus(""))
                .isEqualTo(false);
    }

    @DisplayName("범위 밖의 수로 보너스를 생성할 수 없다.")
    @Test
    void createBonusByNotInRange() {
        assertThat(new Answer().validateBonus("0"))
                .isEqualTo(false);
    }

    @DisplayName("정답에 있는 숫자로 보너스를 만들 수 없다.")
    @Test
    void createBonusByAnswerElement() {
        Answer answer = new Answer();
        answer.createAnswer("1,2,3,4,5,6");
        System.out.println(answer.getAnswer());

        assertThat(answer.validateBonus("6"))
                .isEqualTo(false);
    }
}