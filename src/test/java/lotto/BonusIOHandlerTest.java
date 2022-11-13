package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

}
