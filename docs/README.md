로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

<유의사항>
- else 예약어를 사용하지 않는다.
- 3항 연산자 사용하지 않는다
- indent depth 가 3을 넘지 않도록 한다.
- java enum 을 사용한다
- 도메인 로직에 단위 테스트를 구현해야 한다. 
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

<Lotto Class>
- 매개 변수가 없는 생성자를 추가할 수 없다
- numbers의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
- Lotto의 패키지 변경은 가능하다.

<기능 구현 분리>
- Lotto System 제작 (Application.java)
- Lotto Service 제작
  - Lotto class
    - 숫자 범위에 대한 check 함수
    - 중복되지 않은 숫자들이 6개 있는지 check
- Exception 처리
- Test