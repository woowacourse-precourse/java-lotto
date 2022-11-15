package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Input {
    Lotto lotto;

    int bonus;
    int buy;
    int count;
    int match = 0;
    int bounsMatch = 0;

    List<List<Integer>> buyLotto = new ArrayList<>();
    Map<Integer , String> compareCount = new HashMap<>();

    public void userNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");


        String Number = Console.readLine();
        List<Integer> Numbers = new ArrayList<>();
        for (String number : Number.split(",")) {
            Numbers.add(Integer.valueOf(number));

        }
        lotto = new Lotto(Numbers);

    }

    public void bonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String Bonus = Console.readLine();


        bonus = Integer.parseInt(Bonus);
    }

    public void userBuy() {
        System.out.println("구입금액을 입력해 주세요.");
        buy = Integer.parseInt(Console.readLine());


    }

    public void userBuyCheck() {

        if (buy % Constant.NUMBER == 0) {
            count = buy / Constant.NUMBER;

            System.out.println(count + "개를 구매했습니다.");

        }


    }

    public void shuffle() {
        for (int i = 0; i < count; i++) {
            buyLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        }
        for (List<Integer> list : buyLotto) {
            Collections.sort(list);
            System.out.println(list);

        }
    }

    public void compare() {

        for (List<Integer> list : buyLotto) {
            for (int i = 0; i < Constant.LENGTH; i++) {
                if (list.contains(lotto.getNumbers().get(i))) {
                    match += 1;
                }

            }
            if (list.contains(bonus)) {
                bounsMatch += 1;
            }
            if(match==6){
                compareCount.put(match , "개 일치 (2,000,000,000원) - " );

                System.out.println(Rank.FIRST.getMatch()+""+compareCount.values());
            }

            if (match == 5 && bounsMatch == 1 ) {
                compareCount.put(match, "개 일치, 보너스 볼 일치 (30,000,000원) - ");

                System.out.println(Rank.SECOND.getMatch()+""+compareCount.values());
            }
            if(match == 5 && bounsMatch == 0){
                compareCount.put(match, "개 일치 (1,500,000원) - ");

                System.out.println(Rank.THIRD.getMatch()+""+compareCount.values());
            }
            if(match == 4 ){
                compareCount.put(match, "개 일치 (50,000원) -  ");

                System.out.println(Rank.FOURTH.getMatch()+""+compareCount.values());
            }
            if(match == 3){
                compareCount.put(match, "개 일치 (5,000원) - ");

                System.out.println(Rank.FIFTH.getMatch()+""+compareCount.values());
            }

            bounsMatch = 0;
            match = 0;


        }

    }






}
