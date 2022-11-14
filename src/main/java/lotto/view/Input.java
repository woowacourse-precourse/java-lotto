package lotto.view;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Input {
    public static int input(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        int amount = Integer.valueOf(input);

        return amount;
    }
}
