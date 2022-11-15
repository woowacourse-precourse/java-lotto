### 구현할 기능 목록

### 1. 로또 번호의 Exception
> + 로또 번호의 숫자 범위는 1~45이다.(당첨, 추첨번호 모두)
> + 1개의 로또에는 중복되지 않는 6개의 숫자를 뽑는다.
> + 당첨 번호에는 보너스 번호 1개를 뽑는다.

##### 로또 번호 CheckList
- [x] 6개인가
- [x] 숫자인가 
- [x] 1~45사이의 숫자인가 
- [x] 중복된 숫자는 없는가
- [x] 보너스 번호에도 상기 조건이 적용되는가

### 2. 구입 금액의 Exception Checklist
- [x] 1000원 단위인가
- [x] 숫자인가
- [x] 양수인가

### 상기 모든 예외사항 공통 CheckList
- [x] IllegalArgumentException을 발생시키는가
- [x] [ERROR]로 시작하는 에러 메세지를 출력하는가

### 3. Lotto 클래스 필수 기능
#### 구현할 메소드 Checklist
- [ ] 금액으로 return 구매할 로또 수
- [ ] 로또 수만큼 로또 번호 발행
- [ ] 당첨 내역 계산
- [ ] 당첨 내역 출력
- [ ] 수익률 계산 및 출력

### 4. WooTech 요구사항 충족 Checklist
- [ ] Random, Readline에 올바른 라이브러리를 사용하는가
- [ ] JDK 11
- [ ] Application.main()이 시작점
- [ ] 외부 라이브러리 사용 X
- [ ] Java Code Convention 충족
- [ ] ApplicationTest 성공
- [ ] 명시되지 않은 파일, 패키지 명을 수정하거나 이동하지 X
- [ ] indent는 2까지만 허용
- [ ] 3항 연산자 사용 X
- [ ] 메서드를 최대한 작게 했는가
- [ ] Junit 단위 테스트 사용
- [ ] AssertJ 사용
- [ ] else 예약어 사용 X (README.md참고)
- [ ] Java Enum 적용
- [ ] 도메인 로직에 단위 테스트 구현