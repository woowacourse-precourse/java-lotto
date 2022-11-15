package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int buylotto = askmoney();
        List<List<Integer>> lottonumbers = new ArrayList<>();
        int result[] = new int[5];
        List<Integer> winningnumbers = new ArrayList<>();

        Random random = new Random();
        lottonumbers = random.createAllLotto(buylotto);
        printalllotto(lottonumbers,buylotto);

        CompareLotto comparelotto = new CompareLotto();
        winningnumbers = askwinningnumbers();
        result = comparelotto.correctcount(lottonumbers,winningnumbers,askbonusnumber(winningnumbers));

        printresult(result, buylotto);
        // TODO: 프로그램 구현
    }
    public static int askmoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int buymoney, buylotto;

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)<'0' || input.charAt(i)>'9')
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        buymoney = Integer.parseInt(input);
        if(buymoney%1000 != 0)
            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위여야 합니다.");
        buylotto = buymoney / 1000;
        System.out.println("\n"+buylotto+"개를 구매했습니다.");
        return buylotto;
    }
    public static void printalllotto(List<List<Integer>> lottonumbers, int buylotto){
        for(int i=0;i<buylotto;i++){
            System.out.println(lottonumbers.get(i));
        }
    }
    public static List<Integer> askwinningnumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningnumbers = new ArrayList<>();
        String input = Console.readLine();

        for(String number:input.split(",")){
            winningnumbers.add(Integer.valueOf(number));
        }

        Lotto execptnum = new Lotto(winningnumbers);
        return winningnumbers;
    }
    public static int askbonusnumber(List<Integer> winningnumbers){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusnumber;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)<'0'||input.charAt(i)>'9')
                throw new IllegalArgumentException("[ERROR] 숫자 하나만 입력해 주세요.");
        }
        bonusnumber = Integer.parseInt(input);
        if(bonusnumber<1 || bonusnumber>45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45사이의 숫자여야 합니다.");
        if(winningnumbers.contains(bonusnumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복지 않은 숫자여야 합니다.");

        return bonusnumber;
    }
    public static void printresult(int[] result, int buylotto){
        int totalmoney = 0;
        System.out.println("\n당첨 통계\n---");
        for(PrizeInfo info : PrizeInfo.values()){
            int index = info.ordinal();
            System.out.println(info.getCount()+" "+info.getPrintMoney()+" - "+result[index]+"개");
            totalmoney += (info.getRealMoney()*result[index]);
        }
        double earn_rate = (double)(totalmoney/10)/(double)buylotto;
        DecimalFormat format = new DecimalFormat("###,###.#");
        System.out.println("총 수익률은 "+format.format(earn_rate)+"%입니다.");
    }
}
