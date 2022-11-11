package lotto;

import java.util.List;

public class Model {


    private List<Lotto> lottoList; // save computer generated Lotto numbers
    private Lotto winningLotto; // save user input Lotto numbers
    private double returnRate; // rate of return by Model.userMoney
    private int userMoney; // user input value

    public Model() {

    }

    /**
     * judge money is constructed by digits
     * @param money served by setUserMoney
     * @return Is money variable is constructed by digits
     */
    private boolean validateInt(String money) {
        for(int i = 0; i < money.length(); i++){
            if(!Character.isDigit(money.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * set money with user input
     * @param stringMoney String to be thousands unit
     */
    public void setUserMoney(String stringMoney) {
        if(!validateInt(stringMoney)){
            throw new IllegalArgumentException("[ERROR] Please input Number only");
        }
        int money = Integer.parseInt(stringMoney);
        if(money % 1000 > 0){
            throw new IllegalArgumentException("[ERROR] Please enter in thousands");
        }
        this.userMoney = money;
    }
}

