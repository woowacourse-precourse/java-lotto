package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    //region 상수
    private static final String EMPTY_STRING = "";
    private static final String REGEX = "[0-9]+";
    private static final int lottoPrice = 1000;
    //endregion
    //region 변수
    public static int lottoNumber;
    private static int bonusNumber;
    private static Lotto winningLotto;
    private static List<Lotto> lottos;
    private static WinningStats winningStats;
    //endregion

    //region 생성자
    public static void main(String[] args) {
        try {
            SalesLotto();
            GetWinningNumber();
            GetBonusNumber();
            CheckWinning();
            CheckEarningRate();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }
    }



    //endregion

    //region 메서드

    private static void CheckEarningRate() {
        winningStats.CalculateEarningRate(lottoNumber * lottoPrice);
        winningStats.PrintEarningRate();
    }

    private static void CheckWinning() {
        winningStats = new WinningStats(lottos, winningLotto, bonusNumber);
        winningStats.PrintWinningStats();
    }


    private static void GetBonusNumber() {
        System.out.println(PrintMessage.bonusNumber);
        String userInput = getUserInputData();
        BonusValidate(userInput);
        bonusNumber = Integer.parseInt(userInput);
    }

    private static void BonusValidate(String userInput) {
        String errorMessage = "";

        errorMessage = CheckOnlyNumber(userInput);
        if(!errorMessage.isEmpty())
            Error.error(errorMessage);

        errorMessage = CheckNumberSize(userInput);
        if(!errorMessage.isEmpty())
            Error.error(errorMessage);

        errorMessage = CheckSameNumber(userInput);
        if(!errorMessage.isEmpty())
            Error.error(errorMessage);
    }

    private static String CheckSameNumber(String userInput) {
        int num = Integer.parseInt(userInput);
        if(winningLotto.CheckContainNumber(num))
            return Error.errMsg_ExistSameNumber;

        return EMPTY_STRING;
    }

    private static String CheckNumberSize(String userInput) {
        int num = Integer.parseInt(userInput);
        if(num < 1)
            return Error.errMsg_WrongLottoNumber;

        if(num > 45)
            return Error.errMsg_WrongLottoNumber;

        return EMPTY_STRING;
    }

    private static void GetWinningNumber() {
        System.out.println(PrintMessage.winningNumber);
        String userInput = getUserInputData();
        CastWinningNumberToLotto(userInput);
    }

    private static void CastWinningNumberToLotto(String str){
        List<String> commaSplits = Arrays.asList(str.split(","));
        List<Integer> winningNumber = new ArrayList<>();
        for(String commaSplit : commaSplits){
            String errorMessage = CheckOnlyNumber(commaSplit);
            if(!errorMessage.isEmpty()) {
                Error.error(errorMessage);
                return;
            }
            winningNumber.add(Integer.valueOf(commaSplit));
        }
        winningLotto = new Lotto(winningNumber);
    }


    public static String getUserInputData(){
        String input = Console.readLine();
        return input;
    }

    public static void SalesLotto(){
        System.out.println(PrintMessage.purchasingAmount);
        String userInput = getUserInputData();
        SalesValidate(userInput);

        calculateNumberLotto(userInput);
        lottos = Lotto.PurchaseLotto(lottoNumber);
    }

    public static void calculateNumberLotto(String userInput){
        int userPay = Integer.parseInt(userInput);
        lottoNumber = userPay / lottoPrice;
    }

    private static void SalesValidate(String userInput) {
        String errorMessage;

        errorMessage = CheckOnlyNumber(userInput);
        if(!errorMessage.isEmpty())
            Error.error(errorMessage);

        errorMessage = CheckPrice(userInput);
        if(!errorMessage.isEmpty())
            Error.error(errorMessage);
    }

    private static String CheckPrice(String userInput) {
        int userPay = Integer.parseInt(userInput);

        if(userPay % lottoPrice != 0)
            return Error.errMsg_WrongPurchaseAmount;

        return EMPTY_STRING;
    }


    public static String CheckOnlyNumber(String str){
        if(!str.matches(REGEX))
            return Error.errMsg_ExistNotNumber;

        return EMPTY_STRING;
    }
    //endregion
}
