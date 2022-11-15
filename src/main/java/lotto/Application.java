package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;

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


    public static Integer getMoney() throws IllegalArgumentException {
        int money = readMoney();
        validMoney(money);
        return money;
    }

    public static Integer readMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해주세요.");
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    public static void validMoney(int money) throws IllegalArgumentException {
        if (money < lottoPrice) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LOW_PRICE);
        }
        if (money % lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PERFECT_PRICE);
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

    public static List<Integer> readLuckyNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        String[] inputs = userInput.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String input : inputs) {
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (Exception e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
            }
        }

        Collections.sort(numbers);

        return numbers;
    }

    public static void validLuckyNumbers(List<Integer> inputNums) throws IllegalArgumentException {
        if(inputNums.size() != inputNums.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LUCKY_NUMBER);
        }
    }

    public static void checkRange(List<Integer> inputNums) throws IllegalArgumentException {
        for (int num : inputNums) {
            if (num < startNumber) {
                throw new IllegalArgumentException(ErrorMessage.LOW_INPUT_ERROR);
            }
            if (num > endNumber) {
                throw new IllegalArgumentException(ErrorMessage.HIGH_INPUT_ERROR);
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    public static void getResult(List<Lotto> lottos, Lotto luckyNums, int bonusNum) {
        Map<Integer, Integer> prizeMap = LottoWin.getPrizeMap(lottos, luckyNums, bonusNum);
        int price = getTotalPrice(prizeMap);
        float profit = getProfit(price, lottos.size());
        printProfit(profit);
    }

    public static int getTotalPrice(Map<Integer, Integer> prizeMap) {
        int total = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = prizeList.size() - 1; i > 0; i--) {
            int temp = prizeMap.getOrDefault(i, 0);
            int winNum = prizeList.get(i).getNumOfLucky();
            int price = prizeList.get(i).getPrize();
            total += temp * price;
            String msg = getMessage(temp, winNum, price);
            System.out.println(msg);
        }
        return total;
    }

    public static String getMessage(int temp, int winNum, int price) {
            String commaNum = NumberFormat.getInstance(Locale.US).format(price);
            String msg = "";
            msg += winNum +"개 일치";
            if (price == 30_000_000) {
                msg += ", 보너스 볼 일치";
            }
            msg += " ("+ commaNum + "원) - " + temp + "개";
            return msg;
    }
    public static float getProfit(Integer totalPrice, Integer numOfLottos) {
        int initialPrice = numOfLottos * lottoPrice;
        float profit = ((totalPrice) / (float) initialPrice) * 100;
        return profit;
    }

    public static void printProfit(float profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public static void playLottos() {
        int initialPrice = getMoney();
        validMoney(initialPrice);
        int numOfLottos = getNumberOfLotto(initialPrice);
        List<Lotto> lottos = getLottos(numOfLottos);
        Lotto luckyNumbers = getLuckyNumbers();
        int bonusNumber = getBonusNumber(luckyNumbers);
        getResult(lottos, luckyNumbers, bonusNumber);
    }

    public static void main(String[] args){
        // TODO: 프로그램 구현
        try {
            playLottos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
