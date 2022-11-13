package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashIOHandler extends IOHandler {
    // 입력 금액:purchseAmount, 금액에 따른 티켓수:lotteryAmount
    private int purchaseAmount = 0;
    private int lotteryAmount = 0;

    // getter & setter
    private void setLotteryAmount(int lotteryAmount) { this.lotteryAmount = lotteryAmount; }
    private void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
    public int getPurchaseAmount() { return purchaseAmount; }
    public int getLotteryAmount() {
        return lotteryAmount;
    }

    // get user's cash
    public void setUserCash() throws IllegalArgumentException{
        String input = getUserInput();
        input = validateInput(input);
        setPurchaseAmount(Integer.parseInt(input));
        convertPurchaseAmount(input);
    }

    // get lotteryAmount from purchaseAmount
    public void convertPurchaseAmount(String purchaseAmount){
        setLotteryAmount((Integer.parseInt(purchaseAmount))/Constants.WON);
    }

    @Override
    // 사용자가 ",000" 단위로 입력하였을 때 : [0-9] 0~3번 반복 이후 마지막에 [,000] 오는지 확인
    // 사용자가 "000" 단위로 입력하였을 때 : [1-9] 1번 이상 반복 이후 마지막에 000 오는지 확인
    public String validateInput(String input) {
        Pattern pass = Pattern.compile("^(?:[0-9]{1,3}[,]){0,3}[0]{3}$|^(?:[1-9]{0,})[0]{3}$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요");
        }
        input = input.replaceAll(",", "");
        return input;
    }
}
