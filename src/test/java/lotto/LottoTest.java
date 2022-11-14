package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoVandingMachine lottoVM = new LottoVandingMachine();
    LottoCalculator lottoCal = new LottoCalculator();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매시 문자가 들어올 경우 예외가 발생한다.")
    @Test
    void createInputMoneyByString(){
        String errMsg = "[ERROR] 돈은 숫자로만 입력해야 합니다.";
        String input = "1000won";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        lottoVM.inputMoney();
        String output = out.toString();
        System.out.println("output"+output);
        Assertions.assertThat(errMsg).isEqualTo(output);
    }

    @DisplayName("로또 추첨시 반환 값이 7자리가 맞는지")
    @Test
    void createDrawLottoSize(){


        String input = "1,2,3,4,5,6";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        lottoVM.drawLotto();
//        assertThat(randomNum.length()).isEqualTo(3);
    }

    @DisplayName("로또 일치가 3개라고 가정했을 때, 결과가 3이 나오는지")
    @Test
    void createCorrect3Lotto(){
        Integer[] issuedArr = new Integer[]{1,2,3,4,5,6};
        List<Integer> issuedLotto = Arrays.asList(issuedArr);
        Integer[] answerArr = new Integer[]{1,3,5,7,8,9,11};
        List<Integer> lottoAnswer = Arrays.asList(answerArr);

        int count = lottoCal.compareLotto(issuedLotto, lottoAnswer);
        assertThat(count).isEqualTo(3);
    }



}
