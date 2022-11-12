package CreateClassTest;

public class NormalClass {
    static {
        System.out.println("static 블럭");
    }

    {
        System.out.println("일반 블럭");
    }

    public NormalClass() {
        System.out.println("클래스 생성");
    }
}
