package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String myMoney = Console.readLine();
        MyMoney money = new MyMoney(myMoney);
        System.out.println();
        return money.getAmount();
    }

    static List<Integer> pickLottoNum() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    static List<Lotto> buyLotto(int count) {
        List<Lotto> myLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto pickLotto = new Lotto(pickLottoNum());
            myLotto.add(pickLotto);
        }
        return myLotto;
    }

    static void printMyLotto(List<Lotto> myLotto) {
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : myLotto) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    static WinningLotto inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        WinningLotto winningNumbers = new WinningLotto(input);
        System.out.println();
        return winningNumbers;
    }

    static void inputBonusNumber(WinningLotto winningLotto){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        winningLotto.inputBonusNumber(input);
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchase = inputMoney() / 1000;
        List<Lotto> myLottos = buyLotto(purchase);
        printMyLotto(myLottos);
        WinningLotto winningLotto = inputWinNumber();
        inputBonusNumber(winningLotto);
        MyResult myResult = new MyResult(myLottos, winningLotto);
    }
}

