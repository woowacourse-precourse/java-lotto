package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    //region 상수
    private static final String COMMA = ",";
    private static final String REGEX = "[0-9]+";
    private static final int lottoPrice = 1000;
    //endregion

    //region 변수
    public static int lottoNumber;
    private static int bonusNumber;
    private static Lotto winning;
    private static List<Lotto> lottos;
    private static WinningStats winningStats;
    //endregion

    //region 생성자
    public static void main(String[] args) {
        try {
            salesLotto();
            getWinning();
            getBonusNumber();
            getWinningStats();
            getEarningRate();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }
    }
    //endregion

    //region 메서드
    public static void salesLotto(){
        System.out.println(PrintMessage.purchasingAmount);
        String userInput = getUserInputData();

        salesValidate(userInput);
        getPurchaseAmount(userInput);
        purchaseLotto();
    }

    private static void getWinning() {
        System.out.println(PrintMessage.winning);
        String userInput = getUserInputData();

        winningValidate(userInput);
        castWinningToLotto(userInput);
    }


    private static void getBonusNumber() {
        System.out.println(PrintMessage.bonus);
        String userInput = getUserInputData();

        bonusValidate(userInput);
        bonusNumber = Integer.parseInt(userInput);
    }

    private static void getWinningStats() {
        winningStats = new WinningStats(lottos, winning, bonusNumber);
        winningStats.printWinningStats();
    }

    private static void getEarningRate() {
        winningStats.calculateEarningRate(lottoNumber * lottoPrice);
        winningStats.printEarningRate();
    }


    public static void bonusValidate(String userInput) {
        checkOnlyNumber(userInput);
        checkNumberSize(userInput);
        checkSameNumber(userInput);
    }

    private static void checkSameNumber(String userInput) {
        int num = Integer.parseInt(userInput);

        if(winning.checkContainNumber(num))
            Error.error(Error.errMsg_ExistSameNumber);
    }

    private static void checkNumberSize(String userInput) {
        int num = Integer.parseInt(userInput);

        if(num < 1)
            Error.error(Error.errMsg_WrongLottoNumber);

        if(num > 45)
            Error.error(Error.errMsg_WrongLottoNumber);
    }

    private static void winningValidate(String userInput) {
        List<String> commaSplits = splitString(userInput);
        for(String commaSplit : commaSplits){
            checkOnlyNumber(commaSplit);
        }
    }

    private static void castWinningToLotto(String str){
        List<String> commaSplits = splitString(str);
        List<Integer> winningNumber = new ArrayList<>();

        for(String commaSplit : commaSplits){
            winningNumber.add(Integer.valueOf(commaSplit));
        }

        winning = new Lotto(winningNumber);
    }

    private static List<String> splitString(String str){
        return Arrays.asList(str.split(COMMA));
    }

    public static String getUserInputData(){
        return Console.readLine();
    }


    public static void getPurchaseAmount(String userInput){
        int userPay = Integer.parseInt(userInput);
        lottoNumber = userPay / lottoPrice;
    }

    private static void purchaseLotto() {
        lottos = Lotto.purchaseLotto(lottoNumber);
    }

    public static void salesValidate(String userInput) {
        checkOnlyNumber(userInput);
        checkPrice(userInput);
    }

    private static void checkPrice(String userInput) {
        int userPay = Integer.parseInt(userInput);

        if(userPay % lottoPrice != 0)
            Error.error(Error.errMsg_WrongPurchaseAmount);
    }

    public static void checkOnlyNumber(String str){
        if(!str.matches(REGEX))
            Error.error(Error.errMsg_ExistNotNumber);
    }
    //endregion
}
