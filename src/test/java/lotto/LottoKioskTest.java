package lotto;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.machine.LottoKiosk;
import lotto.message.ErrorMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoKioskTest {
    private final String ERROR_MESSAGE = "[ERROR]";
    private final int LOTTO_START_NUM = 1;
    private final int LOTTO_END_NUM = 45;
    private final int LOTTO_NUM_COUNT = 6;

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
                .hasMessage(ErrorMessage.MONEY_NOT_A_NUMBER.message)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("[오류 테스트] 돈이 1000보다 작음")
    @Test
    void chargedMoneylessThan1000() {
        //입력값 정의
        String input = "0";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.moneyInserted();
        lottoKiosk.chargeMoney();
        //when then
        assertThatThrownBy(lottoKiosk::validateMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LESS_THAN_THOUSAND.message)
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
                .hasMessage(ErrorMessage.DIVIDE_DISABLE.message)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("올바른 입력값 저장")
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

    @DisplayName("입력 금액 조회")
    @Test
    void showInsertedMoney() {
        //입력값 정의
        String input = "210000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.getMoney();
        //when
        long chargedMoney = lottoKiosk.showInsertedMoney();
        //then
        long moneyExpected = Long.parseLong(input);
        assertThat(chargedMoney).isEqualTo(moneyExpected);
    }

    @DisplayName("판매할 로또 수 계산")
    @Test
    void calculateLottoAmount() {
        //입력값 정의
        final int LOTTO_PRICE = 1000;
        String input = "20000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.getMoney();
        //when
        lottoKiosk.calculateLottoAmount();
        //then
        long howManyLotto = lottoKiosk.showInsertedMoney() / LOTTO_PRICE;
        assertThat(lottoKiosk.showHowMany()).isEqualTo(howManyLotto);
    }

    @DisplayName("로또 번호 생성")
    @Test
    void makeUniqueSixLottoNumbers() {
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        List<Integer> lottoNumbers = lottoKiosk.makeLottoNumbers();
        //then
        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_NUM_COUNT);
        assertThat(lottoNumbers).allSatisfy(o -> assertThat(o).isBetween(LOTTO_START_NUM, LOTTO_END_NUM));
        assertThat(lottoNumbers).isSortedAccordingTo(Comparator.naturalOrder());
        Set<Integer> numbersNotDuplicate = new HashSet<>(lottoNumbers);
        assertThat(numbersNotDuplicate.size()).isEqualTo(LOTTO_NUM_COUNT);
    }

    @DisplayName("투입한 금액만큼의 로또가 생성")
    @Test
    void makeAllLotto() {
        //입력값 정의
        String input = "10000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        lottoKiosk.getMoney();
        lottoKiosk.calculateLottoAmount();
        lottoKiosk.makeAllLotto();
        //then
        List<Lotto> allLotto = lottoKiosk.showAllLotto();
        assertThat(allLotto.size()).isEqualTo(lottoKiosk.showHowMany());
    }
}