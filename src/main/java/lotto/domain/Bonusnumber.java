package lotto.domain;

public class Bonusnumber {
    private  final int bonusnumber;

    public Bonusnumber(String bonusnumber){
        this.bonusnumber = validateBonus(bonusnumber);
        System.out.println(bonusnumber);
    }

    private int validateBonus(String bonusnumber){
        int bonus = Integer.parseInt(bonusnumber);
        if (bonus >= 1 && bonus <= 45)
            return bonus;
        throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45사이의 숫자여야합니다.");
    }

    public int Get_val(){
        return bonusnumber;
    }
}
