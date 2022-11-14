package lotto;

public class Application {
    public static void main(String[] args) {
        //구입 가격 입력 및 숫자인지 확인
        price check_price = new price();
        //구입 가격이 숫자라면 통과
        if (check_price.program_out == 0) {
            //구입 총 매수 계싼
            quantity how_many = new quantity(check_price.input_price);
            //구입 매수만큼 로또번호 생성
            Pick pick_number = new Pick(how_many.paper_quantity);
            //로또 당첨번호 및 보너스번호 받기
            victory victory_number = new victory();
            // 당첨 통계
            statistic statistic_result = new statistic(
                    victory_number.victory_normal_number,
                    victory_number.victory_bonus_number,
                    pick_number.pick_member,
                    check_price.input_price);
            //끝
        }
    }
}
