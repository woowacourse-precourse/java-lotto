## 🗺 설계
* [x] 애플리케이션 흐름 구상하기

![](application-flow-blueprint.png)

* [x] 애플리케이션을 실행하는 코어 객체 구현하기
* [ ] 의존성 주입 컨테이너 구현하기
* [x] 검증 클래스 의존성 분리하기
  * [x] 검증 클래스 리스트를 보관, 적절한 Validator를 찾아 실행하는 ValidatorHolder 클래스 구현하기

## 👀 구현 컨벤션
* 사용자의 입력 문제가 아닌 애플리케이션 내부 문제로 발생하는 예외는 IllegalStateException 을 발생하게 한다.
* IllegalStateException 이 발생했을 때는 '[Error] 예상치 못한 어플리케이션 문제가 발생했습니다.' 메시지를 출력하고 애플리케이션이 종료된다.