package lotto.domain;

public class WinningResult {
    public int WinningPrice(int number , int bonus){
        String sameThree = "3개 일치 (5,000원) - ";
        String sameFour= "4개 일치 (50,000원) - ";
        String sameFive = "5개 일치 (1,500,000원) - ";
        String sameFiveAndBonus = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        String sameSix = "6개 일치 (2,000,000,000원) - ";
        int Three = 0;
        int Four = 0;
        int Five = 0;
        int FiveAndBonus = 0;
        int Six = 0;
        int result = 0;
        if(number == 3){
           Three++;
            result = 5000;
        }
        else if(number == 4){
            Four++;
            result = 50000;
        }
        else if(number == 5){
            Five++;
            result = 1500000;
        }
        else if(number == 5 && bonus == 1){
            FiveAndBonus++;
            result = 30000000;
        }
        else if(number == 6){
            Six++;
            result = 2000000000;
        }
        else {
            System.out.println("2개이하 일치는 제외입니다.");
        }

        System.out.println(sameThree +Three +"개");
        System.out.println(sameFour + Four +"개");
        System.out.println(sameFive + Five +"개");
        System.out.println(sameFiveAndBonus + FiveAndBonus +"개");
        System.out.println(sameSix + Six +"개");
        return result;
    }
}
