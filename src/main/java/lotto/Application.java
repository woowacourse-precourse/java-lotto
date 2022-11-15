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



}
