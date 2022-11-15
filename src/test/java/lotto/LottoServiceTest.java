package lotto;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.message.ErrorMessage;
import lotto.message.NumberType;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;

    void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    void init() {
        this.lottoService = new LottoService();
        this.lottoRepository = new LottoRepository();
    }

    @Test
    @DisplayName("로또 구매 횟수에 따라 로또 저장소에 해당 갯수 만큼 저장된다.")
    void pickAndSaveLottoTest() {
        lottoService.pickAndSaveLotto(5);
        List<Lotto> lottos = lottoRepository.findAll();
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("String이 콤마 단위로 구분되어 HashSet에 담긴다.")
    void changeStringToHashSetTest() {
        String winningNumberInput = "1,2,3,4,5,6";
        HashSet<Integer> winningNumber = lottoService.changeStringToHashSet(winningNumberInput);
        assertThat(winningNumber.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호를 입력받으면 LuckyNumber 객체에 정상적으로 담긴다.")
    void pickLuckyNumberTest() {
        //given
        provideInput("1,2,3,4,5,6\n7");
        //when
        LuckyNumber luckyNumber = lottoService.pickLuckyNumber();
        HashSet<Integer> winningNumbers = luckyNumber.getWinningNumbers();
        int bonusNumber = luckyNumber.getBonusNumber();
        //then
        assertThat(winningNumbers).containsExactly(1,2,3,4,5,6);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("당첨번호 및 보너스 번호와 로또가 일치하는 갯수가 정상적으로 반환된다.")
    void calculate_Winning_And_Bonus_Count_Test() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LuckyNumber luckyNumber = new LuckyNumber(new HashSet<>(List.of(1,2,3,4,5,45)), 6);
        //when
        int winningCount = lottoService.calculateWinningCount(lotto.getLottoNumbers(), luckyNumber);
        int bonusCount = lottoService.calculateBonusCount(lotto.getLottoNumbers(), luckyNumber);
        //then
        assertThat(winningCount).isEqualTo(5);
        assertThat(bonusCount).isEqualTo(1);
    }

    @Test
    @DisplayName("한개의 로또와 당첨번호를 비교하여 당첨 횟수 정보가 담긴 prizeResult가 정상적으로 반환된다.")
    void count_Prize_Result_For_Each_Lotto_Test() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LuckyNumber luckyNumber = new LuckyNumber(new HashSet<>(List.of(1, 2, 3, 4, 5, 6)), 7);
        int[] prizeResult = new int[5];
        //when
        lottoService.countPrizeResultForEachLotto(lotto, luckyNumber, prizeResult);
        //then
        assertThat(prizeResult[NumberType.FIRST_PRIZE.getNumberType()]).isEqualTo(1);
    }

    @Test
    @DisplayName("여러개의 로또와 당첨번호를 비교하여 당첨 횟수 정보가 담긴 prizeResult가 정상적으로 반환된다.")
    void get_Prize_Result_Test() {
        //given
        lottoRepository.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottoRepository.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottoRepository.add(new Lotto(List.of(1,2,3,4,8,9)));
        LuckyNumber luckyNumber = new LuckyNumber(new HashSet<>(List.of(1,2,3,4,5,6)),7);
        //when
        int[] prizeResult = lottoService.getPrizeResult(luckyNumber);
        //then
        assertThat(prizeResult[NumberType.FIFTH_PRIZE.getNumberType()]).isEqualTo(0);
        assertThat(prizeResult[NumberType.FOURTH_PRIZE.getNumberType()]).isEqualTo(1);
        assertThat(prizeResult[NumberType.THIRD_PRIZE.getNumberType()]).isEqualTo(0);
        assertThat(prizeResult[NumberType.SECOND_PRIZE.getNumberType()]).isEqualTo(1);
        assertThat(prizeResult[NumberType.FIRST_PRIZE.getNumberType()]).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 횟수 정보를 바탕으로 총 당첨 상금이 정상적으로 반환된다.")
    void calculate_Total_Prize_Test() {
        //given
        int[] prizeResult = {1,2,1,2,1};
        BigDecimal expectedPrize = new BigDecimal(2_061_605);
        //when
        BigDecimal totalPrize = lottoService.calculateTotalPrize(prizeResult);
        int result = totalPrize.compareTo(expectedPrize);
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력한 돈과 당첨 횟수 결과를 바탕으로 수익률이 정상적으로 반환된다.")
    void calculate_Profit_Rate_Test() {
        //given
        int money = 50000;
        int[] prizeResult = {0,0,0,0,3};
        BigDecimal expectedProfitRate = new BigDecimal(12_000_000);
        //when
        BigDecimal profitRate = lottoService.calculateProfitRate(money, prizeResult);
        int result = profitRate.compareTo(expectedProfitRate);
        //then
        assertThat(result).isEqualTo(0);
    }
}
