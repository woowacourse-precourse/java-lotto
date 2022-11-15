package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLotto {

    public String price = "";

    public String getPrice() {
        return price;
    }

    public List<Integer> randomLotto(){

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
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
}
