package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    // 아래에 추가 테스트 작성 가능

    //예외 처리 테스트
    @DisplayName("예외 처리 에러가 IllegalArgumentException 인지 확인하는 테스트")
    @Test
    void exceptionsTest(){
        assertThatThrownBy(()->new Exceptions("IllegalArgumentException 가 뜬다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //구매 가격 입력 테스트
    @DisplayName("구매 가격에 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoString() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new BuyPrice("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 가격을 제대로 입력받으면 몇장의 로또를 살 수 있는지 확인하는 코드")
    @Test
    void checkTheCorrectPriceReturn(){
        BuyPrice buyPrice = new BuyPrice("3000");
        int buy__ = buyPrice.checkPrice();
        int expectedReturn = 3;
        assertThat(buy__).isEqualTo(expectedReturn);
    }


    // 로또 번호 생성 관련 테스트
    @DisplayName("로또 번호 세트는 티켓의 갯수만큼 생성되어야 한다")
    @Test
    void checkTheTicket(){
        TicketNumbers ticketNumbers = new TicketNumbers(3);
        ticketNumbers.collectTickets();
    }

    @DisplayName("정렬된 로또 번호 세트 넘겨주기")
    @Test
    void showTheAllTicket(){
        TicketNumbers ticketNumbers = new TicketNumbers(3);
        ticketNumbers.collectTickets();
    }


/**
    // 당첨 번호 입력 테스트
    @DisplayName("당첨번호는 숫자로만 이뤄져야한다")
    @Test
    void winningNumberMustbeNumber(){
        assertThatThrownBy(()-> new Lotto("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호의 길이는 6이어야 한다")
    @Test
    void winningnumbersizetest(){
        assertThatThrownBy(()-> new WinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(()-> new WinningNumber("1,2,3,4,5"))
//                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 번호가 존재하면 안된다")
    @Test
    void winningnumberDuplicateCheck(){
        assertThatThrownBy(()-> new WinningNumber("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //보너스 번호 테스트
    @DisplayName("보너스 번호는 로또 번호와 중복되면 안된다")
    @Test
    void testBonus(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        List<Integer> numbers = winningNumber.showWinningNumbers();
        assertThatThrownBy(()->new BonusNumber("1",numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 로또 번호는 알맞으면 반환을 합니다")
    @Test
    void testReturn(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        List<Integer> numbers = winningNumber.showWinningNumbers();
        BonusNumber bonusNumber = new BonusNumber("7", numbers);
        int bonum = bonusNumber.makeBonusNumber();
        System.out.println("numbers = " + numbers);
        System.out.println("bonum = " + bonum);
    }


 **/
    @DisplayName("제공된 Lotto 클래스의 정렬된 번호 넘겨주기")
    @Test
    void lottoTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> returnNumbers = lotto.returnNumbers();
        System.out.println("returnNumbers = " + returnNumbers);
    }

    @DisplayName("Lotto는 중복 번호가 없어야 한다")
    @Test
    void lottoDuplicatedTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(5);
        assertThatThrownBy(()->new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //로또 번호 맞는지 판단하는 기능
    @DisplayName("당첨번호와 로또번호 가져오기")
    @Test
    void CheckScoreTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);
        TicketNumbers ticketNumbers = new TicketNumbers(3);
        List<Integer> lottoNumbers = lotto.returnNumbers();
        List<List<Integer>> tickets = ticketNumbers.collectTickets();
        BonusNumber bonusNumber = new BonusNumber("30", lottoNumbers);
        int bbonusNumber = bonusNumber.makeBonusNumber();
        CheckScore checkScore = new CheckScore(lottoNumbers, tickets, bbonusNumber);
        List<Integer> score = checkScore.showScoreList();
        System.out.println("lottoNumbers = " + lottoNumbers);
        System.out.println("score = " + score);
    }


    @DisplayName("수익률 테스트")
    @Test
    void profitRateTest(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> lottoNumbers = lotto.returnNumbers();
        BuyPrice buyPrice = new BuyPrice("50000");
        int tickets = buyPrice.checkPrice();
        TicketNumbers ticketNumbers = new TicketNumbers(tickets);
        List<List<Integer>> allTickets = ticketNumbers.collectTickets();
        BonusNumber bonus = new BonusNumber("7",lottoNumbers);
        int bonusNumber = bonus.makeBonusNumber();
        List<List<Integer>> lucky = Arrays.asList(Arrays.asList(1,2,3,4,5,8));
        CheckScore checkScore = new CheckScore(lottoNumbers, lucky, bonusNumber);
        List<Integer> scoreList = checkScore.showScoreList();

        System.out.println("ALL TICKETS = " + allTickets);
        System.out.println("lottoNumbers = " + lottoNumbers);
        System.out.println("bonusNumber = " + bonusNumber);
        System.out.println("scoreList = " + scoreList);
        System.out.println("allTickets size = " + allTickets.size());
        System.out.println("scoreList.size() = " + scoreList.size());
        ProfitRate profitRate = new ProfitRate(50000, scoreList);
        System.out.println("profitRate.profit = " + profitRate.profit);
        System.out.println("bonus.bonus = " + bonus.bonus);

    }
}


