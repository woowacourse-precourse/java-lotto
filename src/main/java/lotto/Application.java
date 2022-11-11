package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

enum PrintResult {
    FIFTH("3개 일치 (5,000원) - ", 5000),
    FOURTH("4개 일치 (50,000원) - ", 50000),
    THIRD("5개 일치 (1,500,000원) - ", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String name;
    private final long value;

    PrintResult(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public long getValue() {
        return this.value;
    }
}

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

    static void inputBonusNumber(WinningLotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        winningLotto.inputBonusNumber(input);
        System.out.println();
    }

    static void printMyLottoResult(MyResult myResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (PrintResult rank : PrintResult.values()) {
            System.out.print(rank.getName());
            System.out.println(myResult.getWinningResult().get(rank.ordinal()) + "개");
        }
//        for(int rank = 3; rank < 8; rank++){
//            System.out.println(rank+"개 일치 - "+ myResult.getWinningResult().get(rank-3)+"개");
//        }
    }

    static void printYield(MyResult myResult, int purchase) {
        double yield = 0;
        for (PrintResult rank : PrintResult.values()) {
            yield += (myResult.getWinningResult().get(rank.ordinal()) * rank.getValue());
        }
        yield /= purchase;
        yield *= 100;
        System.out.println("총 수익률은 " + yield + "% 입니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchase = inputMoney() / 1000;
        List<Lotto> myLottos = buyLotto(purchase);
        printMyLotto(myLottos);
        WinningLotto winningLotto = inputWinNumber();
        inputBonusNumber(winningLotto);
        MyResult myResult = new MyResult(myLottos, winningLotto);
        printMyLottoResult(myResult);
        printYield(myResult, purchase * 1000);
    }
}

