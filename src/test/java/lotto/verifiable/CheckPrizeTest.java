package lotto.verifiable;

import lotto.Lotto;
import lotto.Prize;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CheckPrizeTest {

    @DisplayName("보너스 당첨시, 각 점수별 등수 반환")
    @Test
    void checkPrizeWithBonus() {
        Verifiable check = new CheckPrize();
        Integer prize = 0;
        List<Integer> prizeNumber = List.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3, 4, 5, 7)
        );
        Integer bonus = 18;

        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(bonus);
        List<Integer> number = numbers.get(0);
        Integer prizeCount = check.checkWithValue(new Prize(number, prizeNumber));
        Integer bonusCount = check.checkWithValue(new Prize(number, bonusNumber));
        if(prizeCount == 6 ){
            prize = 1;
        }else if (prizeCount == 5 && bonusCount == 1) {
            prize = 2;
        }else if(prizeCount == 5){
            prize = 3;
        }
        assertThat(prize).isEqualTo(3);
    }

    @DisplayName("보너스 당첨받지 못할 경우, 각 점수별 등수 반환")
    @Test
    void checkPrizesWithOutBonus() {
        Verifiable check = new CheckPrize();
        List<Integer> prizeNumber = List.of(1,2,3,4,5,6);
        List<List<Integer>> numbers = List.of(
                List.of(1,2,3,4,5,7)
        );
        Integer prize = 0;
        Integer bonus = 6;

        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(bonus);
        List<Integer> number = numbers.get(0);
        Integer prizeCount = check.checkWithValue(new Prize(number, prizeNumber));
        Integer bonusCount = check.checkWithValue(new Prize(number, bonusNumber));
        if(prizeCount == 6 ){
            prize = 1;
        }else if (prizeCount == 5 && bonusCount == 1) {
            prize = 2;
        }else if(prizeCount == 5){
            prize = 3;
        }
        assertThat(prize).isEqualTo(3);
    }
}