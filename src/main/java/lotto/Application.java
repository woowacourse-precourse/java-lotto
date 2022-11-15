package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
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
        Nothing(value -> 0);

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
        printLottoList(boughtLottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        input = readInput();
        List<Integer> pickedNumbers = validatePickedNumbers(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        input = readInput();

        int bonusNum = validateBonusNum(input, pickedNumbers);
        int totalIncome = calculateTotalGain(boughtLottos, pickedNumbers, List.of(bonusNum));
        float rateOfReturn = getRateOfReturn(totalIncome, MONEY);

        System.out.printf("총 수익률은 %.1f", rateOfReturn);
        System.out.println("%입니다.");

        return;
    }

    public static float getRateOfReturn(int totalIncome, final int MONEY) {
        float rateOfReturn = (float) totalIncome / MONEY * 100;
        return rateOfReturn;
    }

    public static int validateBonusNum(String input, List pickedNumbers) {
        int bonusNum = parseInt(input);

        if (pickedNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return bonusNum;
    }

    public static int calculateTotalGain(List<Lotto> boughtLottos, List<Integer> pickedNumbers, List<Integer> bonusNum) {
        LotteryWon income;
        HashMap<LotteryWon, Integer> history = initializeHistory();
        int totalIncome = 0;

        for (int i = 0; i < boughtLottos.size(); i++) {
            int matchCount = countMatchedNumber(boughtLottos.get(i), pickedNumbers);
            int bonusCount = countMatchedNumber(boughtLottos.get(i), bonusNum);

            income = selectLotteryWonType(matchCount, bonusCount);
            history = updateHistory(history, income);
            totalIncome += income.calculateIncome(1);
        }
        printHistory(history);

        return totalIncome;
    }

    public static void printHistory(HashMap<LotteryWon, Integer> history) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + history.get(LotteryWon.FifthPlace) + "개");
        System.out.println("4개 일치 (50,000원) - " + history.get(LotteryWon.FourthPlace) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + history.get(LotteryWon.ThirdPlace) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + history.get(LotteryWon.SecondPlace) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + history.get(LotteryWon.FirstPlace) + "개");
    }

    public static HashMap<LotteryWon, Integer> updateHistory(HashMap<LotteryWon, Integer> history, LotteryWon income) {
        history.replace(income, history.get(income) + 1);
        return history;
    }

    public static HashMap<LotteryWon, Integer> initializeHistory() {
        HashMap<LotteryWon, Integer> history = new HashMap<LotteryWon, Integer>();
        history.put(LotteryWon.FirstPlace, 0);
        history.put(LotteryWon.SecondPlace, 0);
        history.put(LotteryWon.ThirdPlace, 0);
        history.put(LotteryWon.FourthPlace, 0);
        history.put(LotteryWon.FifthPlace, 0);
        history.put(LotteryWon.Nothing, 0);

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

    public static LotteryWon selectLotteryWonType(int matchCount, int bonusCount) {
        LotteryWon result;
        if (matchCount == 6) {
            result = LotteryWon.FirstPlace;
            return result;
        } else if (matchCount == 5 && bonusCount == 1) {
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
            throw new IllegalArgumentException("[ERROR]");
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = parseInt(numbers[i]);

            if (pickedNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR]");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR]");
            }
            pickedNumbers.add(number);
        }

        return pickedNumbers;
    }

    public static void printLottoList(List lottos) {

        for (int i = 0; i < lottos.size(); i++) {

            Lotto lottoItem = (Lotto) lottos.get(i);
            printLotto(lottoItem);
        }
        System.out.println();
    }

    public static void printLotto(Lotto lottoItem) {
        StringBuilder lottoNumbers = new StringBuilder();
        lottoNumbers.append("[");

        for (int j = 0; j < lottoItem.getNumbers().size(); j++) {
            int number = lottoItem.getNumbers().get(j);
            lottoNumbers.append(number);

            if (j != lottoItem.getNumbers().size() - 1) {
                lottoNumbers.append(", ");
            }
        }
        lottoNumbers.append("]\n");
        System.out.print(lottoNumbers);
    }

    public static List<Lotto> buyLotto(List lottos, int money) {
        int numberOfLottos = (money / 1000);

        for (int i = 0; i < numberOfLottos; i++) {

            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomNumbers = generateLottoNumbers(randomNumbers);
            Lotto lottoItem = new Lotto(randomNumbers);
            lottos.add(lottoItem);
        }
        System.out.println(numberOfLottos + "개를 구매했습니다.");

        return lottos;
    }

    public static List<Integer> generateLottoNumbers(List<Integer> Randoms) {
        List<Integer> randomNumbers = new ArrayList<Integer>(Randoms);

        randomNumbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return randomNumbers;
    }

    public static int validateMoneyInput(String input) {
        int money = parseInt(input);
        boolean isUnitOf1K = ((money % 1000) == 0);

        if (isUnitOf1K == false) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return money;
    }

    public static int parseInt(String input) {
        try {
            int money = Integer.parseInt(input);
            return money;
        } catch (NumberFormatException e) {
            System.out.println(new IllegalArgumentException("[ERROR]"));
            return 0;
        }
    }

    public static String readInput() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

}
