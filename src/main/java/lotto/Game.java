package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Validation.*;

public class Game {
    private static List<Lotto> randomLottos;
    private static Lotto winningLotto;
    private static int bonusNumber;

    public void gameStart(){
        // 구매 금액 입력 및 타당성 검증
        String money = inputString("구입금액을 입력해 주세요.");
        int convertMoney = moneyValidate(money);

        // 금액만큼 랜덤으로 번호 생성 및 출력
        randomLottos = makeLottosList(money);
        printRandomLottos(randomLottos);

        // 당첨 번호 입력 및 타당성 검증
        winningLotto = inputWinningLotto();

        // 보너스 번호 입력 및 타당성 검증
        bonusNumber = inputBonusNumber();
    }

    private String inputString(String message){
        System.out.println(message);
        String input = Console.readLine();

        return input;
    }

    private List<Lotto> makeLottosList(String money){
        int times = Integer.parseInt(money) / 1000;
        List<Lotto> randomLottos = new ArrayList<>();

        while(times-- > 0){
            Lotto newLotto = makeLotto();
            randomLottos.add(newLotto);
        }

        return randomLottos;
    }

    private Lotto makeLotto(){
        Lotto newLotto = new Lotto(makeNumbers());
        return newLotto;
    }

    private List<Integer> makeNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private void printRandomLottos(List<Lotto> randomLottos) {
        System.out.println(String.format("%d개를 구매했습니다.", randomLottos.size()));

        for(Lotto lotto : randomLottos){
            lotto.printNumbers();
        }
    }

    private Lotto inputWinningLotto(){
        String inputLotto = inputString("당첨 번호를 입력해주세요.");
        Lotto WinningLotto = lottoValidate(inputLotto);

        return WinningLotto;
    }

    private int inputBonusNumber(){
        String inputNumber = inputString("보너스 번호를 입력해 주세요.");
        int bonusNumber = bonusNumberValidate(inputNumber, winningLotto);

        return bonusNumber;
    }
}
