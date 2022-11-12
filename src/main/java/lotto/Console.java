package lotto;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Console {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.valueOf(readLine());
        return money;
    }
}
