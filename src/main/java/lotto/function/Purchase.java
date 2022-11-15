package lotto.function;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public int money = 0;

    public Purchase(){
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();

        try{
            if(numberCheck(price)){
                this.money = Integer.parseInt(price);
            }

            if(validCheck(this.money)){
                ;
            }
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean numberCheck(String price){
        for (int i=0;i< price.length(); i++){
            if(!Character.isDigit(price.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매가 가능합니다.");
            }
        }

        return true;
    }
    
    public boolean validCheck(int number){
        if(number % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매가 가능합니다.");
        }

        return true;
    }

    public int lottoNumber(){
        return this.money / 1000;
    }

}
