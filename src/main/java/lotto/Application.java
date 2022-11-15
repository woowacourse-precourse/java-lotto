package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void makeRandomNumber(int lottoTimes,List<List<Integer>> totalNumbers){
        for (int i=0;i<lottoTimes;i++){
//          System.out.println();
            totalNumbers.add(Randoms.pickUniqueNumbersInRange(Constants.START_NUMBER,Constants.END_NUMBER,Constants.times));
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputOutputUI InputOutput = new InputOutputUI();
        List<List<Integer>> totalNumbers = new ArrayList<>();

        InputOutput.setMoney();
        int lottoTimes = InputOutput.getMoney();
        makeRandomNumber(lottoTimes,totalNumbers);
        System.out.println(totalNumbers);
    }
}
