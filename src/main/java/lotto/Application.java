package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final ExceptionHandler exceptionHandler = new ExceptionHandler();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startLotto();
    }

    private static void startLotto() {

        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        System.out.println(amount);
        System.out.println();

        int lottoQuantity = Lotto.numberOfLottosQuantity(amount);
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        List<List<Integer>> randomNumbers = RandomLotto.creatRandomNumber(lottoQuantity);
        System.out.println();

        System.out.println("당첨 번호 6개를 입력해주세요. 각 숫자는 ,로 구분됩니다. 띄어쓰기 없이 작성해주세요.");
        System.out.println("ex) 1,2,3,4,5,6");
        String number = Console.readLine();
        System.out.println(number);
        List<String> numbers = new ArrayList<>(List.of(number.split(",")));
        List<Integer> userNum = new ArrayList<>();
        for (String num : numbers) {
            if (Integer.parseInt(num) < 46 && Integer.parseInt(num) > 0) {
                userNum.add(Integer.parseInt(num));
            }
        }
        new Lotto(userNum);
        System.out.println();

        System.out.println("보너스 번호를 입력해주세요. 보너스 번호는 1자리입니다.");
        int bonusNum = Integer.parseInt(Console.readLine());
        new BonusNumber(userNum, bonusNum);
        userNum.add(bonusNum);
        System.out.println(bonusNum);
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        WinningLotto winningLotto = new WinningLotto(userNum, randomNumbers);
        int totalYield = winningLotto.getTotalYield();
        new Yield(totalYield, Integer.parseInt(amount));
    }
}
