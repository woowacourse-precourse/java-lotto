package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();
        List<List<Integer>> lottoList = buyLotto(money);
        Map<String, List<Integer>> luckyNumMap = digitInput();
        Lotto mylotto = new Lotto(luckyNumMap.get("luckyNums"));
    }


    public static Map<String, List<Integer>> digitInput(){
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> bonus = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요");
        List<Integer> luckyNums = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("보너스 번호를 입력해 주세요");
        Integer bonusNum = Integer.parseInt(Console.readLine());
        bonus.add(bonusNum);
        result.put("luckyNums",luckyNums);
        result.put("bonus",bonus);
        return result;
    }

    public static List<List<Integer>> buyLotto(int purchaseMoney){
        return digitPick(purchaseMoney/1000);
    }
    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요");
        int purchaseMoney = Integer.parseInt(Console.readLine());
        int purchaseAmount = purchaseMoney / 1000;
        if (purchaseMoney%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력하십시오.");
        }
        System.out.println(purchaseAmount+"개를 구매했습니다.");
        return purchaseMoney;
    }

    private static List<List<Integer>> digitPick(int purchaseAmount){
        List<List<Integer>> lottoNums = new ArrayList<>();
        while (lottoNums.size()!=purchaseAmount){
            List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNum.sort(Comparator.naturalOrder());
            lottoNums.add(lottoNum);
            System.out.println(lottoNum);
        }
        return lottoNums;
    }
}
