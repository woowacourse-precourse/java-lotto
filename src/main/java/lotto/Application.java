package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Code.ErrorCode.*;
import static lotto.Code.PrintCode.*;
import static lotto.Lotto.*;

public class Application {

    public static void main(String[] args) {

        System.out.println(GET_MONEY);
        int payedMoney = getSingleInput();
        validateMoneyCanDivideBy1000(payedMoney);

        int lottoCount = payedMoney/1000;
        System.out.println("\n" + lottoCount + PRINT_LOTTO_COUNT);
        List<List<Integer>> candidateLotto = printSeveralLotto(lottoCount);

        System.out.println("\n" + GET_WINNING_LOTTO);
        Lotto winningLotto = new Lotto(getSixInput());
        validateNotDuplicate(winningLotto);
        validateNumberVariation(winningLotto);


    }

    public static int getSingleInput() {
        String singleInput = Console.readLine();
        return Integer.parseInt(singleInput);
    }
    public static List<Integer> getSixInput() {
        List<Integer> winningLotto = new ArrayList<>();

        String sixInput = Console.readLine();
        String[] sixInputList = sixInput.split(",");

        for (String tmpInt : sixInputList){
            winningLotto.add(Integer.valueOf(tmpInt));
        }
        return winningLotto;
    }

    public static void validateMoneyCanDivideBy1000(int money){
        if (money/1000 != 0)
            throw new IllegalArgumentException(String.valueOf(NO_DIVIDE_BY_1000));
    }

    public static List<List<Integer>> printSeveralLotto(int lottoCount){
        List<List<Integer>> candidateLotto = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++){
            List<Integer> tmpLotto = createLotto();
            candidateLotto.add(tmpLotto);
            System.out.println(tmpLotto);
        }
        return candidateLotto;
    }



}
