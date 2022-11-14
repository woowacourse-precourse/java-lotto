package lotto.ui;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {
    static List<Integer> ans;

    public int GetMoney(){
        System.out.println("돈을 입력하세요");
        String money = readLine();
        CheckIfInteger(money);
        CheckIf1000(money);
        return Integer.parseInt(money);
    }


    public List<Integer> GetLotto(){
        System.out.println("로또 번호를 입력하세요");
        String lotto = readLine();
//        CheckLottoLength(lotto);
        List<String> stringList = new ArrayList<>(Arrays.asList(lotto.split(",")));
        ans = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        return ans;

    }

    public int GetBonusNumber(){
        System.out.println("보너스 번호를 입력하세요");
        int bonus = Integer.parseInt(readLine());
        if(ans.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 숫자 겹침");

        return bonus;
    }

    public void CheckLottoLength(String lotto){
        if(lotto.length() == 11) return;
        throw new IllegalArgumentException("[ERROR] 유저숫자 입력 - 로또 번호 길이 오류");
    }


    public void CheckIfInteger(String money){
        try{
            int moneyInt = Integer.parseInt(money);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유저숫자 입력 - 문법 오류");
        }
    }

    private void CheckIf1000(String money){
        int moneyInt = Integer.parseInt(money);
        if(moneyInt % 1000 == 0) return;
        throw new IllegalArgumentException("[ERROR] 유저 숫자 입력 - 1000단위로 오류");
    }


}
