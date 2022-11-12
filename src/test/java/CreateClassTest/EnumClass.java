package CreateClassTest;

public enum EnumClass {
    TEST();

    static {
        System.out.println("static 블럭");
    }

    {
        System.out.println("일반 블럭");
    }

    EnumClass() {
        System.out.println("클래스 생성");
    }
}
