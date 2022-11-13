package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.mockito.internal.util.collections.ListUtil;

public class PurchaseLotto {
    //1
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = readLine();
        int money = Integer.valueOf(moneyInput);
        return countLotto(money);

    }

    public static int countLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
        }
        return money / 1000;
    }

    private List<Integer> myLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    //2
    public List<List<Integer>> myLotto(int count){
        List<List<Integer>> totalLotto = new ArrayList<>();
        System.out.printf("%d개를 구매했습니다.\n",count);
        for (int index=0;index<count;index++){
            totalLotto.add(myLottoNumber());
        }
    return totalLotto;
    }
    public void printMyLotto(List<List<Integer>> totalLotto){
        for (int index=0;index<totalLotto.size();index++){
            System.out.println(totalLotto.get(index));
        }
    }
    public List<Integer> myLottoResult(List<Integer> lottoNumber, int bonusNumber) {
        int money = inputMoney();
        ConsumerResult consumerResult =new ConsumerResult();
        List<Integer> totalCount=new ArrayList<>();
        List<Integer> bonusCount=new ArrayList<>();
        List<Integer> jionCount=new ArrayList<>();
        for (int count=0; count < countLotto(money); count++){
            List<Integer> numbers=myLottoNumber();
            System.out.println(numbers);
            totalCount.add(consumerResult.compareLotto(numbers,lottoNumber));
            bonusCount.add(consumerResult.compareBonus(numbers, bonusNumber));
        }
        jionCount.addAll(totalCount);
        jionCount.addAll(bonusCount);
        return jionCount;
    }
}
