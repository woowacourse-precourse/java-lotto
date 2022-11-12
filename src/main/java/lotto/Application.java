package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.LottoMachine;


public class Application {
    public static void main(String[] args) {
        LottoMachine.pickLottoNumbers(inputCash());
    }
    public static int inputCash(){
        int countLotto;
        System.out.println("구입금액을 입력해 주세요.");
        countLotto = Cash.countPurchaseQuantity(Console.readLine());
        System.out.println(countLotto+"개를 구매했습니다.");
        return countLotto;
    }

}
