package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Answer;

public class AnswerTest {
	private Answer answer;
	
	@BeforeEach
	void setup() {
		answer = new Answer();
	}
	
	@DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void createLottoByOverSize(String numbers) {
		assertThatThrownBy(() -> answer.setNumbers(numbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호가 올바르지 않습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,4,4", "1,2,1,4,1,1"})
    void createLottoByDuplicatedNumber(String numbers) {
        assertThatThrownBy(() -> answer.setNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호가 올바르지 않습니다.");
    }

    @DisplayName("로또 번호 범위가 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,-5", "1,2,3,4,5,0"})
    void createLottoByRangeExceedNumber(String numbers) {
        assertThatThrownBy(() -> answer.setNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 범위가 올바르지 않습니다.");
    }
    
    @DisplayName("로또 번호에 숫자 아닌 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5, 6", "1,2,3,4 ,5,6", "1,2,3,4,5,x", "1,2,3,4,5, "})
    void createLottoBycontainsNotNumber(String numbers) {
        assertThatThrownBy(() -> answer.setNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 int 포멧에 어긋납니다.");
    }
    
    @DisplayName("보너스 번호에 숫자 아닌 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"bonus", "", " 15", "15 "})
    void createBonusBycontainsNotNumber(String bonus) {
        assertThatThrownBy(() -> answer.setBonus(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 int 포멧에 어긋납니다.");
    }
    
    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "100", "-5"})
    void createBonusByRangeExceedNumber(String bonus) {
    	answer.setNumbers("1,2,3,4,5,6");
    	
        assertThatThrownBy(() -> answer.setBonus(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호 범위가 올바르지 않습니다.");
    }
    
    @DisplayName("보너스 번호가 당첨 번호와 중복된 값을 가진다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void createBonusByDuplicatedNumber(String bonus) {
    	answer.setNumbers("1,2,3,4,5,6");
    	
        assertThatThrownBy(() -> answer.setBonus(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 올바르지 않습니다.");
    }
}
