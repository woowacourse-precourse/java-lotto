package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputNumber inputNumber = new InputNumber();
        PlayLotto playLotto = new PlayLotto();
        Integer money = inputNumber.Money(inputNumber.inputMoney());

        /*8개를 구매했습니다.*/
        User user = new User(money);
        user.textTicketcount();
        List<List<Integer>> allTicket = playLotto.allTicket(money);

        /*당첨번호입력*/
        createLotto.textWinningNumber();
        createLotto.winningNumber(createLotto.inputWinningNumber());

        /*보너스 번호 입력*/
        createLotto.textBounsNumber();
        createLotto.bonusNumber(createLotto.inputBonusNumber());

        /*당첨통계*/
        List<Integer> correctNumber = playLotto.allTicketCheckCorrectNumber(allTicket, createLotto.inputWinningNumber(), createLotto.inputBonusNumber());
        playLotto.print5th(correctNumber);
        playLotto.print4th(correctNumber);
        playLotto.print3rd(correctNumber);
        playLotto.print2nd(correctNumber);
        playLotto.print1st(correctNumber);

        double yield = playLotto.yield(money, correctNumber);
        playLotto.printYield(yield);
    }
}
