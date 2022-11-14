package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;


public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        // TODO: 로또 프로그램 구현
        System.out.println("구입 금액을 입력해주세요.");
        String purchaseAmount_ = Console.readLine();

        try {
            if (!isNumeric(purchaseAmount_))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "숫자만 입력해야합니다.");
            return;
        }

        int purchaseAmount = Integer.parseInt(purchaseAmount_);
        int lottoQuantity = purchaseAmount / 1000;

        try {
            if (purchaseAmount % 1000 != 0)
                throw new IllegalArgumentException();

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "구입 금액은 1000원 단위여야 합니다.");
        }


        LottoGenerator generator = new LottoGenerator();
        Lotto[] mylottos = generator.buyLottos(lottoQuantity);

        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : mylottos) {
            System.out.println(lotto.toString());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        int[] winningNumber_ = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> winningNumber = Arrays.stream(winningNumber_).boxed().collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        int[] result = {0, 0, 0, 0, 0, 0};
        int earnings = 0;
        for (Lotto lotto : mylottos) {
            Statistics rank = lotto.compareLotto(winningNumber, bonusNumber);
            if (rank == null) continue;
            result[rank.getValue()]++;
            earnings += rank.getPrize();
        }
        double earningsRate = earnings / (double) purchaseAmount * 100;

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 4; i >= 0; i--) {
            System.out.println(Statistics.valueOfValue(i).getResult().replace("_", ",") + " - " + result[i] + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", earningsRate) + "%입니다.");


    }

    public static boolean isNumeric(String purchaseAmount) {
        for (int i = 0; i < purchaseAmount.length(); i++) {
            if (!Character.isDigit(purchaseAmount.charAt(i)))
                return false;
        }
        return true;
    }

}