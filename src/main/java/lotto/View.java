package lotto;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class View {

    public void printStart(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printError(String errMsg){
        System.out.println(Const.ERROR + errMsg);
    }

    public void printUserLottos(User user){
        System.out.println(user.getMyLottoNumbers().size()+"개를 구매했습니다.");
        List<Lotto> myLottoNumbers = user.getMyLottoNumbers();
        for (Lotto myLottoNumber : myLottoNumbers) {
            List<Integer> numbers = myLottoNumber.getNumbers();
            List<Integer> nums = new ArrayList<>(numbers);
            Collections.sort(nums);
            System.out.println(nums);
        }
    }
    public void printLottos(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void printBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(Result result){
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Money, Integer> counting = result.getCounting();
        for (Map.Entry<Money, Integer> moneyEntry : counting.entrySet()) {
            System.out.println(makePhrases(moneyEntry.getKey(),moneyEntry.getValue()));
        }
        System.out.println("총 수익률은 "+result.getProfit()+"%입니다.");
    }

    private String makePhrases(Money money, Integer quantity){
        Integer count = money.getCount();
        Integer reward = money.getDescription();
        String output = count.toString()+"개 일치 ";
        if (count == 7 ){
            output = "5개 일치, 보너스 볼 일치 ";
        }
        output += "("+getMoneyString(reward)+"원) - ";
        output += quantity+"개";
        return output;
    }
    private String getMoneyString(Integer reward){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(reward);
    }
}
