package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Code.LottoCode;

import java.util.ArrayList;
import java.util.List;

import static lotto.Code.ErrorCode.*;
import static lotto.Code.LottoCode.*;
import static lotto.Code.PrintCode.*;
import static lotto.Lotto.*;

public class Application {

    public static void main(String[] args) {

        // phase 1) 사용자로부터 구매 금액을 입력받기
        System.out.println(GET_MONEY);
        int payedMoney = getSingleInput();
        validateMoneyCanDivideBy1000(payedMoney);

        // phase 2) 구매 개수 & 발행한 로또 번호를 출력하기
        int lottoCount = payedMoney/1000;
        System.out.println("\n" + lottoCount + PRINT_LOTTO_COUNT);
        List<Lotto> candidateLotto = printSeveralLotto(lottoCount);

        // phase 3) 당첨 번호 입력받기
        System.out.println("\n" + GET_WINNING_LOTTO);
        Lotto winningLotto = new Lotto(getSixInput());
        validateNotDuplicate(winningLotto);
        validateNumberVariation(winningLotto);

        // phase 4) 보너스 번호 입력받기
        System.out.println("\n" + GET_BONUS_NUMBER);
        int bonusNumber = getSingleInput();
        validateOneTo45(List.of(bonusNumber));

        // phase 5) 당첨 통계 출력하기
        List<Integer> score = countScoreCandidate(candidateLotto, winningLotto, bonusNumber);
        printWinningResult(score);


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
    public static void validateOneTo45(List<Integer> numbers){
        for (int index = 0; index < 6; index++){
            int tmpNum = numbers.get(index);
            if (tmpNum >= 1 || tmpNum <= 45)
                throw new IllegalArgumentException(String.valueOf(NUMBER_VARIATION));
        }
    }

    public static List<Lotto> printSeveralLotto(int lottoCount){
        List<Lotto> candidateLotto = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++){
            Lotto tmpLotto = createLotto();

            candidateLotto.add(tmpLotto);
            System.out.println(tmpLotto);
        }
        return candidateLotto;
    }
    public static void printWinningResult(List<Integer> score){
        List<LottoCode> lottoCode = List.of(CORRECT_3, CORRECT_4, CORRECT_5,
                                            CORRECT_5_WITH_BONUS, CORRECT_6);
        for (int index = 0; index<5; index++){
            System.out.println(lottoCode.get(index).toString() + score.get(index) + "개");
        }
    }

    public static List<Integer> countScoreCandidate(List<Lotto> candidateLotto,
                                         Lotto winningLotto,
                                         int bonusNumber){
        List<Integer> score = List.of(0,0,0,0,0); // 3, 4, 5, 5+bonus, 6

        for (Lotto candidate : candidateLotto){
            int candiScore = countWinningLotto(winningLotto, candidate);
            if (candiScore == 3) score.set(0,score.get(0)+1);
            if (candiScore == 4) score.set(1,score.get(1)+1);
            if (candiScore == 5) {
                int indexFor5 = checkBonusNumber(bonusNumber, candidate);
                score.set(indexFor5,score.get(indexFor5)+1);
            }
            if (candiScore == 6) score.set(3,score.get(3)+1);
        }
        return score;
    }


}
