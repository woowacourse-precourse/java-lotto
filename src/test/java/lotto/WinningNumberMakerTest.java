package lotto;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningNumberMakerTest {
    @DisplayName("\",\"로 입력값 나누기")
    @Test
    void divideByComma() {
        //입력값 세팅
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
        ByteArrayInputStream byteInput = new ByteArrayInputStream(String.join(",", numbers).getBytes());
        System.setIn(byteInput);
        //given
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        winningNumberMaker.getWinningNumberInput();
        //when
        winningNumberMaker.divideByComma();
        String[] inputSplitByComma = winningNumberMaker.showInputSplitByComma();
        //then
        assertThat(inputSplitByComma.length).isEqualTo(6);
        assertThat(inputSplitByComma).containsExactlyElementsOf(numbers);
    }

    @DisplayName("[오류 테스트] 입력 당첨번호가 숫자가 아님")
    @Test
    void winningNumberNotNum() {
        //given
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        String winningNumberStr = "a";
        //when
        //then
        assertThatThrownBy(() -> {
            winningNumberMaker.validateWinningNumberStr(winningNumberStr);
        }).hasMessage(ErrorMessage.WINNING_NUM_NOT_A_NUMBER.message);
    }

    @DisplayName("[오류 테스트] 입력 당첨번호가 범위를 넘어감")
    @Test
    void winningNumberOutOfRange() {
        //given
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        String winningNumberStr = "46";
        //when //then
        assertThatThrownBy(() -> {
            winningNumberMaker.validateWinningNumberStr(winningNumberStr);
        }).hasMessage(ErrorMessage.NUMBER_OUT_OF_RANGE.message);
    }

    @DisplayName("[오류 테스트] 당첨번호가 6개가 아님")
    @Test
    void validateInputSplitByComma() {
        //입력값 세팅
        String[] numbers = {"1", "4", "7", "20", "34"};
        ByteArrayInputStream byteInput = new ByteArrayInputStream(String.join(",", numbers).getBytes());
        System.setIn(byteInput);
        //given
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        winningNumberMaker.getWinningNumberInput();
        winningNumberMaker.divideByComma();
        //when
        //then
        assertThatThrownBy(() -> {
            winningNumberMaker.validateInputSplitByComma();
        }).hasMessage(ErrorMessage.NOT_ENOUGH_NUM.message);
    }

    @DisplayName("입력값으로 당첨번호 6개 저장")
    @Test
    void make() {
        //입력값 세팅
        String[] numbers = {"1", "4", "7", "8", "20", "34"};
        ByteArrayInputStream byteInput = new ByteArrayInputStream(String.join(",", numbers).getBytes());
        System.setIn(byteInput);
        //given
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        //when
        winningNumberMaker.make();
        List<Integer> winningNumbers = winningNumberMaker.showWinningNumbers();
        //then
        List<Integer> expected = List.of(1, 4, 7, 8, 20, 34);
        assertThat(winningNumbers.size()).isEqualTo(6);
        assertThat(winningNumbers).containsExactlyElementsOf(expected);
    }
}