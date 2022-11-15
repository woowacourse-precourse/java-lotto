## 구현 기능 목록
- [ ] 로또 구입 금액 입력 받기
    - 로또 1장의 가격: 1000원
    - 1000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException
- [ ] 로또 발행하기
- [ ] 당첨 번호 입력 받기
- [ ] 보너스 번호 입력 받기
- [ ] 구매한 로또와 당첨 번호 비교하기
- [ ] 수익률 계산하기
- [ ] 출력하기

---

## 프로그래밍 요구 사항
* JUnit5, AssertJ 사용해서 테스트
* 메서드의 길이는 15 이하
* else 사용 금지
* Enum 사용
* Random 값 추출은 Randoms.pickUniqueNumbersInRange()
* 사용자 값 입력은 Console.readLine()
* Lotto 클래스 활용
    * NoArgsConstructor 사용 불가능
    * 필드 추가 불가능
    * 메서드 추가 및 변경 가능
    * 패키지 변경 가능
---
## 프로젝트 구조
* lotto
    * controller
        * LottoController
    * domain
        * Answer
        * Lotto
        * Prize
        * User
    * exception
        * LottoError
    * view
        * LottoView
    * Application
    
---
## 도메인
* Answer: 당첨 로또
    * 당첨 로또와 보너스 번호를 입력 및 저장한다.
* User: 로또 구입량, 발행된 로또, 당첨 결과
    * 로또 구입 금액을 입력 및 저장한다.
    * 로또를 발행해서 저장한다.
    * 발행된 로또들의 당첨 결과를 저장한다.
* Prize: 당첨 결과 관리(Enum)
* Lotto: 로또 객체
