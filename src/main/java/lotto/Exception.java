package lotto;

public class Exception {
    public void initialInput(String input) {
        onlyNumber(input);
        int inMoney = Integer.parseInt(input);
        onlyOneThousand(inMoney);
        System.out.println();
    }

    private void onlyOneThousand(int inMoney) {
        if (inMoney % 1000 != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void onlyNumber(String temp) {
        for (int i = 0; i < temp.length(); i++) {
            try {
                if (temp.charAt(i) < '0' || temp.charAt(i) > '9') getMS();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputWinningBonus(String input) {
        onlyNumberBonus(input);
        int bonus = Integer.parseInt(input);
        onlyRangeBonus(bonus);
        System.out.println();
    }

    private void onlyRangeBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void onlyNumberBonus(String input) {
        for (int i = 0; i < input.length(); i++) {
            try {
                if (input.charAt(i) < '0' || input.charAt(i) > '9') getMS();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private void getMS(){
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
    }
}
