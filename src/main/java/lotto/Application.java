package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String str = "9223372036854775808";
        try {
            Long testLong = Long.valueOf(str);

            System.out.println(testLong);
        } catch (IllegalArgumentException e){
            System.out.println("error");
        }

    }
}
