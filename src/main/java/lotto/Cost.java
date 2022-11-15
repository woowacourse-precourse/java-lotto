package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Cost {
    public Cost(int count) {
    }

    public static int val_cost(int cost) {//구매개수 확인 메서드
        int count = cost / 1000;
        if (cost % 1000 != 0||cost<=0) {
            throw new IllegalArgumentException(Error.UnitError.print());
        }
        return count;
    }

    public static int get_cost() {//금액 받아오기
        System.out.println("구입금액을 입력해 주세요.");
        String cost = readLine();
        if (!isNumeric(cost))
        {try {
                throw new IllegalArgumentException(Error.NumberError.print());
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }}
        if(isNumeric(cost)){
            int count = val_cost(Integer.parseInt(cost));
            System.out.println();
            System.out.println(count + "개를 구매했습니다.");
            return count;
        }return 0;}

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
