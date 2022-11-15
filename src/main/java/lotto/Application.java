package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    static final int lottoPrice = 1000;
    static final int startNumber = 1;
    static final int endNumber = 45;

    static final Map<Integer, Prize> prizeList = new HashMap<>() {{
        put(1, Prize.FIRST);
        put(2, Prize.SECOND);
        put(3, Prize.THIRD);
        put(4, Prize.FOURTH);
        put(5, Prize.FIFTH);
        put(0, Prize.NOTHING);
    }};


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

    public static void getResult(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        Map<Integer, Integer> prizeMap = LottoWin.getPrizeMap(lottos, luckyNums, bonusNum);
        int result = printResult(prizeMap);
        float profit = getProfit(result, lottos.size());
        printProfit(profit);
    }

    public static int printResult(Map<Integer, Integer> prizeMap) {
        int total = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < prizeList.size(); i++) {
            int temp = prizeMap.getOrDefault(i + 1, 0);
            int price = prizeList.get(i + 1).getPrize();
            System.out.println(temp +"개 일치 (" + price + ")원 - " + temp + "개");
            total += temp * price;
        }
        return total;
    }

    public static float getProfit(Integer totalPrice, Integer numOfLottos) {
        int initalPrice = numOfLottos * lottoPrice;
        float profit = 100 * totalPrice / (float) initalPrice;
        profit = Math.round(profit * 10) / 10;
        return profit;
    }

    public static void printProfit(float profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
