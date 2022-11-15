package Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 볼이 일치하는지 확인한다.")
    void matchBonusNumber() {
        //given
        String bonusBall = "17";
        BonusNumber bonusNumber = new BonusNumber(bonusBall);
        List<Integer> unMatchUserBall = new ArrayList<>(Arrays.asList(1, 7, 3, 17, 20, 21));
        int expectResult = 1;

        //when
        int result = bonusNumber.matchBonusNumber(unMatchUserBall);

        //then
        assertEquals(expectResult, result);
    }

    @Test
    void duplicateInputBonusNumber() {
    }
}