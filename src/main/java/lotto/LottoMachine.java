package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InfoEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoMachine {
    public static List<Integer> winningNumber() {
        java.lang.System.out.println("\n" + InfoEnum.WINNING_NUMBER.getMessage());
        String numbers = Console.readLine();

        Game.inputException(numbers);

        List<Integer> winningNumbersList = new ArrayList<>(); //당첨 번호 담긴 리스트
        StringTokenizer st = new StringTokenizer(numbers, ",");

        while(st.hasMoreTokens()) {
            int element = Integer.parseInt(st.nextToken());
            winningNumbersList.add(element);
        }

        return winningNumbersList;
    }

    public static void bonusNumber() {
        java.lang.System.out.println("\n" + InfoEnum.BONUS_NUMBER.getMessage());
        String tempBonus = Console.readLine();
        Game.BONUS = Integer.parseInt(tempBonus);
    }
}
