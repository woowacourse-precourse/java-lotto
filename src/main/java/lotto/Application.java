package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        int payedMoney = getPurchaseAmount();

        // phase 2) 구매 개수 & 발행한 로또 번호를 출력하기
        List<Lotto> candidateLotto = printCountAndLottoNumber(payedMoney);

        // phase 3) 당첨 번호 입력받기
        Lotto winningLotto = getWinningNumber();

        // phase 4) 보너스 번호 입력받기
        int bonusNumber = getBonusNumber();

        // phase 5) 당첨 통계 출력하기
        List<Integer> score = countScoreCandidate(candidateLotto, winningLotto, bonusNumber);
        int totalPrize = printWinningResult(score);
        printYield(totalPrize, payedMoney);

    }

    public static int getSingleInput() {
        String singleInput = Console.readLine();
        try {
            return Integer.parseInt(singleInput);
        } catch (IllegalArgumentException e){
            System.out.println(NO_INTEGER.getMessage());
        }
        return 0;
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
        if (money%1000 != 0){
            System.out.println(NO_DIVIDE_BY_1000.getMessage());
            throw new IllegalArgumentException();
        }
    }
    public static void validateOneTo45(List<Integer> numbers){
        for (int index = 0; index < 6; index++){
            int tmpNum = numbers.get(index);
            if (tmpNum >= 1 || tmpNum <= 45)
                throw new IllegalArgumentException(NUMBER_VARIATION.getMessage());
        }
    }

    public static List<Lotto> printSeveralLotto(int lottoCount){
        List<Lotto> candidateLotto = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++){
            Lotto tmpLotto = createLotto();
            candidateLotto.add(tmpLotto);
            printLotto(tmpLotto);
        }
        return candidateLotto;
    }
    public static int printWinningResult(List<Integer> score){
        List<LottoCode> lottoCode = List.of(CORRECT_3, CORRECT_4, CORRECT_5,
                                            CORRECT_5_WITH_BONUS, CORRECT_6);
        int totalPrize = 0;
        for (int index = 0; index<5; index++){
            System.out.println(lottoCode.get(index).getMessage().toString() + score.get(index) + "개");
            totalPrize += score.get(index) * lottoCode.get(index).getPrize();
        }
        return totalPrize;
    }
    public static void printYield(int totalPrize, int payedMoney){
        System.out.println("총 수익률은 " + String.format("%.2f", totalPrize/payedMoney*100) + "%입니다.");
    }
    public static List<Integer> countScoreCandidate(List<Lotto> candidateLotto,
                                         Lotto winningLotto,
                                         int bonusNumber){
        ArrayList<Integer> score = new ArrayList<>(List.of(0,0,0,0,0)); // 3, 4, 5, 5+bonus, 6

        for (Lotto candidate : candidateLotto){
            int candiScore = countWinningLotto(winningLotto, candidate);
            if (candiScore == 3) {
                int newScore = score.get(0) + 1;
                score.set(0, newScore);
            }
            if (candiScore == 4) score.set(1, score.get(1)+1);
            if (candiScore == 5) {
                int indexFor5 = checkBonusNumber(bonusNumber, candidate);
                score.set(indexFor5,score.get(indexFor5)+1);
            }
            if (candiScore == 6) score.set(3,score.get(3)+1);
        }
        return score;
    }

    public static int getPurchaseAmount(){
        System.out.println(GET_MONEY.getMessage());
        int payedMoney = getSingleInput();
        validateMoneyCanDivideBy1000(payedMoney);
        return payedMoney;
    }
    public static List<Lotto> printCountAndLottoNumber(int payedMoney){
        int lottoCount = payedMoney/1000;
        System.out.println("\n" + lottoCount + PRINT_LOTTO_COUNT.getMessage());
        return printSeveralLotto(lottoCount);
    }
    public static Lotto getWinningNumber(){
        System.out.println("\n" + GET_WINNING_LOTTO.getMessage());
        Lotto winningLotto = new Lotto(getSixInput());
        validateNumberVariation(winningLotto);
        return winningLotto;
    }
    public static int getBonusNumber(){
        System.out.println("\n" + GET_BONUS_NUMBER.getMessage());
        int bonusNumber = getSingleInput();
        validateOneTo45(List.of(bonusNumber));
        return bonusNumber;
    }
    public static void printLottoStatistics(List<Lotto> candidateLotto,
                                            Lotto winningLotto,
                                            int bonusNumber,
                                            int payedMoney){
        List<Integer> score = countScoreCandidate(candidateLotto, winningLotto, bonusNumber);
        int totalPrize = printWinningResult(score);
        printYield(totalPrize, payedMoney);
    }
}
