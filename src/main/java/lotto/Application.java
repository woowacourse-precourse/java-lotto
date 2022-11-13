package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Compare;
import lotto.domain.Lotto;
import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        inputPrint();
        String inputMoney = Console.readLine();
        int lottoCount = Lotto.calculate(inputMoney);
        countPrint(lottoCount);

        List<List<Integer>> allLotto = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++){
            List <Integer> numbers = new ArrayList<>();
            Lotto lotto = new Lotto(numbers);
            allLotto.add(Lotto.allNumbers);
        }

        disableWarning();

        numbersPrint();
        String inputNumbers = Console.readLine();
        Winning.addWinning(inputNumbers);

        bonusPrint();
        String inputBonus = Console.readLine();
        Winning.addBonus(inputBonus);

        Compare compare = new Compare();
        for(int i = 0; i < allLotto.size(); i++){
            compare.matchCount(allLotto.get(i),Winning.numbers);
            compare.matchBonus(allLotto.get(i), Winning.numbers);
        }
    }

    public static void inputPrint(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void countPrint(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void numbersPrint(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusPrint(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

}