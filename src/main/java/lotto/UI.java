package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class UI {
    UI(){
        String input = inputMoney();
        try{
            Customer customer= new Customer(input);
            Store store = new Store(customer);
            store.buy();
            printBuyInfo();
            String win = inputWinNumbers();
            String bonus = inputBonusNumbers();
            Saturday saturday = new Saturday(win,bonus);
            saturday.makeStatistics();
            saturday.calYeild();
            printStatistics();
            printfYeild();}
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private static String inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        return input;
    }
    private static void printBuyInfo(){
        int size =DB.getTableSize();
        System.out.println("\n"+size+"개를 구매했습니다.");
        for(int i=0; i<size; i++){
            System.out.println(DB.selectAt(i).getNumbers());
        }
    }

    private static String inputWinNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbers = camp.nextstep.edu.missionutils.Console.readLine();
        return numbers;
    }
    private static String inputBonusNumbers(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String number = camp.nextstep.edu.missionutils.Console.readLine();
        return number;
    }

    private static void printStatistics(){
        List<Integer> statistics = DB.getStatistics();
        DecimalFormat formater = new DecimalFormat("###,###");
        System.out.println("\n당첨통계");
        System.out.println("---");
        int[] info;
        for(int i=0; i<statistics.size(); i++){
            info = Winner.getInfobyIndex(i);
            if(info[0]>10){
                System.out.println(info[0]/10+"개 일치, 보너스 볼 일치 ("+formater.format(info[1])+"원) - " +statistics.get(i)+"개") ;
                continue;
            }
            System.out.println(info[0]+"개 일치 ("+formater.format(info[1])+"원) - " +statistics.get(i)+"개") ;
        }
    }
    private static void printfYeild(){
        DecimalFormat formater = new DecimalFormat("###,###.#");
        System.out.println("총 수익률은 "+formater.format(DB.getYeild())+"%입니다.");
    }
}
