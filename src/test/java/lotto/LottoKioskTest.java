package lotto;

import java.io.ByteArrayInputStream;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.machine.LottoKiosk;
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
        lottoKiosk.getMoney();
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
        lottoKiosk.getMoney();
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

        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        List<Integer> sixLottoNumbers = lottoKiosk.makeLottoNumbers();
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
        List<Integer> lottoNumbers = lottoKiosk.makeLottoNumbers();
        //then
        assertThat(lottoNumbers).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @DisplayName("[오류 테스트] 로또 숫자가 6개보다 적음")
    @Test
    void lessThanSixNumbersInLotto() {
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        List<Integer> numbers = List.of(1, 3, 4, 7, 9);
        //when
        //then
        assertThatThrownBy(() -> lottoKiosk.makeLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("[오류 테스트] 로또 숫자가 6개보다 많음")
    @Test
    void moreThanSixNumbersInLotto() {
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        List<Integer> numbers = List.of(1, 3, 4, 7, 9, 11, 13);
        //when
        //then
        assertThatThrownBy(() -> lottoKiosk.makeLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또에 6개의 숫자 존재")
    @Test
    void makeLotto() {
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        List<Integer> numbers = List.of(1, 3, 4, 7, 9, 11);
        Lotto lotto = lottoKiosk.makeLotto(numbers);
        //then
        assertThat(lotto.showNumbers().size()).isEqualTo(LOTTO_NUM_COUNT);
        assertThat(lotto.showNumbers()).allSatisfy(o -> assertThat(o).isBetween(LOTTO_START_NUM, LOTTO_END_NUM));
        assertThat(lotto.showNumbers()).containsExactly(1, 3, 4, 7, 9, 11);
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
        allLotto.forEach(lotto -> {
            List<Integer> numbers = lotto.showNumbers();
            assertThat(numbers.size()).isEqualTo(LOTTO_NUM_COUNT);
            assertThat(numbers).allSatisfy(num -> assertThat(num).isBetween(LOTTO_START_NUM, LOTTO_END_NUM));
        });
    }
}