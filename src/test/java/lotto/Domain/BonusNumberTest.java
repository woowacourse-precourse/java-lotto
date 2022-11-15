package lotto.Domain;

import lotto.Domain.BonusNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @DisplayName("보너스 번호는 당첨 번호와 중복되면 예외가 발생한다.")
    void duplicateInputBonusNumber() {
        //given
        String inputBonusNumber = "5";
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        List<Integer> winnerLottoNumber = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9));

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bonusNumber.duplicateInputBonusNumber(winnerLottoNumber); //when
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void validInputBonusNumber() {
        assertThatThrownBy(() -> new BonusNumber("1ks"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    void outOfRangeBonusNumber() {
        assertThatThrownBy(() -> new BonusNumber("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
