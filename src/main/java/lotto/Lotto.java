package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Integer> getresultList(List<Integer>[] lottos, List<Integer> luckyNumbers){
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0; i < lottos.length; i++){
            int correctNumber = 0;
            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 6; k++){
                    if(lottos[i].get(j).equals(luckyNumbers.get(k))){
                        correctNumber++;
                    }
                }
            }
            resultList.add(correctNumber);
        }
        return resultList;
    }

    public static ArrayList<Integer> getBonusresultList(List<Integer>[] lottos, int bonusNumber){
        ArrayList<Integer> bonusResultList = new ArrayList<>();
        for(int i = 0; i < lottos.length; i++){
            int bonusCorrect = 0;
            for(int j = 0; j < 6; j++){
                if (lottos[i].get(j) == bonusNumber) {
                    bonusCorrect++;
                }
            }
            bonusResultList.add(bonusCorrect);
        }
        return bonusResultList;
    }

    public static int getResult(ArrayList<Integer> exceptBonusResultList, ArrayList<Integer> bonusResultList){
        int price = 0;
        int[] printingResult = new int[6];
        for (int i = 0; i < exceptBonusResultList.size(); i++) {
            int exceptBonusResult = exceptBonusResultList.get(i);
            int bonusResult = bonusResultList.get(i);
            printingResult[judgement(exceptBonusResult, bonusResult)]++;
        }
        System.out.println("3개 일치 (5,000원) - " + printingResult[1] + "개");
        System.out.println("4개 일치 (50,000원) - " + printingResult[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + printingResult[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + printingResult[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + printingResult[5] + "개");
        price = printingResult[1] * 5000 + printingResult[2] * 50000 + printingResult[3] * 1500000
                + printingResult[4] * 30000000 + printingResult[5] * 2000000000;
        return price;
    }

    public static int judgement(int exceptBonusResult, int bonusResult){
        int rank = 0;
        int sum = exceptBonusResult + bonusResult;
        if(exceptBonusResult == 6) rank = 5;
        if(exceptBonusResult == 5 && bonusResult == 1) rank = 4;
        if(sum == 5) rank = 3;
        if(sum == 4) rank = 2;
        if(sum == 3) rank = 1;
        return rank;
    }
    // TODO: 추가 기능 구현
}
