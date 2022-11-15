package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import number.BonusNumber;
import number.WinningNumbers;
import type.Comments;
import type.Rank;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Comments.print(Comments.INPUT_MONEY);
            Money money = new Money(toInt(Console.readLine()));
            LottoGroups lottos = new LottoGroups(createLottos(money.getNumberToPublishLottos()));
            Comments.printLottos(lottos);

            Comments.print(Comments.INPUT_WINNING_NUMBERS);
            WinningNumbers winningNumbers = new WinningNumbers(toIntegers(spilt(Console.readLine())));
            Comments.print(Comments.INPUT_BONUS_NUMBER);
            BonusNumber bonusNumber = new BonusNumber(inputBonusNumber(winningNumbers));

            printStatistics(money, lottos.numbersOfRanks(winningNumbers.get(), bonusNumber.get()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Lotto> createLottos(int numberToPublishLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberToPublishLottos; i++) {
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return lottos;
    }

    private static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private static String[] spilt(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자 6개와 ,(쉼표)로만 작성해야 합니다.");
        return input.split(",");
    }

    private static List<Integer> toIntegers(String[] input) {
        List<Integer> result = new ArrayList<>();
        try {
            Arrays.stream(input).forEach(item -> result.add(Integer.parseInt(item)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자 6개와 ,(쉼표)로만 작성해야 합니다.");
        }
        return result;
    }

    private static int inputBonusNumber(WinningNumbers winningNumbers) {
        int bonusNumber = toInt(Console.readLine());
        winningNumbers.validateDuplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public static Long sumOfProceeds(Map<Rank, Integer> numbersOfRanks) {
        List<Long> proceeds = new ArrayList<>();
        Arrays.stream(Rank.values()).limit(5).forEach(rank ->
                proceeds.add(rank.calculate(numbersOfRanks.get(rank))));

        return proceeds.stream().mapToLong(proceed -> proceed).sum();
    }

    private static void printStatistics(Money money, Map<Rank, Integer> numbersOfRanks) {
        Comments.print(Comments.WINNING_TOTAL);
        Rank.printTotalResultComment(numbersOfRanks);
        Comments.printYield(money.calculateYield(sumOfProceeds(numbersOfRanks)));
    }
}
