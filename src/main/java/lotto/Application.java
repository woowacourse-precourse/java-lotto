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
        List<List<Integer>> allTicket = playLotto.allTicket(user.countTicket());

        /*당첨통계*/
        List<Integer> correctNumber = playLotto.allTicketCheckCorrectNumber(allTicket, inputNumber.inputWinningNumber(), inputNumber.inputBonusNumber());
        playLotto.printRanking(correctNumber);

        playLotto.yield(money, correctNumber);
    }
}
