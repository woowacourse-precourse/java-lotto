package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCount = inputMoney();
        User user = new User(lottoCount);
        Lotto winningNumber = new Lotto(inputWinningNumber());
        int bonus = inputBonusNumber(winningNumber);
    }
    // 돈을 입력받아서 로또 개수를 반환
    public static int inputMoney() {
        int count;
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        // 예외 숫자가 아닐때
        // 1000원으로 나누어 떨어지지 않을 때


        int moneyCheck = Integer.parseInt(money);
        count = moneyCheck / 1000;
        System.out.println(count + "개를 구매했습니다.");
        return count;


    }
    public static List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // 정렬 오름차ㅣ
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(numbers);
        return numbers;
    }
    public static List<Integer> inputWinningNumber() {
        List<Integer> winningNumbers;

        //로또 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        // 예외처리
        Exeption.inputWinningNumberExeption(input, true);
        winningNumbers = Exeption.stringToList(input);
        // 로또 번호 반환
        return winningNumbers;

    }
    //보너스 숫자 입력
    public static int inputBonusNumber(Lotto lotto) {
        // 보너스 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        Exeption.inputWinningNumberExeption(bonus, false);
        Exeption.isNotoverlapped(lotto, Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }



}
