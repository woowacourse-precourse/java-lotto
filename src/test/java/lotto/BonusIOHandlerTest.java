package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusIOHandlerTest extends IOTest{
    private static BonusIOHandler bonusIOHandler;
    @BeforeAll
    static void initAll() {bonusIOHandler = new BonusIOHandler();}

    @Test
    @DisplayName("보너스 번호를 입력 검증")
    void getLottoAnswerTest(){
        systemIn("15");
        assertThat(bonusIOHandler.getBonus()).isEqualTo(15);
    }

    @Test
    @DisplayName("범위를 넘어선 보너스 번호 입력에 대한 예외처리 검증")
    void validateInputTest_invalidRange_IllegalArgumentException(){
        String input = "48";
        assertThatThrownBy(() -> bonusIOHandler.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호 또한 1~45 사이로 입력해주세요");
    }

}
