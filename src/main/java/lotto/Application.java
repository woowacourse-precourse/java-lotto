package lotto;

public class Application {

    public static void main(String[] args) {
        try {
            ApplicationManager applicationManager = new ApplicationManager();
            applicationManager.proceed();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("알수없는 예외가 발생했습니다.");
        }
    }

}
