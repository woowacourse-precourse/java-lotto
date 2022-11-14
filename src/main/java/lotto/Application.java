package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {
    static final int lottoPrice = 1000;
    static final int startNumber = 1;
    static final int endNumber = 45;

    public static Integer getMoney() {
        int money = readMoney();
        validMoney(money);
        return money;
    }

    public static Integer readMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해주세요.");
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR]: 입력값이 숫자가 아닙니다.");
        }
    }

    public static void validMoney(int money) throws IllegalArgumentException {
        if (money < lottoPrice) {
            throw new IllegalArgumentException("[ERROR]: 구입금액으로 로또를 구매할 수 없습니다.");
        }
        if (money % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR]: 구입금액이 로또금액으로 나누어 떨어지지 않습니다.");
        }
    }

    public static Integer getNumberOfLotto(int money) {
        int numOfLotto = money / lottoPrice;
        printNumberOfLotto(numOfLotto);
        return numOfLotto;
    }

    public static void printNumberOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    public static List<Lotto> getLottos(int numOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> lottoNums;

        for (int i = 0; i < numOfLotto; i++) {
            lottoNums = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, 6);
            Collections.sort(lottoNums);
            Lotto newLotto = new Lotto(lottoNums);
            newLotto.printNumbers();
            lottos.add(newLotto);
        }

        return lottos;
    }

    public static Lotto getLuckyNumbers() {
        List<Integer> inputNums = readLuckyNumbers();
        validLuckyNumbers(inputNums);
        checkRange(inputNums);
        Lotto luckyNums = new Lotto(inputNums);
        return luckyNums;
    }

    public static List<Integer> readLuckyNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        String[] inputs = userInput.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String input : inputs) {
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR]: 입력값이 숫자가 아닙니다.");
            }
        }

        Collections.sort(numbers);

        return numbers;
    }

    public static void validLuckyNumbers(List<Integer> inputNums) throws IllegalArgumentException {
        if(inputNums.size() != inputNums.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR]: 당첨번호에 중복된 숫자가 있습니다.");
        }
    }

    public static void checkRange(List<Integer> inputNums) throws IllegalArgumentException {
        for (int num : inputNums) {
            if (num < startNumber) {
                throw new IllegalArgumentException("[ERROR]: 1보다 작은 당첨번호를 입력하였습니다. " + num);
            }
            if (num > endNumber) {
                throw new IllegalArgumentException("[ERROR]: 45보다 큰 당첨번호를 입력하였습니다. " + num);
            }
        }
    }

    public static int getBonusNumber(Lotto luckyNumbers) {
        int bonusNum = readBonusNumbers();
        luckyNumbers.validBonusNumber(bonusNum);
        checkRange(List.of(bonusNum));
        return bonusNum;
    }

    public static int readBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 입력값이 숫자가 아닙니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
