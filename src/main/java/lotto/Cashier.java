package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cashier {
    // 입력 금액:purchseAmount, 금액에 따른 티켓수:lotteryAmount
    private int purchaseAmount = 0;
    private int lotteryAmount = purchaseAmount / Constants.WON;

    // getter & setter
    private void setLotteryAmount(int lotteryAmount) {
        this.lotteryAmount = lotteryAmount;
    }
    private void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
    public int getPurchaseAmount() { return purchaseAmount; }
    public int getLotteryAmount() {
        return lotteryAmount;
    }

    // get user's cash
    public void setUserCash() throws IllegalArgumentException{
        try {
            String input = getUserInput();
            validateInput(input);
            setLotteryAmount(Integer.parseInt(input));
        }catch (Exception e){
            throw e;
        }
    }
    // get user's input
    public String getUserInput(){
        String input = Console.readLine();
        return input;
    }
    // 사용자가 ",000" 단위로 입력하였을 때 : ^(?:[0-9]{1,3}[,]){0,3}[0]{3}$
    // 사용자가 "000" 단위로 입력하였을 때 : ^(?:[1-9]{0,}[0-9]{1,})[0]{3}$
    public String validateInput(String input) {
        Pattern pass = Pattern.compile("^(?:[0-9]{1,3}[,]){0,3}[0]{3}$|^(?:[1-9]{0,}[0-9]{1,})[0]{3}$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요");
        }
        input = input.replaceAll(",", "");
        return input;
    }
}
