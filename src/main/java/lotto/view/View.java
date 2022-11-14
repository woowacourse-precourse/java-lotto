package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.type.Prize;
import lotto.validator.LottoValidator;

public class View {

    public long inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String inputString = Console.readLine();
        LottoValidator.validateHasNumber(List.of(inputString));
        long money = Long.parseLong(inputString);
        validateMoney(money);
        return money;
    }

    private void validateMoney(long money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력금액은 1000원 단위여야 합니다.");
        }
    }

    public void printBuyLotto(LottoDto lottoDto) {
        List<List<Integer>> lotteries = lottoDto.getLotteries();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public LottoInputDto inputNumbers() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 정수를 입력하면 안됩니다.");
        }
        return new LottoInputDto(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String numbers = Console.readLine();
        List<String> inputStrings = Arrays.stream(numbers.split(","))
                .sorted()
                .collect(Collectors.toList());
        LottoValidator.validateHasNumber(inputStrings);

        List<Integer> winningNumbers = inputStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        LottoValidator.validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

    private int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String inputString = Console.readLine();
        LottoValidator.validateHasNumber(List.of(inputString));
        return Integer.parseInt(inputString);
    }

    public void printPrize(PrizeDto prizeDto) {
        Map<Prize, Long> prizeLongMap = prizeDto.groupByPrizes();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.THREE, 0L));
        System.out.printf("4개 일치 (50,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.FOUR, 0L));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.FIVE, 0L));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.FIVE_AND_BONUS, 0L));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", prizeLongMap.getOrDefault(Prize.SIX, 0L));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", prizeDto.getYield());

    }

}
