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
        int LottoCount = purchaseInput(); // 8000

        System.out.println("\n" + LottoCount + "개를 구매했습니다.");
        MakeLotto(LottoCount);

        System.out.println("당첨 번호를 입력해 주세요");
        List<Integer> LottoNumbers = WinningNumber(); // [1,2,3,4,5,6]
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int BonusNum = BonusNumber();
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        // Lotto lotto = new Lotto(LottoNumbers);

    }

    private static int BonusNumber() {
        int Bonus = Integer.parseInt(Console.readLine());
        if (Bonus < 0 || Bonus > 46){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return Bonus;
    }

    public static List<Integer> WinningNumber(){
        String WinningNum = Console.readLine();
        List<String> SplitNum = List.of(WinningNum.split(","));
        List<Integer> IntSplitNum = SplitNum.stream()
                                            .map(Integer::parseInt)
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
