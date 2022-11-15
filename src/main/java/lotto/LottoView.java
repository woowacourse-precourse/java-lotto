package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.*;

public class LottoView {
    private static final String PURCHASE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASE = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT = "\n당첨 통계\n---\n";
    private static final String WINNING_RESULT_NOT_BONUS = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_RESULT_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PROFIT_RESULT = "총 수익률은 %s%%입니다.";
    private static final String ERROR_INVALID = "[ERROR] 유효하지 않은 입력입니다.";

    public static int inputMoney(){
        System.out.println(PURCHASE);
        try{
            return convertInputToInt(Console.readLine());
        }
        catch (IllegalArgumentException e){
            //System.out.println(e.getMessage());
            return 0;
        }
    }
    public static void printNumber_of_Purchase(int Number_of_Purchase){
        System.out.printf(NUMBER_OF_PURCHASE,Number_of_Purchase);
    }
    public static void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            System.out.println(Arrays.toString(lotto.getNumbers().stream().sorted().toArray()));
        }
    }
    public static void printInputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
    }
    public static void printInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
    private static int convertInputToInt(String input) throws IllegalArgumentException{
        if (!input.matches("^[0-9]*$")){
            throw new IllegalArgumentException(ERROR_INVALID);
        }
        return Integer.parseInt(input);
    }

    public static void printWinningResult(HashMap<Rank,Integer> result){
        DecimalFormat formatter = new DecimalFormat("###,###");
        Rank[] rankName = Rank.values();
        System.out.printf(WINNING_RESULT);

        for(Rank rank:rankName){
            int NUM = 0;
            if(result.get(rank) != null){
                NUM = result.get(rank);
            }
            if(rank.equals(Rank.SECOND)){
                System.out.printf(WINNING_RESULT_BONUS, rank.getMatchCount(), formatter.format(rank.getPrize()), NUM);
            }
            if(!rank.equals(Rank.FAIL) && !rank.equals(Rank.SECOND)){
                System.out.printf(WINNING_RESULT_NOT_BONUS, rank.getMatchCount(), formatter.format(rank.getPrize()), NUM);
            }
        }
    }
    public static void printProfitResult(double profit){
        System.out.printf(PROFIT_RESULT, String.format("%.1f",profit));
    }
}
