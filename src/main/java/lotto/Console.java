package lotto;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Console {

    public double inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        double money = Double.valueOf(readLine());
        return money;
    }
}
