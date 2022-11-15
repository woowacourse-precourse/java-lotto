package lotto.view;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Input {
    public static int input(){
        int amount = 0;
        System.out.println("구입금액을 입력해 주세요.");
        try{
            amount = Integer.valueOf(readLine());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]");
        }
        return amount;
    }

    public static List prizeNum(String prizeNum){
        List<Integer> prizeAll = new ArrayList<>();

        if (!(prizeNum.contains(","))) {
            throw new IllegalArgumentException("[ERROR]");
        }

        String[] prizeNums = prizeNum.split(",");
        for(int num = 0; num < prizeNums.length; num++){
            int target = Integer.valueOf(prizeNums[num]);
            prizeAll.add(target);
        }

        if (prizeAll.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return prizeAll;

    }

    public static int bonus(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return bonusNumber;
    }
}
