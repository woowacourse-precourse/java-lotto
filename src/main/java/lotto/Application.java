package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    int insertedNumber;
    List<List<Integer>> randomLottos;

    public static void main(String[] args) {
        Application application = new Application();
        application.printInsertPrice();
        application.insertPriceAndSaveNumber();
        application.makeArray();
    }

    private void printInsertPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void insertPriceAndSaveNumber(){
        String s = Console.readLine();
        insertedNumber = Integer.parseInt(s);
        if(insertedNumber > 0 || insertedNumber%1000 != 0) Exception.of(Exception.LOTTO_PRICE_01);
    }

    private void makeArray(){
        int dividedNumber = insertedNumber / 1000;
        for(int i =0; i < dividedNumber; i++)
            randomLottos.add(new ArrayList<>());
    }
}
