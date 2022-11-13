package lotto;
/*
설명 - 사용자 돈 객체
getLottoNumber() - 몇개의 로또가 만들어저야하는지 개수 return
getUserInputMoney(0 -
 */
public class UserMoney {
    private final int userInputMoney;

    public UserMoney(String userInputMoney) {
        checkError(userInputMoney);
        this.userInputMoney = Integer.parseInt(userInputMoney);
    }

    private void checkError(String userInputMoney) {
        for (int i = 0; i < userInputMoney.length(); i++) {
            if (userInputMoney.charAt(i) < 48 || userInputMoney.charAt(i) > 57) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
        if (Integer.parseInt(userInputMoney) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getLottoNumber() {
        return this.userInputMoney / 1000;
    }

    public int getUserInputMoney() {
        return userInputMoney;
    }
}
