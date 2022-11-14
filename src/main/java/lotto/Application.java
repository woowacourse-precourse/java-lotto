package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;

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
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMsg());
        }
    }

    public static void validMoney(int money) throws IllegalArgumentException {
        if (money < lottoPrice) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LOW_PRICE.getErrorMsg());
        }
        if (money % lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PERFECT_PRICE.getErrorMsg());
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
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMsg());
            }
        }

        Collections.sort(numbers);

        return numbers;
    }

    public static void validLuckyNumbers(List<Integer> inputNums) throws IllegalArgumentException {
        if(inputNums.size() != inputNums.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED.getErrorMsg());
        }
    }

    public static void checkRange(List<Integer> inputNums) throws IllegalArgumentException {
        for (int num : inputNums) {
            if (num < startNumber) {
                throw new IllegalArgumentException(ErrorMessage.LOW_INPUT_ERROR.getErrorMsg() + num);
            }
            if (num > endNumber) {
                throw new IllegalArgumentException(ErrorMessage.HIGH_INPUT_ERROR.getErrorMsg() + num);
            }
        }
    }

    public static int getBonusNumber(Lotto luckyNumbers) {
        int bonusNum = readBonusNumbers();
        checkRange(List.of(bonusNum));
        luckyNumbers.validBonusNumber(bonusNum);
        return bonusNum;
    }

    public static int readBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMsg());
        }
    }

    public static int getResult(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        Map<Prize, Integer> prizeMap = LottoWin.getPrizeMap(lottos, luckyNums, bonusNum);
        printResult(prizeMap);
        int totalPrize = getTotalPrize(prizeMap);
        return totalPrize;
    }
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
