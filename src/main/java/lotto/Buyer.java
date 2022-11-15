package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Buyer {
    int purchaseAmount;
    int lottoAmount;
    String inputWinningNum;

    List<Integer> winningNum;
    int bonusNum;
    final int firstBallNum = 1;
    final int LASTBALLNUM = 45;
    final int COUNT = 6;
    List<List<Integer>> totalLotto;
    public static int FIRST ;
    public static int SECOND ;
    public static int THIRD ;
    public static int FOURTH ;
    public static int FIFTH ;
    double YIELD;

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
    public void lottoAmount(int purchaseAmount){
        this.lottoAmount = purchaseAmount / 1000;
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
    public static void bonusMessage(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public String inputWinningNum(){
        inputWinningNum = Console.readLine();
        return inputWinningNum;
    }
    public List<Integer> getWinningNum(String inputWinningNum) {
        winningNum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(inputWinningNum, ",");
        while (st.hasMoreTokens()) {
            winningNum.add(Integer.parseInt(st.nextToken()));
        }
        validate(winningNum);
        validateNum(winningNum);
        validateWinningNumRange(winningNum);
        return this.winningNum;
    }
    private void validate(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 이고 , 로 구분합니다.");
        }
    }

    private void validateNum(List<Integer> winningNum) {
        if(winningNum.size() != winningNum.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않습니다.");
        }
    }
    private void validateWinningNumRange(List<Integer> winningNum){
        for(int i = 0 ; i<winningNum.size() ; i++){
            if(0> winningNum.get(i) && winningNum.get(i)>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 수입니다.");
            }
        }
    }
    public int inputBonusNum(){
        bonusNum = Integer.parseInt(Console.readLine());
        return this.bonusNum;
    }
    public int getBonusNum(int bonusNum){
        validateRange(bonusNum);
        if(winningNum.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호와 로또 번호는 중복되지 않습니다.");
        } return bonusNum;
    }
    private void validateRange(int bonusNum){
        if(1>bonusNum && bonusNum>45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 수입니다.");
        }
    }
    public void checkWinNum (){
        for(List<Integer> checkNum : totalLotto){

            int win = countWin(checkNum);
            int bonusWin = 0;

            if(checkNum.contains(bonusNum)){
                bonusWin++;
            }
            countWinningResult(win, bonusWin);
        }
    }
    private int countWin(List<Integer> autoLotto) {
        int win = 0;
        for(int winningNumber : winningNum){
            if(autoLotto.contains(winningNumber)){
                win++;
            }
        }
        return win;
    }

    private void countWinningResult(int win, int bonusWin) {
        if(win==6) FIRST++;
        if(win==5 && bonusWin==1) SECOND++;
        if(win==5 && bonusWin==0) THIRD++;
        if(win==4) FOURTH++;
        if(win==3) FIFTH++;
    }

    public void printResult(){
        System.out.println("통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+FIFTH+"개");
        System.out.println("4개 일치 (50,000원) - "+FOURTH+"개");
        System.out.println("5개 일치 (1,500,000원원) - "+THIRD+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+SECOND+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+FIRST+"개");
        System.out.println("총 수익률은 " + String.format("%.1f",YIELD) + "%입니다.");

    }
    public  void yieldCalculate(int purchaseAmount){
        long yield = 5000 * FIFTH + 50000 * FOURTH + 1500000 * THIRD + 30000000 * SECOND + 2000000000 * FIRST;
        YIELD = yield / (double) purchaseAmount * 100;
    }







    public List<List<Integer>> makeLotto (int lottoAmount){
        totalLotto = new ArrayList<>();
        for(int i =0 ; i<lottoAmount ; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(firstBallNum, LASTBALLNUM, COUNT));
            totalLotto.add(lotto.getNumbers());
        }
        return totalLotto;
    }
    public void outPutLottoNum (List<List<Integer>> totalLotto){
        for(Object lottoNum : totalLotto){
            System.out.println(lottoNum);
        }
    }

}
