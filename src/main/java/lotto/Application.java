package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    int insertedNumber;
    public static void main(String[] args) {
        Application application = new Application();
        application.printInsertPrice();
    }

    private void printInsertPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void insertPriceAndSaveNumber(){
        String s = Console.readLine();
        insertedNumber = Integer.parseInt(s);
        if(insertedNumber > 0 || insertedNumber%1000 != 0) Exception.of(Exception.LOTTO_PRICE_01);
    }
}
