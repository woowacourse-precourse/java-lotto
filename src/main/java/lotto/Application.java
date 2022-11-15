package lotto;

import dto.*;
import vo.*;
import function.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            dto.UserDTO userdto = new UserDTO();
            int money = userdto.getMoney();
            vo.uservo user = new uservo(userdto);

            dto.lotterydto lottodto = new lotterydto(user);
            List<List<Integer>> lottos = lottodto.getLottos();

            dto.winnerdto winner = new winnerdto();
            List<Integer> win = winner.getWinnumbers();
            int bonus = winner.getBonusnumber();

            function.calculate cal = new calculate(lottos, win, bonus, money);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // TODO: 프로그램 구현

    }
}
