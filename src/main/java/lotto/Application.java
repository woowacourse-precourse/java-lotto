package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    int insertedNumber;
    List<List<Integer>> randomLottos = new ArrayList<>();

    public static void main(String[] args) {
        Application application = new Application();
        application.printInsertPrice();
        application.insertPriceAndSaveNumber();
        application.makeArray();
        application.makeEachArrays();
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

    public List<List<Integer>> getRandomLottos() {
        return randomLottos;
    }
}
