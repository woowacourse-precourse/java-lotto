package lotto;

public class Money {

    private static int resultMoney;

    public Money(String input){
        validateDivisibleBy1000(input);
    }

    public void validateDivisibleBy1000(String input){
        resultMoney = Integer.parseInt(input);

        if(resultMoney % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매하실 수 있습니다.");
        }
    }

    public static int getTicketCount(){
        return resultMoney / 1000;
    }

    public static int getResultMoney(){
        return resultMoney;
    }
}
