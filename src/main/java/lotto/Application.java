package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> issue_Number(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static void main(String[] args) {
        issue_Number();


//        int num = Integer.parseInt(Console.readLine());
//        System.out.println(number);
//        Lotto winning_number = new Lotto(number);

    }
}
