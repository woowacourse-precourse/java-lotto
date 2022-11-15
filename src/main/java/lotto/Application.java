package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    final int [] profitTable = {5000, 50000, 1500000, 30000000, 2000000000};

    final String [] profitTableString = {" (5,000원)", " (50,000원)", " (1,500,000원)", ", 보너스 볼 일치 (30,000,000원)", " (2,000,000,000원)"};
    final String [] profitTableCount = {"3", "4", "5", "5", "6"};
    int insertedNumber;
    List<Integer> winningNumbers;
    int bonusNumber;

    List<Lotto> lottery = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Application application = new Application();
            application.printInsertPrice();
            application.insertPriceAndSaveNumber();
            application.makeLottery();
            application.printLottery();
            application.printInsertWinningNumber();
            application.insertWinningNumber();
            application.printInsertBonusNumber();
            application.insertBonusNumberSaveNumber();
            int[] profitBoard = application.calcMatches();
            double profitRate = application.makeProfitRate(profitBoard);
            application.printStatics(profitBoard, profitRate);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void printStatics(int[] profitBoard, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=0; i < 5; i++){
            System.out.println(profitTableCount[i] + "개 일치" + profitTableString[i] + " - " + profitBoard[i] + "개");
        }
        System.out.println("총 수익률은 " + profitRate+"%입니다.");
    }

    public double makeProfitRate(int[] profitBoard) {
        double profits = 0;
        for(int i=0; i<5; i++){
            profits+=profitBoard[i] * profitTable[i];
        }
        double profitRate = profits / insertedNumber;
        double result = Math.round(profitRate * 1000) / 1000.0;
        return result*100;
    }

    public int[] calcMatches() {
        int[] profitBoard = new int[5];
        lottery.forEach(o->{
            MatchDto matchDto = o.calcMatches(winningNumbers, bonusNumber);
            makeProfitBoard(matchDto, profitBoard);
        });
        return profitBoard;
    }

    private void makeProfitBoard(MatchDto dto, int[] profitBoard){
        if(dto.getMatchCount() == 3) profitBoard[0]++;
        else if(dto.getMatchCount() == 4) profitBoard[1]++;
        else if(dto.getMatchCount() == 5 && !dto.isBonusState()) profitBoard[2]++;
        else if(dto.getMatchCount() == 5 && dto.isBonusState()) profitBoard[3]++;
        else if(dto.getMatchCount() == 6) profitBoard[4]++;
    }

    private void printInsertPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void insertPriceAndSaveNumber(){
        String s = Console.readLine();
        try{
            insertedNumber = Integer.parseInt(s);
        }catch (java.lang.Exception e){
            Exception.of(Exception.LOTTO_PRICE_01);
        }
        if(insertedNumber < 0 || insertedNumber%1000 != 0) Exception.of(Exception.LOTTO_PRICE_01);
    }

    public void makeLottery(){
        for(int i =0; i < insertedNumber/1000; i++){
            List<Integer> randomSet = makeUnDuplicatedArray();
            List<Integer> sortedRandomSet = randomSet.stream().sorted().collect(Collectors.toList());
            Lotto lotto = new Lotto(sortedRandomSet);
            lottery.add(lotto);
        }
    }

    private List<Integer> makeUnDuplicatedArray(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void printLottery(){
        System.out.println(insertedNumber/1000 + "개를 구매했습니다.");
        lottery.forEach(o->{
            o.print();
            System.out.println();
        });
    }

    private void printInsertWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void insertWinningNumber(){
        String[] split = null;
        try{
            String input = Console.readLine();
            split = input.split(",");
        }catch (java.lang.Exception e){
            Exception.of(Exception.WINNING_NUMBER_02);
        }
        isInRange(split);
        isRightSize(split);
        saveToList(split);
    }

    public void printInsertBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void insertBonusNumberSaveNumber(){
        String input = null;
        try{
            input = Console.readLine();
        }catch (java.lang.Exception e){
            Exception.of(Exception.WINNING_NUMBER_02);
        }
        isInRangeAndSize(input);
        this.bonusNumber = Integer.parseInt(input);
    }

    private void saveToList(String[] split) {
        winningNumbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void isRightSize(String[] split) {
        if(split == null)   Exception.of(Exception.WINNING_NUMBER_05);
        if(split.length != 6) Exception.of(Exception.WINNING_NUMBER_04);
    }

    private void isInRange(String[] split) {
        if(split == null)   Exception.of(Exception.WINNING_NUMBER_05);
        for(String s : split){
            int t = Integer.parseInt(s);
            if(t < 0 || t > 45) Exception.of(Exception.WINNING_NUMBER_03);
        }
    }

    private void isInRangeAndSize(String input) {
        if(input == null)   Exception.of(Exception.BONUS_NUMBER_05);
        int t = 0;
        try{
            t = Integer.parseInt(input);
        }catch (java.lang.Exception e){
            Exception.of(Exception.BONUS_NUMBER_06);
        }
        if(t < 0 || t > 45) Exception.of(Exception.BONUS_NUMBER_06);
    }

    public List<Lotto> getLottery() {
        return lottery;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
