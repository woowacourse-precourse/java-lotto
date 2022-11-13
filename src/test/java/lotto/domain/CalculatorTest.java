package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void updateResult_whenFirstPrize() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 7;
        Calculator cal = new Calculator();
        cal.updateResult(lottoNumbers, winningNumbers, bonusNumber);
        assertThat(cal.firstWin).isEqualTo(1);
    }

    @Test
    void updateResult_whenSecondPrize() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,8);
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 8;
        Calculator cal = new Calculator();
        cal.updateResult(lottoNumbers, winningNumbers, bonusNumber);
        assertThat(cal.secondWin).isEqualTo(1);
    }

    @Test
    void updateResult_whenThirdPrize() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,41);
        int bonusNumber = 8;
        Calculator cal = new Calculator();
        cal.updateResult(lottoNumbers, winningNumbers, bonusNumber);
        assertThat(cal.thirdWin).isEqualTo(1);
    }

    @Test
    void updateResult_whenFourthPrize() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,40,41);
        int bonusNumber = 8;
        Calculator cal = new Calculator();
        cal.updateResult(lottoNumbers, winningNumbers, bonusNumber);
        assertThat(cal.fourthWin).isEqualTo(1);
    }

    @Test
    void updateResult_whenFifthPrize() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(1,2,3,39,40,41);
        int bonusNumber = 8;
        Calculator cal = new Calculator();
        cal.updateResult(lottoNumbers, winningNumbers, bonusNumber);
        assertThat(cal.fifthWin).isEqualTo(1);
    }

    @Test
    void updateResult_whenNoPrize() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(1,2,38,39,40,41);
        int bonusNumber = 8;
        Calculator cal = new Calculator();
        cal.updateResult(lottoNumbers, winningNumbers, bonusNumber);
        assertThat(cal.firstWin).isEqualTo(0);
        assertThat(cal.secondWin).isEqualTo(0);
        assertThat(cal.thirdWin).isEqualTo(0);
        assertThat(cal.fourthWin).isEqualTo(0);
        assertThat(cal.fifthWin).isEqualTo(0);
    }
}