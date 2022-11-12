package lotto;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoKioskTest {
    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("[오류 테스트] 입력에 숫자가 아닌 것이 존재")
    @Test
    void inputNotNum() {
        //입력값 정의
        String input = "10c000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.moneyInserted();
        //when then
        assertThatThrownBy(lottoKiosk::validateMoneyInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("[오류 테스트] 돈이 1000으로 나누어지지 않음")
    @Test
    void chargedMoneyNotDivideBy1000() {
        //입력값 정의
        String input = "1000023";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.moneyInserted();
        lottoKiosk.chargeMoney();
        //when then
        assertThatThrownBy(lottoKiosk::validateMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("문자열로 올바른 입력값 Long 으로 저장")
    @Test
    void chargeMoney() {
        //입력값 정의
        String input = "100000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.moneyInserted();
        //when
        lottoKiosk.chargeMoney();
        //then
        long moneyExpected = Long.parseLong(input);
        assertThat(lottoKiosk.showInsertedMoney()).isEqualTo(moneyExpected);
    }

    @DisplayName("올바른 입력시 금액 조회")
    @Test
    void showInsertedMoney() {
        //입력값 정의
        String input = "210000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.insertMoney();
        //when
        long chargedMoney = lottoKiosk.showInsertedMoney();
        //then
        long moneyExpected = Long.parseLong(input);
        assertThat(chargedMoney).isEqualTo(moneyExpected);
    }

    @DisplayName("몇개의 로또를 파는지 계산")
    @Test
    void calculateLottoAmount() {
        //입력값 정의
        final int LOTTO_PRICE = 1000;
        String input = "20000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.insertMoney();
        //when
        lottoKiosk.calculateLottoAmount();
        //then
        long howManyLotto = lottoKiosk.showInsertedMoney() / LOTTO_PRICE;
        assertThat(lottoKiosk.showHowMany()).isEqualTo(howManyLotto);
    }

    @DisplayName("로또 숫가 6개 만들기")
    @Test
    void makeUniqueSixLottoNumbers() {
        //given
        final int LOTTO_START_NUM = 1;
        final int LOTTO_END_NUM = 45;
        final int LOTTO_NUM_COUNT = 6;
        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        List<Integer> sixLottoNumbers = lottoKiosk.makeUniqueSixLottoNumbers();
        //then
        assertThat(sixLottoNumbers).allSatisfy(o -> assertThat(o).isBetween(LOTTO_START_NUM, LOTTO_END_NUM));
        assertThat(sixLottoNumbers.size()).isEqualTo(LOTTO_NUM_COUNT);
        Set<Integer> numbersNotDuplicate = new HashSet<>(sixLottoNumbers);
        assertThat(numbersNotDuplicate.size()).isEqualTo(LOTTO_NUM_COUNT);
    }

    @DisplayName("오름차순으로 정렬된 로또 숫가 6개 만들기")
    @Test
    void sortUniqueSixLottoNumbers() {
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        List<Integer> sixLottoNumbers = lottoKiosk.makeUniqueSixLottoNumbers();
        List<Integer> sortedLottoNumbers = lottoKiosk.sortUniqueSixLottoNumbers(sixLottoNumbers);
        //then
        assertThat(sortedLottoNumbers).isSortedAccordingTo(Comparator.naturalOrder());
    }
}