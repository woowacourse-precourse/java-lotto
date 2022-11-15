package lotto.domain;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoService = new LottoService();
    }

    @ParameterizedTest
    @DisplayName("구매 로또 정보와 당첨 로또 정보를 통해 당첨 순위 확인하는 통합 테스트")
    @CsvSource(value = {"1,2,3,4,5,7,6,2", "1,2,3,4,5,6,7,1", "1,2,3,4,5,8,9,3", "1,2,3,4,8,9,10,4", "1,2,3,9,10,11,12,5"})
    void checkLottoNumbersTest(int number1, int number2, int number3, int number4, int number5, int number6, int bonusNumber, int expectedNumber) {

        Lotto buyingLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLottoNumber = new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
        WinningRank expectedRank;

        WinningRank winningRank = lottoService.checkLottoNumbers(buyingLotto, winningLotto);

        if (expectedNumber == 1) {
            expectedRank = WinningRank.FIRST;
        } else if (expectedNumber == 2) {
            expectedRank = WinningRank.SECOND;
        } else if (expectedNumber == 3) {
            expectedRank = WinningRank.THIRD;
        } else if (expectedNumber == 4) {
            expectedRank = WinningRank.FOURTH;
        } else if (expectedNumber == 5) {
            expectedRank = WinningRank.FIFTH;
        } else {
            expectedRank = WinningRank.NOTHING;
        }

        assertThat(winningRank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @DisplayName("당첨 순위 결과가 제대로 확인되는지 검사하는 단위 테스트")
    @CsvSource(value = {"6, true, 1", "5, true, 2" ,"5, false, 3", "4, true, 4","3, true, 5" })
    void checkWinningRank(int matchCount, boolean isBonusMatch, int expectedNumber) {

        WinningRank result = lottoService.checkWinningRank(matchCount, isBonusMatch);

        WinningRank expectedRank;

        if (expectedNumber == 1) {
            expectedRank = WinningRank.FIRST;
        } else if (expectedNumber == 2) {
            expectedRank = WinningRank.SECOND;
        } else if (expectedNumber == 3) {
            expectedRank = WinningRank.THIRD;
        } else if (expectedNumber == 4) {
            expectedRank = WinningRank.FOURTH;
        } else if (expectedNumber == 5) {
            expectedRank = WinningRank.FIFTH;
        } else {
            expectedRank = WinningRank.NOTHING;
        }

        assertThat(result).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 같은것이 있으면 true 리턴하는지 확인하는 단위 테스트")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,true", "5, true", "6, true", "7, false"})
    void checkBonusNumberTest(int bonusNumber, boolean expected) {

        Lotto buyingLotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean result = lottoService.checkBonusNumber(buyingLotto, bonusNumber);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 같은것이 있으면 true 리턴하는지 확인하는 단위 테스트")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,true", "5, true", "6, true", "7, false"})
    void checkLottoNumberTest(int winningLottoNumbers, boolean expected) {

        Lotto buyingLotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean result = lottoService.checkLottoNumber(buyingLotto, winningLottoNumbers);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 리스트 형식으로 생성이 되는지 단위 테스트")
    void generateLottoList() {

        int numberOfLotto = 5;
        List<Lotto> result = lottoService.generateLottoList(numberOfLotto);

        assertThat(result.size()).isEqualTo(numberOfLotto);
    }

    @Test
    @DisplayName("lotto 클래스로 생성이 되는지 단위 테스트")
    void generateLottoTest() {

        Lotto result = lottoService.generateLotto();

        assertThat(result).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("1~45 사이 6자리 랜덤값을 오름차순으로 정렬하는지 통합 테스트")
    void generateLottoNumbersTest() {

        List<Integer> result = lottoService.generateLottoNumbers();
        List<Integer> expected = lottoService.cloneList(result);
        Collections.sort(expected);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("깊은 복제 기능 테스트")
    void cloneListTest() {

        List<Integer> givenList = List.of(1,2,3,4,5,6);

        List<Integer> cloneList = lottoService.cloneList(givenList);

        assertThat(cloneList).isEqualTo(givenList);
    }

    @Test
    @DisplayName("발생한 로또 오름차순 정렬 테스트")
    void sortedLottoNumbersTest() {

        List<Integer> lottoNumbers = Arrays.asList(21, 34, 5, 22, 47, 43);

        lottoService.sortedLottoNumbers(lottoNumbers);

        assertThat(lottoNumbers).isEqualTo(Arrays.asList(5, 21, 22, 34, 43, 47));
    }

    @Test
    void 발행한_로또_유효성_검사_테스트() {
        final int testNumber = 100;

        for (int i = 0; i < testNumber; i++) {
            List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
            for (int j = 0; j < 6; j++) {
                if (lottoNumbers.get(j) < 1 || lottoNumbers.get(j) > 45) {
                    fail();
                }
            }
        }
    }

    @Test
    void 발행한_로또_번호_길이_테스트() {
        final int testNumber = 100;

        for (int i = 0; i < testNumber; i++) {
            List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
            assertThat(lottoNumbers.size()).isEqualTo(6);
        }
    }
}