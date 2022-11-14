package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.w3c.dom.ls.LSOutput;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readInput();

        final int MONEY = validateMoneyInput(input);
        List<Lotto> boughtLottos = new ArrayList<Lotto>();

        boughtLottos = buyLotto(boughtLottos, MONEY);
        printLottos(boughtLottos);


    }

    public static String readInput(){
        String input = Console.readLine();
        return input;
    }

    public static int validateMoneyInput(String input){
        int money = parseInt(input);
        boolean isUnitOf1K = ((money % 1000)==0);

        if (isUnitOf1K==false){
            throw new IllegalArgumentException("[Error] Money should end with 000");
        }

        return money;
    }

    public static int parseInt(String input){
        try {
            int money = Integer.parseInt(input);
            return money;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[Error] Only numbers are allowed");
        }
    }

    public static List<Lotto> buyLotto(List lottos, int money){
        int numberOfLottos = (money/1000);

        for (int i = 0; i<numberOfLottos; i++){
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lottoItem = new Lotto(randomNumbers);
            lottos.add(lottoItem);
        }

        return lottos;
    }

    public static void printLottos(List lottos){
        StringBuilder lottoNumbers = new StringBuilder();
        for (int i = 0; i<lottos.size(); i++){
            lottoNumbers.append("[");
            Lotto lottoItem = (Lotto) lottos.get(i);

            for (int j = 0; j<lottoItem.getNumbers().size(); j++){
                int number = lottoItem.getNumbers().get(j);
                lottoNumbers.append(String.valueOf(number)+", ");
            }

            lottoNumbers.append("]\n");
        }

        System.out.print(lottoNumbers);
    }


}
