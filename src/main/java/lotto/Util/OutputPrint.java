package lotto.Util;

import lotto.domain.Lotto;
import lotto.type.PriceType;
import lotto.type.ResultType;
import lotto.type.TextType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputPrint {
    public static void moneyToNumberPrint(int number){
        System.out.println(number + "" + TextType.PRICE_TO_NUMBER.getText());
    }

    public static void generatedLottoNumbersPrint(ArrayList<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.print("[");
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.print(numbers.get(i) + ", ");
            }
            System.out.println( numbers.get(numbers.size() - 1) + "]");
        }
    }

    public static void prizePrint(){
        System.out.println("\n" + TextType.WINNING_STATISTICS.getText() + "\n" + "---");
    }

    public static void resultPrint(Map<Integer ,Integer> matchResults, int money, int sum){
        System.out.println(ResultType.MATCH_THREE.getResult() + " " + ResultType.MATCH.getResult() + " "
                + PriceType.FIFTH.getPrice() + " - " + matchResults.getOrDefault(3, 0)
                + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_FOUR.getResult() + " " + ResultType.MATCH.getResult() + " "
                + PriceType.FOURTH.getPrice() + " - " + matchResults.getOrDefault(4, 0)
                + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_FIVE.getResult() + " " + ResultType.MATCH.getResult() + " "
                + PriceType.THIRD.getPrice() + " - " + matchResults.getOrDefault(5, 0)
                + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_FIVE.getResult() + " " + ResultType.MATCH.getResult() + ", " +
                ResultType.MATCH_BONUS.getResult() + " " + PriceType.SECOND.getPrice()
                + " - " + matchResults.getOrDefault(7, 0) + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_SIX.getResult() + " " + ResultType.MATCH.getResult() + " "
                + PriceType.FIRST.getPrice() + " - " + matchResults.getOrDefault(6, 0)
                + ResultType.DIGIT.getResult());

        System.out.println(TextType.EARN_PERCENT.getText() + " "
                + String.format("%.1f", ((double) sum  / (double) money) * 100.0) + "%입니다.");
    }

    public static void printError(String log){
        System.out.println(log);
    }
}
