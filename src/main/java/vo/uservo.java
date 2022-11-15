package vo;

import dto.*;

public class uservo {
    private int money;
    private int count;
    final private int valueofticket = 1000;

    public uservo(UserDTO dto) throws Exception{
        this.money = dto.getMoney();
        validate(money);
        this.money = money;
        count_lotto(money);
    }

    public int getCount() {   return count; }

    private void validate(int money) throws Exception {
        if (money % this.valueofticket != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위이어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void count_lotto(int money) {
        this.count = money / this.valueofticket;
        System.out.println(String.format("%d개를 구매했습니다.",this.count));

    }
}
