package lotto.model;

import lotto.model.Answer.BonusLotto;
import lotto.model.Answer.Lotto;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RefereeTest {

    private Lotto lotto;
    private BonusLotto bonusLotto;
    private Referee referee;
    private List<Integer> strikeZero;
    private List<Integer> strikeThree;
    private List<Integer> strikeSix;

    @BeforeEach
    void setup () {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusLotto = new BonusLotto(7);
        referee = new Referee(lotto, bonusLotto);
        strikeZero = List.of(11, 12, 13, 14, 15, 16);
        strikeThree = List.of(11, 12, 13, 4, 5, 6);
        strikeSix = List.of(1, 2, 3, 4, 5, 6);
    }

    @AfterEach
    void afterEach () {
        lotto = null;
        bonusLotto = null;
        referee = null;
        strikeZero = null;
        strikeThree = null;
        strikeSix = null;
    }

    @DisplayName("모든 티켓의 당첨 점수 계산하기.")
    @Test
    void calculatePrizeCountOfAllTickets () {
        List<List<Integer>> userNumbers = new ArrayList<List<Integer>>();
        userNumbers.add(strikeZero);
        userNumbers.add(strikeThree);
        userNumbers.add(strikeThree);
        userNumbers.add(strikeSix);

        Map<Prize, Integer> result = new HashMap<>() {
            {
                put(Prize.THREE_STRIKE, 2);
                put(Prize.FOUR_STRIKE, 0);
                put(Prize.FIVE_STRIKE, 0);
                put(Prize.FIVE_STRIKE_WITH_BONUS, 0);
                put(Prize.SIX_STRIKE, 1);
            }
        };
        Assertions.assertEquals(referee.calculatePrizeOfAllTicket(userNumbers), result);
    }

    @DisplayName("현재 로또 티켓의 점수 계산하기.")
    @Test
    void countPrizeOfTicket() {
        Assertions.assertEquals(referee.judgePrizeOfEachTicket(strikeSix), 6.0);
        Assertions.assertEquals(referee.judgePrizeOfEachTicket(strikeZero), 0.0);
        Assertions.assertEquals(referee.judgePrizeOfEachTicket(strikeThree), 3.0);
    }

    @DisplayName("수익률 계산하기")
    @Test
    void calculateProfitRate() {
        List<List<Integer>> userNumbers = new ArrayList<>();
        userNumbers.add(strikeThree);

        referee.calculatePrizeOfAllTicket(userNumbers);

        int inputMoney = 8000;
        Assertions.assertEquals(referee.calculateProfitRate(inputMoney), 62.5);
    }

    @DisplayName("총수익 계산하기")
    @Test
    void calculateTotalProfit() {
        List<List<Integer>> userNumbers = new ArrayList<>();
        userNumbers.add(strikeThree);
        userNumbers.add(strikeSix);

        referee.calculatePrizeOfAllTicket(userNumbers);

        Assertions.assertEquals(referee.sumTotalProfit(), 2000005000);
    }
}