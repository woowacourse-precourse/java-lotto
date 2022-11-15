package dto;

import camp.nextstep.edu.missionutils.Console;
import java.lang.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {
    private int money;

    public UserDTO() {
        setMoney();
    }

    public int getMoney() { return money; }

    public void setMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String temp = Console.readLine();
        try {
            this.money = Integer.parseInt(temp);
        }catch(Exception e){
            System.out.println("[ERROR] 구입 금액은 1,000원 단위이어야 합니다.");
            throw new IllegalArgumentException();
        }
    }


}
