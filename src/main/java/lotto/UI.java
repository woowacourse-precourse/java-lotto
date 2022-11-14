package lotto;

public class UI {
    UI(){}
    private static String inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        return input;
    }
    private static void printBuyInfo(){
        int size =DB.getTableSize();
        System.out.println("\n"+size+"개를 구매했습니다.");
        for(int i=0; i<size; i++){
            System.out.println(DB.selectAt(i));
        }
    }

}
