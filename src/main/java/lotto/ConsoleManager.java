package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleManager {
    private static final LottoService lottoService = Context.getLottoService();
    private static final Validator validator = Context.getValidator();

    public static void runUI() {
        Integer purchaseAmount = readPurchaseAmount();
        List<Lotto> lottos = lottoService.purchase(purchaseAmount);
        printLottosInformation(lottos);
        List<Integer> winningNumbers = readWinningNumbers();
        Integer bonusNumber = readBonusNumber();
        if(winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 다른번호와 중복됩니다.");
        Map<Rank, Integer> result = lottoService.calculateResult(lottos, winningNumbers, bonusNumber);
        printStatistic(result);
        printYield(result, purchaseAmount);
    }

    private static void printStatistic(Map<Rank, Integer> result){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", result.getOrDefault(Rank.FIFTH, 0)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", result.getOrDefault(Rank.FOURTH, 0)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", result.getOrDefault(Rank.THIRD, 0)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", result.getOrDefault(Rank.SECOND, 0)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", result.getOrDefault(Rank.FIRST, 0)));
    }

    private static void printYield(Map<Rank, Integer> result, Integer purchaseAmount) {
        Double yield = lottoService.calculateYield(purchaseAmount, result);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", yield));
    }

    private static Integer readBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer ret = readNextInteger();
        if(!validator.isBetween1And45(ret))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이어야 합니다.");
        System.out.println();
        return ret;
    }

    private static List<Integer> readWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> ret = readNextIntegers(",");
        boolean valid = ret.stream()
                .allMatch(validator::isBetween1And45);
        if(!valid)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이어야 합니다.");
        System.out.println();
        return ret;
    }

    private static void printLottosInformation(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for(var lotto : lottos)
            System.out.println(lotto);
        System.out.println();
    }

    private static Integer readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer ret = readNextInteger();
        System.out.println();
        return ret;
    }

    public static List<Integer> readNextIntegers(String delimiter) {
        String line = readLine();
        return Stream.of(line.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer readNextInteger() {
        String line = readLine();
        boolean valid = line.chars()
                .mapToObj(e -> (char) e)
                .allMatch(Character::isDigit);
        if(!valid)
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        return Integer.parseInt(line);
    }
}
