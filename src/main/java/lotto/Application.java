package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application extends Lotto {

    public String price = "";

    public Application(List<Integer> numbers) {
        super(numbers);
    }

    public void getLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        price = Console.readLine();
    }

    public void buyLotto(){
        int costs = Integer.parseInt(price);
        costs = costs / 1000;
        System.out.println(costs + "개를 구매했습니다.");
    }

    public static void main(String[] args) {
        String price = "";
        System.out.println("구입금액을 입력해 주세요.");
        price = Console.readLine();     //구입금액
        int howManyTimes = (Integer.parseInt(price))/10;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Application application = new Application(numbers);
        application.randomLotto(price);
    }
}
