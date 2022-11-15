package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void makeRandomNumber(int lottoTimes,List<List<Integer>> totalNumbers){
        for (int i=0;i<lottoTimes;i++){
            totalNumbers.add(Randoms.pickUniqueNumbersInRange(Constants.START_NUMBER,Constants.END_NUMBER,Constants.TIMES));
        }
        System.out.print(lottoTimes);
        System.out.println(Constants.INFO_AMOUNT);
    }

    public static void print(List<List<Integer>> list){
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println();
    }


    public static void main(String[] args) {

        InputOutput IO = new InputOutput();
        List<List<Integer>> totalNumbers = new ArrayList<>();

        IO.setMoney();
        int lottoTimes = IO.getMoney();

        makeRandomNumber(lottoTimes,totalNumbers);
        print(totalNumbers);

        IO.setUserInputNumber();
        System.out.println(IO.getUserInputNumber());

        Lotto lotto = new Lotto(IO.getUserInputNumber());

        IO.setBonusNumber();
        System.out.println(IO.getBonusNumber());

        Calculate cal = new Calculate(IO.getUserInputNumber(),IO.getBonusNumber(),totalNumbers);

        cal.compareNumber();
        cal.getMatchCount();
    }
}
