package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final Validation validation = new Validation();
    private static final List<Winning> rankings = List.of(
            Winning.FIFTH,
            Winning.FOURTH,
            Winning.THRID,
            Winning.SECOND,
            Winning.FIRST
    );
    private static final InputOutput io = new InputOutput();

    static List<Integer> wins;

    public static void main(String[] args) {

        try {
            String price = io.getPrice();
            int amount = getPurchasePrice(price);

            List<Lotto> lottos = getRandomLottos(amount);
            io.printLottos(amount, lottos);

            String lukcyNumber = io.getLukcyNumber();
            Lotto lucky = makeLotto(lukcyNumber);

            String bonusNumber = io.getBonusNumber();
            int bonus = validateBonusNumber(bonusNumber, lucky);

            wins = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
            getResult(lottos, lucky, bonus);

            io.printResult(wins);
            io.printEarningRate(calculateEarningRate(amount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchasePrice(String input) {
        validation.validatePrice(input);
        return Integer.parseInt(input) / 1000;
    }

    private static List<Lotto> getRandomLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static Lotto makeLotto(String input) {
        String[] splitedInput = input.split(",");
        List<Integer> luckyNumber = new ArrayList<>();
        for (String s : splitedInput) {
            validation.validateNumber(s);
            int number = Integer.parseInt(s);
            validation.validateNumberRange(number);
            luckyNumber.add(number);
        }
        return new Lotto(luckyNumber);
    }

    private static int validateBonusNumber(String input, Lotto lotto) {
        validation.validateNumber(input);
        int bonus = Integer.parseInt(input);
        validation.validateNumberRange(bonus);
        lotto.isDuplicateBonusNumber(bonus);
        return bonus;
    }

    private static void getResult(List<Lotto> lottos, Lotto lucky, int bonus) {
        for (Lotto lotto : lottos) {
            int ranking = lucky.getRanking(lotto, bonus);
            if (ranking != 0) {
                Integer before = wins.get(5 - ranking);
                wins.set(5 - ranking, before + 1);
            }
        }
    }

    private static String calculateEarningRate(int amount) {
        int price = amount * 1000;
        long prize = calculatePrize();
        return String.format("%.1f", (float) prize / price * 100);
    }

    private static long calculatePrize() {
        long prize = 0;
        for (int i = 0; i < 5; i++) {
            Integer result = wins.get(i);
            prize += (long) rankings.get(i).prize * result;
        }
        return prize;
    }
}
