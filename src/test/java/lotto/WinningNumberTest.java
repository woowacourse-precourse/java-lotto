package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("당첨 번호가 숫자와 쉼표로 구성되어있지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumberByLetter() {

    }
    @DisplayName("보너스 숫자가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByLetter() {

    }
    @DisplayName("보너스 숫자가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusNotBetweenRange() {

    }
    @DisplayName("보너스 숫자가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicateNumber() {

    }
    @DisplayName("당첨 번호는 쉼표로 나눈다.")
    @Test
    void divideWinningNumberByComma() {

    }
}
