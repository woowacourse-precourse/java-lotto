package lotto;

import lotto.handler.InputBonusNumberHandler;
import lotto.handler.InputWinningNumbersHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLottoNumbers {
    InputWinningNumbersHandler inputWinningNumbersHandler = new InputWinningNumbersHandler();
    InputBonusNumberHandler inputBonusNumberHandler = new InputBonusNumberHandler();

    @DisplayName("당첨 로또 번호의 입력이 아무것도 없는지 확인하는 Test")
    @Test
    void checkWinningNumbersExist() {
        String test = "";
        assertThatThrownBy(() -> {
            inputWinningNumbersHandler.checkExist(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 입력의 크기가 6이 아니면 예외발생 Test")
    @Test
    void checkWinningNumberSize() {
        assertThatThrownBy(() -> {
            List<Integer> testList = List.of(1,2,3,4,5,6,7);
            inputWinningNumbersHandler.checkSize(testList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 입력의 크기가 6인지 확인하는 Test")
    @Test
    void checkSize() {
        assertThatThrownBy(() -> {
            List<Integer> testList = new ArrayList<>();
            inputWinningNumbersHandler.checkSize(testList);
            for(int i =0; i<5; i++){
                testList.add(i);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 입력의 크기가 6인지 확인하는 Test")
    @Test
    void checkSameNumbers() {
        assertThatThrownBy(() -> {
            List<Integer> testList = List.of(1,2,3,3,4,5);
            inputWinningNumbersHandler.checkSameNumbers(testList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 입력 범위가 1에서 45 사이인지 Test")
    @Test
    void checkInRange() {
        assertThatThrownBy(() -> {
            int index = 0;
            List<Integer> winningNumber = List.of(49,2,3,4,5,6);
            inputWinningNumbersHandler.checkInRangeNumber(index,winningNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 입력이 숫자인지 Test")
    @Test
    void checkIsNumber() {
        assertThatThrownBy(() -> {
            String test = "123a45";
            String[] testData = test.split("");
            inputWinningNumbersHandler.checkIsNumber(testData);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 당첨 번호가 로또 번호를 포함하는지 확인하는 Test")
    @Test
    void checkAllNumbers() {
        assertThatThrownBy(() -> {
            String bonus = "1";
            List<Integer> testData = List.of(1,2,3,4,5,6);
            inputBonusNumberHandler.checkAllNumbersException(bonus, testData);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}