package lotto;
import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void checkError(int n){
        if(n%1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위");
    }
    public static int inputMoney(){
        int payMoney;
        String input;
        System.out.println("구입금액을 입력해 주세요.");
        input = Console.readLine();
        for(int i=0; i<input.length();i++){
            if(!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 정수의 금액을 입력하시오");
        }

        payMoney = Integer.valueOf(input);
        checkError(payMoney);

        return payMoney;
    }

    public static Lotto lottoNumber() {
        String line;
        Lotto lottoAnswer;
        List<Integer> lottonum = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        line = Console.readLine();
        String[] temp = line.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (Integer.valueOf(temp[i]) < 1 || Integer.valueOf(temp[i]) > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            if(lottonum.contains(Integer.valueOf(temp[i])))
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있을 수 없습니다.");
            lottonum.add(Integer.valueOf(temp[i]));
        }
        lottoAnswer = new Lotto(lottonum);

        return lottoAnswer;
    }


    public static List<Lotto> getUserRandomLotto(int n){
        List<Lotto> userLotto = new ArrayList<>();
        List<Integer> oneLotto;
        Lotto lotto;
        System.out.println();
        System.out.println(n + "개를 구매했습니다.");
        for(int i = 0; i < n; i++){
            oneLotto = new ArrayList<>();
            oneLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            //oneLotto.sort(Comparator.naturalOrder());
            lotto = new Lotto(oneLotto);
            userLotto.add(lotto);
        }

        return userLotto;
    }
    public static void printUserLotto(List<Lotto> userLotto){

        for(int i = 0; i < userLotto.size(); i++){
            printOneLotto(userLotto.get(i));
        }
        System.out.println();
    }
    public static void printOneLotto(Lotto lo){
        List<Integer> lotto = lo.getNumbers();

        System.out.print("[");
        for(int i = 0; i < lotto.size(); i++){
            System.out.print(lotto.get(i));
            if(i != 5)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void winningStatistics(List<Lotto> userLottoGroup, Lotto winningLotto, int bonusNumber, int payMoney){
        Count[] countArr = new Count[6];
        Result result;
        int numCheck = 0;

        countArr[0] = new Count(Result.FIRST);
        countArr[1] = new Count(Result.SECOND);
        countArr[2] = new Count(Result.THIRD);
        countArr[3] = new Count(Result.FOURTH);
        countArr[4] = new Count(Result.FIFTH);
        countArr[5] = new Count(Result.NOLUCK);
        for(int i=0;i<userLottoGroup.size();i++){
            numCheck = checkWithWinningLotto(userLottoGroup.get(i),winningLotto);
            result = returnEnumResult(numCheck,userLottoGroup.get(i).getNumbers().contains(bonusNumber));
            countArr[result.ordinal()].setCount();
        }
        printResult(countArr, payMoney);
    }
    public static void printResult(Count[] arr, int payMoney){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + arr[Result.FIFTH.ordinal()].getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + arr[Result.FOURTH.ordinal()].getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + arr[Result.THIRD.ordinal()].getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + arr[Result.SECOND.ordinal()].getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + arr[Result.FIRST.ordinal()].getCount() + "개");
        System.out.println("총 수익률은 " + (Math.round(rateOfReturn(payMoney,getTotalRewardMoney(arr))*100)/100.0) + "%입니다.");
    }
    public static double rateOfReturn(int payMoney, int returnMoney){
        return ((double)returnMoney/payMoney) * 100;
    }
    public static int getTotalRewardMoney(Count[] arr){
        int total = 0;

        for(int i=0;i<arr.length;i++){
            total += arr[i].getTotalMoney();
        }
        return total;
    }
    public static int checkWithWinningLotto(Lotto userLotto, Lotto winningLotto){
        int num = 0;
        for(int i=0;i<winningLotto.getNumbers().size();i++){
            if(userLotto.getNumbers().contains(winningLotto.getNumbers().get(i))){
                num++;
            }
        }
        return num;
    }

    public static Result returnEnumResult(int numCheck, boolean contain){
        if(numCheck == 6)
            return Result.FIRST;
        if(numCheck == 4)
            return Result.FOURTH;
        if(numCheck == 3)
            return Result.FIFTH;
        if(numCheck < 3)
            return Result.NOLUCK;
        if(contain)
            return Result.SECOND;
        return Result.THIRD;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int payMoney, bonusNumber;
        String input;
        List<Lotto> userLottoGroup = new ArrayList<>();
        Lotto winningLotto;

        payMoney = inputMoney();
        userLottoGroup = getUserRandomLotto(payMoney/1000);

        printUserLotto(userLottoGroup);
        winningLotto = lottoNumber();
        System.out.println("보너스 번호를 입력해 주세요.");

        input = Console.readLine();
        for(int i=0; i<input.length();i++){
            if(!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 입력 오류. 정수를 입력하세요.");
        }
        bonusNumber = Integer.valueOf(input);
        if(winningLotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 중복되었습니다.");

        }
        winningStatistics(userLottoGroup, winningLotto, bonusNumber, payMoney);
    }
}
