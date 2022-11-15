package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final String notThousand =" 구입금액은 천원 단위여야합니다.";
    public static final String notNumber =" 구입금액은 숫자여야합니다.";
    public static final int unit = 1000;
    public void gameStart(){
        System.out.println(Resource.greetings);
        String purchase = Console.readLine();
        int lottoUnit = checkIfDivideWithThousand(purchase);

        System.out.println(Resource.countOfBuying);
        //랜덤 구매 번호 출력

        System.out.println(Resource.inputOfWinningNumber);
        String winNumber = Console.readLine();

        System.out.println(Resource.inputOfBonusNumber);
        String bonusNumber = Console.readLine();

        System.out.println(Resource.resultOfWinning);
        System.out.println(Resource.countOfCorrectNumberFront);
        System.out.println(Resource.countOfCorrectNumberMiddle);
        System.out.println(Resource.countOfCorrectNumberBack);

        System.out.println(Resource.revenuePercentFront);
        System.out.println(Resource.revenuePercentBack);


    }
    public int checkIfDivideWithThousand(String purchase){
        try{
            int purchaseBill = Integer.parseInt(purchase);
            if(purchaseBill%unit !=0){
                throw new IllegalArgumentException(ErrorResource.errorStart+notThousand);
            }
            return purchaseBill/unit;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorResource.errorStart+notNumber);
        }
    }


}
