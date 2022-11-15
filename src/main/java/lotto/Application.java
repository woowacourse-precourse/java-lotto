
package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static Integer lottoCount;
    private static Lotto winningLotto;
    private static Integer bonusBall;
    private static List<Lotto> lottos;


    private static void printPickedLottos(){
        System.out.println(lottoCount + "개를 구매했습니다.");
        for(Lotto lotto : lottos)
            System.out.println(lotto.getNumbers().toString());
    }

    private static List<Integer> pickLottoNums(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(Randoms.pickUniqueNumbersInRange(1,46,6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static void buyLottos(){
        lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++){
            Lotto lotto = new Lotto(pickLottoNums());
            lottos.add(lotto);
        }
        printPickedLottos();
    }

    private static void getUserInput(){
        lottoCount = countLotto(Console.readLine());
        winningLotto = getWinningLotto(Console.readLine());
        bonusBall = getBonusBall(Console.readLine());
    }

    private static void checkIllegalNum(Integer num){
        if(num > 45 || num < 1)
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
    }

    public static Integer getBonusBall(String input){
        Integer num = Integer.parseInt(input);
        checkIllegalNum(num);
        if(winningLotto.getNumbers().contains(num))
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
        return num;
    }

    public static Lotto getWinningLotto(String input){
        List<Integer> numbers = new ArrayList<>();
        for(String s : input.split(",")){
            Integer num = Integer.parseInt(s);
            checkIllegalNum(num);
            numbers.add(num);
        }
        System.out.println(numbers.toString());
        return new Lotto(numbers);
    }

    public static Integer countLotto(String input){
        Integer money = Integer.parseInt(input);
        if(money%1000 != 0)
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_MONEY_NOT1000_EXCEPTION.getMessage());
        return money/1000;
    }

    public static void main(String[] args) {
        getUserInput();

        buyLottos();


    }
}

