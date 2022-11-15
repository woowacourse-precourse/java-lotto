package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    static int ownMoney(){
        int own_money =0;
        String inputMoney;
        inputMoney = Console.readLine();
        if (inputMoney.isBlank()) throw new IllegalArgumentException("[ERROR] 로또를 구매 하시려면 돈을 입력해 주세요.");
        System.out.println("구입금액을 입력해 주세요");
        try{
            own_money = Integer.parseInt(inputMoney);
        }catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요");
        }
        if(own_money <=0){
            throw new IllegalArgumentException("[ERROR] 금액이 0원 이하 입니다.");
        }
        return own_money;
    }
    static int howManyLotto(int own_money){
        if(own_money % 1000 !=0) throw new IllegalArgumentException("[ERROR] 1000단위로 나누어 떨어져야합니다.");
        int lottosCount = own_money / 1000;
        System.out.println(lottosCount + "개를 구매했습니다.");
        return lottosCount;
    }
    static List<Integer> createLottoNumber(){
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    static List<List<Integer>> buyLottery(int lottosCount){
        List<List<Integer>> ownLottos = new ArrayList<>();
        List<Integer> lottos;
        for (int i = 0;i<lottosCount;i++) {
            lottos = createLottoNumber();
            ownLottos.add(lottos);
            System.out.println(lottos);
        }
        return ownLottos;
    }
    static List<Integer> checkWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinNum = Console.readLine();
        List<Integer> winNumbers;
        try {
            List<String> winNumbersString = Arrays.asList(inputWinNum.split(","));
            winNumbers = winNumbersString.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자여야 합니다.");
        }
        return winNumbers;
    }
    static int inputBonus(){
        String input_num= Console.readLine();
        int bonus;
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonus = Integer.parseInt(input_num);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개의 숫자만 입력하셔야 합니다.");
        }
        return bonus;
    }

    public static void run() {
        // TODO: 프로그램 구현
        int money;
        int lottosCount;
        List<List<Integer>> lotto_nums;
        List<Integer> winningNumber;
        int bonus;

        try {
            money = ownMoney();
            lottosCount = howManyLotto(money);
            lotto_nums = buyLottery(lottosCount);
            winningNumber = checkWinningNumber();
            Lotto lotto = new Lotto(winningNumber);
            bonus = inputBonus();
            CheckNumber.checkBonusWinnerNumber(lotto,bonus);
            CheckNumber.viewResult(lotto, lotto_nums,bonus,money);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}