package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runLottoApp();
    }
    public static void runLottoApp(){

        int lottoCount = howMuchLottoBuy();

        List<Lotto> lotto = issueLotto(lottoCount);

        List<Integer> winningNumber = winningNumberInput();
        Integer bonusNumber = bonusNumberInput();
    }
    public static int howMuchLottoBuy(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        moneyErrorCheck(money);

        return Integer.parseInt(money)/1000;
    }
    public static void moneyErrorCheck(String money){
        for(int i = 0 ; i < money.length() ;i++){
            if(!Character.isDigit(money.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
            }
        }
        if((Integer.parseInt(money) % 1000) != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야합니다.");
    }
    public static List<Lotto> issueLotto(int lottoCount){
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        List<Lotto> lotto = new ArrayList<>();

        for(int i = 0 ; i < lottoCount ; i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottoNumber.sort(Comparator.naturalOrder());
            System.out.println(lottoNumber);
            lotto.add(new Lotto(lottoNumber));
        }

        return lotto;
    }
    public static List<Integer> winningNumberInput(){
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String number = readLine();
        List<String> numbers = Arrays.asList(number.split(","));

        List<Integer> winningNumber = new ArrayList<>();

        for(int i = 0 ;  i < numbers.size() ;i++)
            winningNumber.add(Integer.valueOf(numbers.get(i)));

        return winningNumber;
    }

    public static Integer bonusNumberInput(){
        System.out.println("\n보너스 번호를 입력해 주세요.");

        String number = readLine();

        Integer bonusNumber = Integer.valueOf(number);

        return bonusNumber;
    }
}
