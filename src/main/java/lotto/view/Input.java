package lotto.view;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Input {
    public static int input(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        int amount = Integer.valueOf(input);

        return amount;
    }

    public static ArrayList prizeNum(){
        ArrayList<Integer> prizeAll = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String prizeNum = readLine();
        String[] prizeNums = prizeNum.split(",");
        for(int num = 0; num < prizeNums.length; num++){
            int target = Integer.valueOf(prizeNums[num]);
            prizeAll.add(target);
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        String bo = readLine();
        int bonus = Integer.valueOf(bo);
        prizeAll.add(bonus);

        return prizeAll;

    }
}
