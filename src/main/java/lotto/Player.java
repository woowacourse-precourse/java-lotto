package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private Set<Lotto> playerLotto;

    public Set<Lotto> buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        int numberOfLotto = calculate(money);
        playerLotto = new HashSet<>();
        for(int i=0; i< numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            playerLotto.add(new Lotto(numbers));
        }
        buyResult(numberOfLotto);
        return playerLotto;
    }

    public int calculate(String money) throws IllegalArgumentException {
        int cost = changeToNumber(money);
        int numberOfLotto = cost/1000;
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return numberOfLotto;
    }

    public static int changeToNumber(String input) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return number;
    }

    public void buyResult(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for(Lotto lotto : playerLotto) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }

    public List<Integer> pickNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : numbers) {
            int eachNumber = changeToNumber(number);
            if(!winningNumbers.contains(eachNumber)) {
                winningNumbers.add(eachNumber);
            }
        }
        new Lotto(winningNumbers);
        return winningNumbers;
    }

    public int pickBonus(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = changeToNumber(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for (int number : winningNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 숫자를 입력해야 합니다.");
            }
        }
        return bonusNumber;
    }

}
