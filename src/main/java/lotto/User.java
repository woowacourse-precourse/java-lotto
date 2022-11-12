package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private final int count = 0;

    public List<List<Integer>> Count(int money){
        int count = money/1000;
        CheckMoney(money);
        List<List<Integer>> AutoLotto = new ArrayList<>();
        for(int i = 0;i<count;i++){
            AutoLotto.add(i,Randoms.pickUniqueNumbersInRange(1, 45, 7));
        }
        return AutoLotto;
    }

    private void CheckMoney(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public void PrintNumber(List<List<Integer>> AutoLotto){
        System.out.println(AutoLotto.size() + "개를 구매했습니다.");
        for(List<Integer> j : AutoLotto){
            System.out.println(j);
        }
    }

    public List<Integer> UserLotto(){
        System.out.println("당첨번호를 입력해주세요");
        String[] num = Console.readLine().split(",");
        List<Integer> UserLotto = StringToNum(num);
        Lotto lotto = new Lotto(UserLotto);
        StringToBonusNum(UserLotto);
        return UserLotto;
    }

    private List<Integer> StringToNum(String[] num){
        List<Integer> UserLotto = new ArrayList<>();
        for(int i = 0;i<num.length;i++){
            UserLotto.add(i,Integer.parseInt(num[i]));
        }
        return UserLotto;
    }

    private void StringToBonusNum(List<Integer> UserLotto){
        System.out.println("보너스번호를 입력해주세요");
        UserLotto.add(6,Integer.parseInt(Console.readLine()));
    }

    public List<Integer> CheckResult(List<List<Integer>> AutoLotto,List<Integer> UserLotto){
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<AutoLotto.size();i++){
           count = Check(AutoLotto.get(i),UserLotto);
           if(count ==5 && (AutoLotto.get(i).get(6).equals(UserLotto.get(6)))){
               count = 100;
           }
           result.add(count);
        }
        return result;
    }

    private int Check(List<Integer>AutoPart,List<Integer> UserLotto){
        int count = 0;
        for(int i = 0;i<UserLotto.size()-1;i++){
            if(AutoPart.indexOf(UserLotto.get(i)) != -1){
                count += 1;
            }
        }

        return count;
    }




}
