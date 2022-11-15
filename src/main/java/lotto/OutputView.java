package lotto;


import java.text.*;
import java.util.*;

public class OutputView {
    public static final String DELIMITER = " ";
    public static final String SEPARATOR = "-";

    public enum Messages {
        LOTTO_AMOUNT("\n%d개를 구매했습니다."),
        RESULT_GUIDE("\n당첨 통계\n---"),
        COMPARISON_RESULT_LOTTO_NUMBERS("%d개 일치"),
        COMPARISON_RESULT_CASH("(%s원)"),
        COMPARISON_RESULT_COUNT("%d개"),
        COMPARISON_RESULT_BONUS_NUMBER("보너스 볼 일치"),
        CALCULATE_RESULT("총 수익률은 %.1f%%입니다.");

        private final String message;
        Messages(String message) {
            this.message = message;
        }
    }


    public static void printLottos(Integer amount, List<List<Integer>> lottos) {
        System.out.println(String.format(Messages.LOTTO_AMOUNT.message, amount));
        lottos.forEach(System.out::println);
    }

    public static void printCountResult(Map<Comparison.Result, Integer> results) {
        System.out.println(Messages.RESULT_GUIDE.message);
        Map<Integer, String> orderedResult = new HashMap<>();
        for (Map.Entry<Comparison.Result, Integer> result: results.entrySet()) {
            orderedResult.put(result.getKey().getCash(), createCountResultMessage(result));
        }
        orderedResult.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(
                result -> System.out.println(result.getValue())
        );
    }

    public static void printStatisticResult(float profit) {
        System.out.println(String.format(Messages.CALCULATE_RESULT.message, profit));
    }

    public static String createCountResultMessage(Map.Entry<Comparison.Result, Integer> result) {
        List<String> resultMessage = new ArrayList<>();
        resultMessage.add(String.format(
                Messages.COMPARISON_RESULT_LOTTO_NUMBERS.message, result.getKey().getCount()
        ));
        if (Objects.equals(result.getKey(), Comparison.Result.FIVE_WITH_BONUS)) {
            resultMessage.add(resultMessage.get(0).concat(","));
            resultMessage.remove(0);
            resultMessage.add(Messages.COMPARISON_RESULT_BONUS_NUMBER.message);
        }
        resultMessage.add(String.format(
                Messages.COMPARISON_RESULT_CASH.message, separateCash(result.getKey().getCash())
        ));
        resultMessage.add(SEPARATOR);
        resultMessage.add(String.format(
                Messages.COMPARISON_RESULT_COUNT.message, result.getValue()
        ));
        return String.join(DELIMITER, resultMessage);
    }

    public static String separateCash(Integer cash) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(cash);
    }
}
