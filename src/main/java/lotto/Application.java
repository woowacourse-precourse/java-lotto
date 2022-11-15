package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
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
        if (MONEY == 0) {
            return;
        }

        List<Lotto> boughtLottos = new ArrayList<Lotto>();
        boughtLottos = buyLotto(boughtLottos, MONEY);
        printLottoList(boughtLottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        input = readInput();
        List<Integer> pickedNumbers = validatePickedNumbers(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        input = readInput();
        int bonusNum = validateBonusNum(input, pickedNumbers);

        LottoRegister lottoRegister = new LottoRegister();
        lottoRegister.calculateTotalGain(boughtLottos, pickedNumbers, List.of(bonusNum));
        lottoRegister.getRateOfReturn(MONEY);

        System.out.printf("총 수익률은 %.1f", lottoRegister.rateOfReturn);
        System.out.println("%입니다.");

        return;
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

    public static List<Integer> validatePickedNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> pickedNumbers = new ArrayList<Integer>();
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        pickedNumbers = checkExceptionCondition(numbers, pickedNumbers);

        return pickedNumbers;
    }

    public static List<Integer> checkExceptionCondition(String[] numbers, List<Integer> pickedNumbers) {
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
