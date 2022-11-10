package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public void printUserLottos(User user){
        System.out.println(user.getMoney()+"개를 구매했습니다.");
        List<Lotto> myLottoNumbers = user.getMyLottoNumbers();
        for (Lotto myLottoNumber : myLottoNumbers) {
            List<Integer> numbers = myLottoNumber.getNumbers();
            Arrays.sort(numbers.toArray());
            System.out.println(numbers);
        }
    }
    public List<String> printLottos(){
        List<String> numbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = readLine();
        numbers.add(winningNumber);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        numbers.add(bonusNumber);
        return numbers;
    }

    public void printResult(Result result){
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Money, Integer> counting = result.getCounting();
        for (Map.Entry<Money, Integer> moneyIntegerEntry : counting.entrySet()) {
            System.out.println(moneyIntegerEntry.getKey().getCount()+"개 일치 ("
                    +moneyIntegerEntry.getKey().getDescription()+"원) " +"-"
                    + moneyIntegerEntry.getValue() +"개"
            );
        }
        System.out.println("총 수익률은 "+result.getProfit()+"% 입니다.");
    }
}
