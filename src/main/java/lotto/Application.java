package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int payment = correctPayment(UserInputUi.ENTERCOST.getAnswer());
        payment = getNumberOfLottery(payment);
        System.out.println("payment : " + payment);
    }

    public static int getNumberOfLottery(int payment){
        return payment/1000;
    }

    public static int correctPayment(String payment){
        int cost;
        try{
            cost = Integer.parseInt(payment);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요..");
        }

        if(!(cost % 1000 == 0)){
            throw new IllegalArgumentException("[ERROR] 천 원 단위만 입력해주세요.");
        }

        return cost;
    }
}