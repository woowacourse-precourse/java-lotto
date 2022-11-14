package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Buyer {
    int purchaseAmount;
    int lottoAmount;

    List<Integer> winningNum;

    public Buyer(){

    }

    public Buyer(int purchaseAmount) {
        amountRange(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }
    private void amountRange(int purchaseAmount){
        if(purchaseAmount%1000 !=0){
            throw new IllegalArgumentException("[ERROR] 입력금액의 단위는 1000입니다.");
        }
    }
    public int lottoAmount(int purchaseAmount){
       return this.lottoAmount = purchaseAmount/1000;
    }
    public void lottoAmountMessage(){
        System.out.println(lottoAmount + "개를 구매하셨습니다.");
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }
    public static void buyMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void winningMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public List<Integer> getWinningNum() {
        winningNum = new ArrayList<>();
        String input = Console.readLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            winningNum.add(Integer.parseInt(st.nextToken()));
        }
        validate(winningNum);
        validateNum(winningNum);
        return winningNum;
    }
    private void validate(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 이고 , 로 구분합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateNum(List<Integer> winningNum) {
        if(winningNum.size() != winningNum.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않습니다.");
        }
    }

}
