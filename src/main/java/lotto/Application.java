package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class Application {

    static List<List<Integer>> lotteNumbers = new ArrayList<>();
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int LottoCount = purchaseInput();

        System.out.println("\n" + LottoCount + "개를 구매했습니다.");
        MakeLotto(LottoCount);

        System.out.println("당첨 번호를 입력해 주세요");
        List<Integer> LottoNumbers = WinningNumber();
        System.out.println("보너스 번호를 입력해 주세요.");

    }

    public static List<Integer> WinningNumber(){
        String WinningNum = Console.readLine();
        List<String> SplitNum = List.of(WinningNum.split(","));
        List<Integer> IntSplitNum = SplitNum.stream()
                                            .map(s -> Integer.parseInt(s))
                                            .collect(Collectors.toList());
        return IntSplitNum;


    }

    public static List<Integer> RandomUniqueNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void MakeLotto(int LottoCount) {
        for (int i = 0; i < LottoCount; i++) {
            List<Integer> List = RandomUniqueNumbers();
            Collections.sort(List);
            lotteNumbers.add(List);
            System.out.println(List);

        }
    }

    public static int purchaseInput() {

        int purchase = Integer.parseInt(Console.readLine());
        if (purchase < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000보다 낮습니다.");
        }
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 단위가 1000단위가 아닙니다.");
        }
        return purchase / 1000;

    }


}
