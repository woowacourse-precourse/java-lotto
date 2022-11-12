package lotto.model;

public class Money {

    int money;
    int lottoAmount;
    public Money(String input){
        int money;

        // 숫자가 아닌 값을 입력한 경우
        try {
            money = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        //1000원 이상이 아니거나, 1000원으로 나누어지지 않는 경우
        if(!(money >= 1000) || (money % 1000 != 0)){
            throw new IllegalArgumentException("[ERROR] 알맞은 금액을 입력해주세요.");
        }

        this.money = money;
        this.lottoAmount = money / 1000;
    }
}
