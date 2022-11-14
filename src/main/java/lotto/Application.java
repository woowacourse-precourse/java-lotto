package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.util.Arrays.asList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        int lottoQuantity = purchaseAmount/1000;
        try {
            if(purchaseAmount%1000!=0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }

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

        for (Lotto lotto:mylottos) {
            result[lotto.compareLotto(winningNumber,bonusNumber).getValue()]++;
        }
    }
}
