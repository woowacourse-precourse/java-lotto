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
    List<List<Integer>> randomLottos = new ArrayList<>();

    public static void main(String[] args) {
        Application application = new Application();
        application.printInsertPrice();
        application.insertPriceAndSaveNumber();
        application.makeArray();
        application.makeEachArrays();
        application.printRandomLottos();
        application.printInsertWinningNumber();
        application.insertWinningNumber();
    }

    private void printInsertPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void insertPriceAndSaveNumber(){
        String s = Console.readLine();
        insertedNumber = Integer.parseInt(s);
        if(insertedNumber < 0 || insertedNumber%1000 != 0) Exception.of(Exception.LOTTO_PRICE_01);
    }

    public void makeArray(){
        int dividedNumber = insertedNumber / 1000;
        for(int i =0; i < dividedNumber; i++)
            randomLottos.add(new ArrayList<>());
    }

    public void makeEachArrays(){
        for(int i = 0; i < insertedNumber/1000; i++) {
            List<Integer> lotto = makeUnDuplicatedArray();
            randomLottos.get(i).addAll(lotto);
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

    private void printRandomLottos(){
        System.out.println(insertedNumber/1000 + "를 구매했습니다.");
        for(int i =0; i < insertedNumber/1000; i++){
            System.out.print("[");
            for(int j=0; j < 6; j++){
                System.out.print(randomLottos.get(i).get(j));
                if(j != 5) System.out.print(", ");
            }
            System.out.print("]");
            System.out.println();
        }
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

    public List<List<Integer>> getRandomLottos() {
        return randomLottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
