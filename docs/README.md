## 🛠 기능 요구 사항 🛠
- [✔] 1~45까지 중복되지 않은 6개의 숫자를 랜덤으로 뽑아 로또를 생성한다. -> Generator - createLottoNumbers
- [✔] 로또 구입금액을 입력받는다. UserInput - amountInput  
- [✔] 1000원당 하나의 로또를 구입한다. Buyer - buyLottos 
- [✔] 쉼표(,)로 구분된 6개의 당첨번호를 입력받는다. UserInput - inputTargetNumbers
- [✔] 보너스 번호를 입력 받는다. UserInput - inputBonusNumber
- [✔] 1등부터 5등까지의 당첨을 확인한다. Compare - compareNumbers
  - 1등: 번호 6개 일치
  - 2등: 번호 5개 일치, 보너스 번호 일치
  - 3등: 번호 5개 일치
  - 4등: 번호 4개 일치
  - 5등: 번호 3개 일치
- [] 구매한 로또의 개수와 각 로또의 번호를 출력한다. UserOutput - printLottos
- [] 당첨내역을 출력한다. UserOutput - printWinningLists
- [] 수익률을 출력한다. UserOutput - printRateOfReturns


## 공부 목록
- 패키지 분리
- this, 상수(static final) 사용
- Java Enum 클래스와 사용법
- 도메인 로직 및 도메인 설계에 대한 내용
- 도메인 단위의 단위테스트
- 단일 기능 함수
- 일급 컬렉션
- 클래스 분할 및 객체지향적 설계