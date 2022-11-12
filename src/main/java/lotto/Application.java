package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // 1.
        System.out.println(UiValue.BUY_MONEY_INPUT.getUiValue());
        String inputMoney = Console.readLine();
        int money = validateInputMoney(inputMoney);

        // 2.
        List<Lotto> lottos = createLottos(money);

        // 3.
        printLottos(money, lottos);

        // 4.
        System.out.println(UiValue.WINNIG_NUMBERS_INPUT.getUiValue());
        String inputWinningNums = Console.readLine();
        validateInputWinningNums(inputWinningNums);

        System.out.println(UiValue.BONUS_NUMBER_INPUT.getUiValue());
        String inputBonusNum = Console.readLine();
        validateInputBonusNum(inputBonusNum);

        List<Integer> winningNums = parseInputWinningNumsIntoInteger(inputWinningNums);
        int bonusNum = Integer.parseInt(inputBonusNum);

        // 5.
        Map<String, Integer> winningCnt = checkWinningCnt(lottos, winningNums, bonusNum);
        String yield = calcurateYield(money, winningCnt);
        printYield(winningCnt, yield);
    }

    private static int validateInputMoney(String inputMoney) {
        if (!inputMoney.matches(RegValue.NUMBER_REG.getReg())) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            throw new NoSuchElementException("[ERROR] 숫자만 입력 가능합니다.");
        } else if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력할 수 있습니다.");
        }
        return Integer.parseInt(inputMoney);
    }

    private static void validateInputWinningNums(String inputWinningNums) {
        if (!inputWinningNums.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자 \",\"를 포함해야 합니다.");
        }
        String[] inputWinningNumsArr = inputWinningNums.split(",");
        if (inputWinningNumsArr.length < 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해야 합니다.");
        }
        for (String s : inputWinningNumsArr) {
            if (!s.matches(RegValue.LOTTO_NUMBER_REG.getReg())) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1~45까지만 입력할 수 있습니다.");
            }
        }
    }

    private static void validateInputBonusNum(String inputBonusNum) {
        if (!inputBonusNum.matches(RegValue.NUMBER_REG.getReg())) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static List<Lotto> createLottos(int money) {
        int lottoCnt = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(int money, List<Lotto> lottos) {
        System.out.printf(UiValue.BUY_LOTTO_CNT.getUiValue(), money / 1000);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    private static List<Integer> parseInputWinningNumsIntoInteger(String inputWinningNums) {
        List<String> inputWinningNumsList = Arrays.asList(inputWinningNums.split(","));
        return inputWinningNumsList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static Map<String, Integer> checkWinningCnt (List<Lotto> lottos, List<Integer> winningNums, int bonusNum) {
        Map<String, Integer> winningCnt;
        winningCnt = new HashMap<>(Map.of(RankValue.FST_RANK.getRank(), 0, RankValue.SCD_RANK.getRank(), 0, RankValue.THD_RANK.getRank(), 0, RankValue.FOUR_RANK.getRank(), 0, RankValue.FIVE_RANK.getRank(), 0));

        for (Lotto lotto: lottos) {
            String rank = lotto.checkWinningNums(winningNums, bonusNum);
            if (winningCnt.containsKey(rank)) {
                winningCnt.replace(rank, winningCnt.get(rank) + 1);
            }
        }
        return winningCnt;
    }

    private static String calcurateYield(int money, Map<String, Integer> winningCnt) {
        double winningMoney = 2000000000 * winningCnt.get(RankValue.FST_RANK.getRank())
            + 30000000 * winningCnt.get(RankValue.SCD_RANK.getRank())
            + 1500000 * winningCnt.get(RankValue.THD_RANK.getRank())
            + 50000 * winningCnt.get(RankValue.FOUR_RANK.getRank())
            + 5000  * winningCnt.get(RankValue.FIVE_RANK.getRank());
        return String.valueOf(Math.round(((winningMoney /money) * 100) * 100) / 100.0).concat("%");
    }

    private static void printYield(Map<String, Integer> winningCnt, String yield) {
        System.out.println(UiValue.WINNING_YIELD_OUTPUT.getUiValue());
        System.out.printf(UiValue.FIVE_RANK.getUiValue(), winningCnt.get(RankValue.FIVE_RANK.getRank()));
        System.out.printf(UiValue.FOUR_RANK.getUiValue(), winningCnt.get(RankValue.FOUR_RANK.getRank()));
        System.out.printf(UiValue.THD_RANK.getUiValue(), winningCnt.get(RankValue.THD_RANK.getRank()));
        System.out.printf(UiValue.SCD_RANK.getUiValue(), winningCnt.get(RankValue.SCD_RANK.getRank()));
        System.out.printf(UiValue.FST_RANK.getUiValue(), winningCnt.get(RankValue.FST_RANK.getRank()));
        System.out.printf(UiValue.YIELD_OUTPUT.getUiValue(), yield);
    }
}
