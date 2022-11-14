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

        input = readInput();
        List<Integer> pickedNumbers = validatePickedNumbers(input);

        input = readInput();
        int bonusNum = parseInt(input);
        if (pickedNumbers.contains(bonusNum) || bonusNum<1 || bonusNum >45){
            throw new IllegalArgumentException("[Error] Number should be in the range of 1 ~ 45");
        }



    }

    

    public static List<Integer> validatePickedNumbers(String input) {
        String [] numbers = input.split(",");
        List<Integer> pickedNumbers = new ArrayList<Integer>();

        if (numbers.length != 6){
            throw new IllegalArgumentException("[Error] pick 6 different number between 1 to 45");
        }

        for (int i = 0; i<numbers.length; i++){
            int number = parseInt(numbers[i]);

            if (pickedNumbers.contains(number)){
                throw new IllegalArgumentException("[Error] Duplicated number exists");
            }
            if (number<1 || number>45){
                throw new IllegalArgumentException("[Error] Number should be in the range of 1 ~ 45");
            }
            pickedNumbers.add(number);
        }

        return pickedNumbers;
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

    public static List<Lotto> buyLotto(List lottos, int money){
        int numberOfLottos = (money/1000);

        for (int i = 0; i<numberOfLottos; i++){
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lottoItem = new Lotto(randomNumbers);
            lottos.add(lottoItem);
        }

        return lottos;
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

    public static String readInput(){
        String input = Console.readLine();
        return input;
    }


}
