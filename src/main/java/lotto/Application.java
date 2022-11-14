package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Application {
    public enum LotteryWon {
        FirstPlace(value -> value * 2_000_000_000),
        SecondPlace(value -> value * 30_000_000),
        ThirdPlace(value -> value * 1_500_000),
        FourthPlace(value -> value * 50_000),
        FifthPlace(value -> value * 5000),
        Nothing(value->0);

        private Function<Integer, Integer> expression;

        LotteryWon(Function<Integer, Integer> expression) {
            this.expression = expression;
        }

        public int calculateIncome(int value) {
            return expression.apply(value);
        }
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readInput();

        final int MONEY = validateMoneyInput(input);
        List<Lotto> boughtLottos = new ArrayList<Lotto>();

        boughtLottos = buyLotto(boughtLottos, MONEY);
        printLottos(boughtLottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        input = readInput();
        List<Integer> pickedNumbers = validatePickedNumbers(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        input = readInput();
        int bonusNum = parseInt(input);
        if (pickedNumbers.contains(bonusNum) || bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[Error] Number should be in the range of 1 ~ 45");
        }

        int totalIncome = calculateTotalGain(boughtLottos, pickedNumbers, bonusNum);
        float rateOfReturn = getRateOfReturn(totalIncome, MONEY);
        System.out.println("총 수익률은 "+rateOfReturn+"입니다.");
    }

    public static float getRateOfReturn(int totalIncome, final int MONEY) {
        float rateOfReturn = totalIncome/MONEY;
        return rateOfReturn;
    }

    public static int calculateTotalGain(List<Lotto> boughtLottos, List<Integer> pickedNumbers, int bonusNum) {
        LotteryWon income;
        HashMap<LotteryWon, Integer> history = new HashMap<LotteryWon, Integer>();
        int totalIncome = 0;

        for (int i = 0; i < boughtLottos.size(); i++) {
            int matchCount = countMatchedNumber(boughtLottos.get(i), pickedNumbers);
            income = selectLotteryWonType(matchCount);
            history = updateHistory(history, income);
            totalIncome += income.calculateIncome(1);
        }
        printHistory(history);

        return totalIncome;
    }

    public static void printHistory(HashMap<LotteryWon, Integer> history) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+history.get(LotteryWon.FifthPlace));
        System.out.println("4개 일치 (50,000원) - "+history.get(LotteryWon.FourthPlace));
        System.out.println("5개 일치 (1,500,000원) - "+history.get(LotteryWon.ThirdPlace));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+history.get(LotteryWon.SecondPlace));
        System.out.println("6개 일치 (2,000,000,000원) - "+history.get(LotteryWon.FifthPlace));
    }

    public static HashMap<LotteryWon, Integer> updateHistory(HashMap<LotteryWon, Integer> history, LotteryWon income) {
        if (history.containsKey(income)) {
            history.replace(income, history.get(income) + 1);
            return history;
        }
        history.put(income, 1);
        return history;
    }

    public static int countMatchedNumber(Lotto lotto, List<Integer> pickedNumbers) {
        int count = 0;

        for (int i = 0; i < pickedNumbers.size(); i++) {
            int number = pickedNumbers.get(i);
            count += lotto.matchNumber(number);
        }

        return count;
    }

    public static LotteryWon selectLotteryWonType(int matchCount) {
        LotteryWon result;
        if (matchCount == 6) {
            result = LotteryWon.FirstPlace;
            return result;
        } else if (matchCount == 5) {
            result = LotteryWon.SecondPlace;
            return result;
        } else if (matchCount == 5) {
            result = LotteryWon.ThirdPlace;
            return result;
        } else if (matchCount == 4) {
            result = LotteryWon.FourthPlace;
            return result;
        } else if (matchCount == 3) {
            result = LotteryWon.FifthPlace;
            return result;
        }

        return LotteryWon.Nothing;
    }

    public static List<Integer> validatePickedNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> pickedNumbers = new ArrayList<Integer>();

        if (numbers.length != 6) {
            throw new IllegalArgumentException("[Error] pick 6 different number between 1 to 45");
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = parseInt(numbers[i]);

            if (pickedNumbers.contains(number)) {
                throw new IllegalArgumentException("[Error] Duplicated number exists");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[Error] Number should be in the range of 1 ~ 45");
            }
            pickedNumbers.add(number);
        }

        return pickedNumbers;
    }

    public static void printLottos(List lottos) {
        StringBuilder lottoNumbers = new StringBuilder();
        for (int i = 0; i < lottos.size(); i++) {
            lottoNumbers.append("[");
            Lotto lottoItem = (Lotto) lottos.get(i);

            for (int j = 0; j < lottoItem.getNumbers().size(); j++) {
                int number = lottoItem.getNumbers().get(j);
                lottoNumbers.append(String.valueOf(number) + ", ");
            }

            lottoNumbers.append("]\n");
        }

        System.out.print(lottoNumbers);
    }

    public static List<Lotto> buyLotto(List lottos, int money) {
        int numberOfLottos = (money / 1000);

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoItem = new Lotto(randomNumbers);
            lottos.add(lottoItem);
        }

        return lottos;
    }

    public static int validateMoneyInput(String input) {
        int money = parseInt(input);
        boolean isUnitOf1K = ((money % 1000) == 0);

        if (isUnitOf1K == false) {
            throw new IllegalArgumentException("[Error] Money should end with 000");
        }

        return money;
    }

    public static int parseInt(String input) {
        try {
            int money = Integer.parseInt(input);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] Only numbers are allowed");
        }
    }

    public static String readInput() {
        String input = Console.readLine();
        return input;
    }


}
