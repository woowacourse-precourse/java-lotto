package lotto.IO;

import lotto.Domain.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashIOHandler extends IOHandler {
    // 입력 금액:purchseAmount, 금액에 따른 티켓수:lotteryAmount
    private int purchaseAmount = 0;
    private int lottoAmount = 0;

    // getter & setter
    public int getPurchaseAmount() { return purchaseAmount; }
    public int getLotteryAmount() {
        return lottoAmount;
    }

    // get user's cash
    public void setUserCash(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = getUserInput();
        validateInput(input);
        input = input.replaceAll(",", "");
        this.purchaseAmount = Integer.parseInt(input);
        convertPurchaseAmount(input);
    }

    // get lotteryAmount from purchaseAmount
    public void convertPurchaseAmount(String purchaseAmount){
        this.lottoAmount = ((Integer.parseInt(purchaseAmount))/ Constants.WON);
    }

    @Override
    // 사용자가 ",000" 단위로 입력하였을 때 : [0-9] 0~3번 반복 이후 마지막에 [,000] 오는지 확인
    // 사용자가 "000" 단위로 입력하였을 때 : [1-9] 1번 이상 반복 이후 마지막에 000 오는지 확인
    public void validateInput(String input) {
        Pattern pass = Pattern.compile("^(?:[0-9]{1,3},){0,3}0{3}$|^[0-9]*0{3}$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요");
        }
    }
}
