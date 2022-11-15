package lotto.service;

import static lotto.domain.Prize.FIVE;
import static lotto.domain.Prize.FIVE_AND_BONUS;
import static lotto.domain.Prize.FOUR;
import static lotto.domain.Prize.SIX;
import static lotto.domain.Prize.THREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoInput;
import lotto.domain.LottoRepository;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.view.LottoDto;
import lotto.view.PrizeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;

    @BeforeEach
    void init() {
        lottoRepository = new LottoRepository();
        lottoService = new LottoService(lottoRepository);
    }

    @Test
    @DisplayName("Money 10000 을 받으면 로또 10개가 생성되고 repo 에 저장이 되고 랜덤으로 생성된 정수리스트 10개가 반환")
    public void 로또생성_테스트() {
        //given
        //when
        LottoDto lottos = lottoService.createLottos(Money.of(10000L));
        //then
        assertThat(lottos.getLotteries().size()).isEqualTo(10);
    }

    @DisplayName("randomNumbers 을 인자로 받아 생성된 로또 1개의 당첨결과를 테스트 한다.")
    @ParameterizedTest(name = "{index} => {0} 으로 생성된 로또는 {1} 가 당첨결과로 나와야하고 갯수는 {2}개 이다 ")
    @MethodSource("provideRandomNumbersForCalcPrize")
    public void 로또1개_당첨결과_테스트(List<Integer> randomNumbers, Prize prize, long expected) {
        //given
        List<Integer> winningNumbers = List.of(1, 5, 15, 21, 40, 41);
        int bonus = 13;
        lottoRepository.save(new Lotto(randomNumbers));
        LottoInput lottoInput = LottoInput.create(winningNumbers, bonus, Money.of(1000L));
        //when
        PrizeDto prizeDto = lottoService.calcWinningResult(lottoInput);

        //then
        Map<Prize, Long> prizeLongMap = prizeDto.groupByPrizes();
        assertThat(prizeLongMap.get(prize)).isEqualTo(expected);

    }

    @DisplayName("winningNumbers 와 bonusNumber 를 인자로 받아 이미 생성된 로또 5개의 당첨결과를 테스트 한다.")
    @ParameterizedTest(name = "{index} => {0}, {1} 으로 생성된 로또 번호의 당첨번호에 해당하는 결과는 {2} 이다 ")
    @MethodSource("provideWinningAndBonusNumberForCalcPrize")
    public void 로또_5개_당첨결과_테스트(List<Integer> winningNumbers, int bonusNumber, Map<Prize, Long> expected) {
        //given
        Money money = Money.of(5000L);
        LottoInput lottoInput = LottoInput.create(winningNumbers, bonusNumber, money);

        ArrayList<List<Integer>> buyLottos = new ArrayList<>();

        buyLottos.add(List.of(1, 2, 3, 4, 5, 6));
        buyLottos.add(List.of(1, 2, 3, 10, 20, 30));
        buyLottos.add(List.of(2, 3, 4, 40, 41, 42));
        buyLottos.add(List.of(2, 3, 4, 40, 41, 20));
        buyLottos.add(List.of(5, 6, 7, 40, 41, 43));

        for (List<Integer> buyLotto : buyLottos) {
            lottoRepository.save(new Lotto(buyLotto));
        }

        //when
        PrizeDto prizeDto = lottoService.calcWinningResult(lottoInput);
        Map<Prize, Long> actual = prizeDto.groupByPrizes();
        //then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRandomNumbersForCalcPrize() { // argument source method
        return Stream.of(
                Arguments.of(List.of(1, 5, 15, 18, 20, 39), THREE, 1L),
                Arguments.of(List.of(1, 5, 15, 18, 21, 39), FOUR, 1L),
                Arguments.of(List.of(1, 5, 15, 18, 21, 40), FIVE, 1L),
                Arguments.of(List.of(1, 5, 15, 13, 21, 40), FIVE_AND_BONUS, 1L),
                Arguments.of(List.of(1, 5, 15, 21, 40, 41), SIX, 1L)
        );
    }

    private static Stream<Arguments> provideWinningAndBonusNumberForCalcPrize() { // argument source method
        //당첨번호, 보너스번호, 당첨결과
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 11, 12, 13), 40, Map.of(THREE, 2L)),
                Arguments.of(List.of(1, 2, 3, 10, 35, 36), 37, Map.of(THREE, 1L, FOUR, 1L)),
                Arguments.of(List.of(2, 3, 4, 40, 41, 45), 30, Map.of(FIVE, 2L, THREE, 1L)),
                Arguments.of(List.of(2, 3, 4, 5, 40, 41), 20,
                        Map.of(THREE, 1L, FOUR, 1L, FIVE, 1L, FIVE_AND_BONUS, 1L)),
                Arguments.of(List.of(5, 6, 7, 40, 41, 43), 45, Map.of(SIX, 1L))
        );
    }

}