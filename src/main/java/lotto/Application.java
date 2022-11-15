package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import controller.LotteryController;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LotteryController.create();
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        long parseInt = Long.parseLong(money);
        if (parseInt % 1000 != 0) throw new IllegalArgumentException("[ERROR]");

        long lotteryAmount = parseInt / 1000;
        List<List<Integer>> lotteryGroup = new ArrayList<>();

        for (int i = 1; i <= lotteryAmount; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(list);
            System.out.println(list);
            lotteryGroup.add(list);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String lotteryNumber = Console.readLine();
        List<Integer> lottery = Arrays.stream(lotteryNumber.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        if(lottery.size() != lottery.stream().distinct().count()) throw new IllegalArgumentException("[ERROR]");

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계\n" +
                "---");
        int three = 0;
        int four = 0;
        int five = 0;
        int fivePlus = 0;
        int six = 0;
        for (List<Integer> list : lotteryGroup) {
            long count = list.stream().filter(num -> lottery.stream().anyMatch(Predicate.isEqual(num))).count();
            if (count == 3) three++;
            if (count == 4) four++;
            if (count == 5 && list.contains(bonusNum)) fivePlus++;
            if (count == 5 && !list.contains(bonusNum)) five++;
            if (count == 6) six++;
        }
        long total = three * 5_000 + four * 50_000 + five * 1_500_000 + fivePlus * 30_000_000 + six * 2_000_000_000;
        System.out.println("총 당첨 금액 : "+ total);
        double surplusRate = ((double) total / parseInt) * 100;
//        double surplusRate = (total / parseInt) * 100;
        System.out.println("3개 일치 (5,000원) - "+ three+"개\n" +
                "4개 일치 (50,000원) - " + four + "개\n" +
                "5개 일치 (1,500,000원) - " +  five +"개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + fivePlus +  "개\n" +
                "6개 일치 (2,000,000,000원) - "+ six+"개\n" +
                "총 수익률은 " + surplusRate + "%입니다");
    }
    // 신경써줘야할것 : int인지 long인지.
    // 보너스 숫자 중복되지 않도록. // 범위 45 숫자 사이에 있도록 // 소수점 2째자리 반올림
}
