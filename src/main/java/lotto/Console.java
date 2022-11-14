package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        String replacedInput = input.replaceAll("[^0-9]", "");
        if (input != replacedInput) {
            System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            throw new IllegalArgumentException();
        }

        int money = Integer.valueOf(replacedInput);
        System.out.println(money);
        return money;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] strNumbers = readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strNumbers.length; i++) {
            numbers.add(Integer.parseInt(strNumbers[i]));
        }
        return numbers;
    }

    public int inputPlusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int number = Integer.parseInt(readLine());
        return number;
    }

    public void outputIssuedLotto(int count,List<Integer>[] issuedList) {
        System.out.println(count+"개를 구매했습니다.");
        for (List<Integer> lotto : issuedList) {
            System.out.println(lotto);
        }

    }

    public void outputResult(HashMap<Rank,Integer> rankMap, double yield){
        System.out.println("당첨 통계\n" + "---");
        for (Rank rank: Rank.values()) {
            if (rank.getCount()==0) {
                break;
            }

            if (rankMap.get(rank)==null){
                rankMap.put(rank,0);
            }

            int cnt = rankMap.get(rank);
            DecimalFormat decimalFormat = new DecimalFormat("###,###");
            String strMoney = decimalFormat.format(rank.getMoney());
            if (rank.getCount()==5 && rank.getBonus()==1) {
                System.out.println(rank.getCount()+"개 일치, 보너스 볼 일치 ("+strMoney+"원) - "+cnt+"개");
                continue;
            }
            System.out.println(rank.getCount()+"개 일치 ("+strMoney+"원) - "+cnt+"개");
        }
        System.out.println("총 수익률은 "+yield+"%입니다.");

    }
}
