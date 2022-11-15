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
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 오류");
        }
        int money = Integer.valueOf(replacedInput);
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1,000원 단위가 아닙니다.");
            throw new IllegalArgumentException();
        }
        if (money < 0  ) {
            System.out.println("[ERROR] 양수가 아닙니다.");
            throw new IllegalArgumentException();
        }
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
        int number = 0;
        try{
            number = Integer.parseInt(readLine());

        } catch (NumberFormatException e){
            System.out.println("[ERROR] 보너스 번호는 정수형이어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수형이어야 합니다.");
        }
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
//        DecimalFormat yieldFormat = new DecimalFormat("###,###.#");
//        System.out.println("총 수익률은 "+yieldFormat.format(yield)+"%입니다.");
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", yield));
    }
}
