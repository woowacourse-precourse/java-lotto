# 구현할 기능 목록  
- Lotto 인스턴스를 생성할 때 입력한 numbers integer list 안 번호가 1~45 범위 안에 있는지 확인/검증하는 기능  
  [Lotto.java - validate]
- Lotto 인스턴스 안 정답(로또 당첨 번호)과 여러 개의 로또 번호 리스트들을 비교해 당첨 통계를 Output 으로 내보내는 기능  
  [Lotto.java - produceWinningStatistics]
  > 위 기능을 구현하기 위해 로또 당첨 통계를 저장할 Enum 클래스를 정의해야 한다.
  >  - enum WinningStatistic
  >    - numOfCorrectLottoNumber: 일치하는 로또 번호의 개수
  >    - cashPrize: 상금  

  (콘솔에 당첨/상금 통계를 출력하는 기능은 도메인 로직이 아니라 어플리케이션 서비스 로직이다)
- 정답과 일치하는 로또 번호 개수를 보고 상금을 계산하는 기능  
  (상금 정보는 실시간으로 달라질 수 있기 때문에 Lotto 안에 상금 규칙을 저장하지 않는다.)  
  (상금 정보는 Enum 인스턴스에 저장한다.)

일단 비즈니스 로직 코드부터 작성한다. 하나의 함수 만들면 그 즉시 테스트한다. (JUnit5, AssertJ 사용)

# 구현한 기능 목록
- 없음