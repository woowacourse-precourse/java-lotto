package lotto;

import java.util.List;

public class Input {

    public static Integer receiveMoney() {
        String money = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(money);
    }

    public static void receiveWinningNumbers(List<Integer> winningNumbers) {
        String number;
        for (int i = 0; i < 6; i++) {
            number = camp.nextstep.edu.missionutils.Console.readLine();
            winningNumbers.add(Integer.parseInt(number));
        }
    }

//    public static void receiveBonusNuber(){
//
//    }
}
