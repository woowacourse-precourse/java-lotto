package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int buylotto = askmoney();
        List<List<Integer>> lottonumbers = new ArrayList<>();

        Random random = new Random();
        lottonumbers = random.createAllLotto(buylotto);
        printalllotto(lottonumbers,buylotto);

        // TODO: 프로그램 구현
    }
    public static int askmoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int buymoney = Integer.parseInt(input), buylotto;

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
        return winningnumbers;
    }
    public static int askbonusnumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusnumber = Integer.parseInt(input);

        return bonusnumber;
    }
}
