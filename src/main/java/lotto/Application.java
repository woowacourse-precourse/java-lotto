package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        int lottoQuantity = purchaseAmount/1000;

        if(purchaseAmount%1000!=0)
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");


        LottoGenerator generator = new LottoGenerator();
        Lotto[] mylottos = generator.buyLottos(lottoQuantity);

        System.out.println(lottoQuantity+"개를 구매했습니다.");
        for (Lotto lotto:mylottos) {
            System.out.println(lotto.toString());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        int[] winningNumber_= Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> winningNumber = Arrays.stream(winningNumber_).boxed().collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        int[] result = {0,0,0,0,0,0};
        int earnings = 0;
        for (Lotto lotto:mylottos) {
            당첨 rank = lotto.compareLotto(winningNumber,bonusNumber);
            if(rank == null) continue;
            result[rank.getValue()]++;
            earnings+= rank.getPrize();
        }
        int earningsRate = earnings/purchaseAmount*100;

        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=0;i<5;i++){
            System.out.println(당첨.valueOfValue(i).getResult().replace("_",",")+" - "+result[i]+"개");
        }
        System.out.println("총 수익률은 "+earningsRate+"%입니다.");


    }
}