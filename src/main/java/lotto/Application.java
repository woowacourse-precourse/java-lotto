package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void validate(int value){
        if (value % 1000 !=0) {
            System.out.println("[ERROR] 구입 금액은 1000원 단위입니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int buyingValue = Integer.parseInt(Console.readLine());
        validate(buyingValue);

        int countOfLotto = buyingValue/1000;
        System.out.println(countOfLotto+"개를 구매했습니다.");
        List<Lotto> myLottos = new ArrayList<Lotto>();
        for(int i=0;i<countOfLotto;i++)
        {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottos.add(new Lotto(numbers));
            myLottos.get(i).printNumbers();
        }

    }
}
