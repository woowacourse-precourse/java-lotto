package lotto;

import java.util.List;

public class Application { // 패키지 분리
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Message.requestInputMoneyMessage();
        int i = Money.countLotto(UserNumberScan.requestValue());
        List<Lotto> lottos = RandomNumberCreater.generateLottoNumber(i);


        Message.requestBonusNumberMessage();
        WinningNumber winningNumber = new WinningNumber(UserNumberScan.requestValue());
        List<Integer> numbers = winningNumber.getNumber();
        int count = 0;
        for (Integer integer : numbers) {
            Lotto lotto = lottos.get(0);
            List<Integer> number1 = lotto.getNumbers();
            if (number1.contains(integer)) {

            }
        }
    }
}
