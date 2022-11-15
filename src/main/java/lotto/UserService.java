package lotto;

import java.util.List;

public interface UserService {
    int getCntOfLotto(int userPayment);
    List<Integer> getUserNums(String userInput);
    int getUserBonus(String userBonus);
}