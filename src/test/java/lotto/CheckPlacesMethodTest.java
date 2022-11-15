package lotto;

import lotto.Application.Places;
import lotto.Application.NumberType;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.checkPlaces;
import static lotto.Application.initializeNumberType;
import static lotto.Application.numberType;
import static org.assertj.core.api.Assertions.assertThat;

class CheckPlacesMethodTest {
    static ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    static int bonusNumber = 7;

    @DisplayName("당첨 순위 안에 들지 못한 경우 1")
    @Test
    void checkPlaces_메소드_테스트1() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(7, 8, 9, 10, 11, 12));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 순위 안에 들지 못한 경우 2")
    @Test
    void checkPlaces_메소드_테스트2() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(6, 7, 8, 9, 10, 11));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.NONE);
    }

    @DisplayName("당첨 순위 안에 들지 못한 경우 3")
    @Test
    void checkPlaces_메소드_테스트3() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(5, 6, 7, 8, 9, 10));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.NONE);
    }

    @DisplayName("5등에 당첨된 경우")
    @Test
    void checkPlaces_메소드_테스트4() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.FIFTH);
    }

    @DisplayName("4등에 당첨된 경우")
    @Test
    void checkPlaces_메소드_테스트5() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(3, 4, 5, 6, 7, 8));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.FOURTH);
    }

    @DisplayName("3등에 당첨된 경우")
    @Test
    void checkPlaces_메소드_테스트6() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(2, 3, 4, 5, 6, 8));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.THIRD);
    }

    @DisplayName("2등에 당첨된 경우")
    @Test
    void checkPlaces_메소드_테스트7() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.SECOND);
    }

    @DisplayName("1등에 당첨된 경우")
    @Test
    void checkPlaces_메소드_테스트8() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        numberType[bonusNumber] = NumberType.BONUS;

        ArrayList<Integer> checkingNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(checkPlaces(checkingNumbers)).isEqualTo(Places.FIRST);
    }
}