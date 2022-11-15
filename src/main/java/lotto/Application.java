package lotto;

import java.util.Collections;
import java.util.List;
import lotto.controller.LottoController;
import lotto.controller.UserController;

public class Application {
    public enum Prize {
        One(0),Two(0),Three(5000),Four(50000),Five(1500000),Six(2000000000),Seven(30000000);
        private int value;

        Prize(int i) {
            this.value=i;
        }
        public int getValue(){return value;}
    }

    public static List<String> words = List.of("3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    );

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final UserController userController = new UserController();
        final LottoController lottoController = new LottoController();

        userController.getBudget();
        lottoController.createLottoList(userController.getPublicians());

        lottoController.printLottoList();
        userController.getUserInputs();

        //점수 계산 시작
        lottoController.getCorrect(userController.getUserNumbers());

        List<Integer> list = lottoController.getCorrectTimes();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
            if (list.get(i) == 5) {
                if (lottoController.getIsIncludeBonus(userController.getBonusNumber(), i)) {
                    list.set(i, list.get(i) + 2);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        //점수 계산 끝
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalPrize = 0;
        for (int i = 3; i < 8; i++) {
            int frequency = Collections.frequency(list, i);

            if(i==3){
                totalPrize+=Prize.Three.getValue()*frequency;
            }
            if(i==4){
                totalPrize+=Prize.Four.getValue()*frequency;
            }
            if(i==5){
                totalPrize+=Prize.Five.getValue()*frequency;
            }if(i==6){
                totalPrize+=Prize.Six.getValue()*frequency;
            }if(i==7){
                totalPrize+=Prize.Seven.getValue()*frequency;
            }
            String sentence = String.format(words.get(i-3)+"%d개",frequency);
            System.out.println(sentence);
        }
        int userInput = userController.getPublicians()*1000;
        double userInputD=userInput;
        double totalPrizeD=totalPrize;
        double rate = (totalPrizeD*100)/userInputD;
        System.out.println(rate);
        System.out.println("총 수익률은 "+(double)Math.round(rate*10)/10.0+"%입니다.");

    }
}
