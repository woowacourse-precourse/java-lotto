package lotto.input;

import lotto.Lotto;
import lotto.output.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    public static List<Integer> winner(){
        System.out.println("");
        System.out.println(View.InputMessage.WIN_NUM.print());
        String winNum = readLine();
        List<String> winner = Arrays.asList(winNum.split(","));
        List<Integer> winNumber = winner.stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
        new Lotto(winNumber);
        return winNumber;
    }
    public static int bonusNum(){
        System.out.println("");
        System.out.println(View.InputMessage.BONUS_NUM.print());
        int bonus = Integer.parseInt(readLine());
        return bonus;
    }
}
