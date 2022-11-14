package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    int insertedNumber;
    List<Integer> winningNumbers;
    int bonusNumber;

    List<Lotto> lottery = new ArrayList<>();

    public static void main(String[] args) {
        Application application = new Application();
        application.printInsertPrice();
        application.insertPriceAndSaveNumber();
        application.makeLottery();
        application.printLottery();
        application.printInsertWinningNumber();
        application.insertWinningNumber();
        application.printInsertBonusNumber();
        application.insertBonusNumberSaveNumber();
    }

    private void printInsertPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void insertPriceAndSaveNumber(){
        String s = Console.readLine();
        insertedNumber = Integer.parseInt(s);
        if(insertedNumber < 0 || insertedNumber%1000 != 0) Exception.of(Exception.LOTTO_PRICE_01);
    }

    public void makeLottery(){
        for(int i =0; i < insertedNumber/1000; i++){
            List<Integer> randomSet = makeUnDuplicatedArray();
            Lotto lotto = new Lotto(randomSet);
            lottery.add(lotto);
        }
    }

    private List<Integer> makeUnDuplicatedArray(){
        List<Integer> result = new ArrayList<>();
        boolean [] check = new boolean[45];
        int index = 0;
        while(index < 6){
            int random = Randoms.pickNumberInRange(1, 45);
            if(check[random-1]) continue;
            check[random-1]=true;
            result.add(random);
            index++;
        }
        return result;
    }

    private void printLottery(){
        System.out.println(insertedNumber/1000 + "를 구매했습니다.");
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
