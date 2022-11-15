package domain.enums;

public enum GameMessage {
   PROMPT_MESSAGE("구입금액을 입력해 주세요.");

   private String gameMessage;

   GameMessage(String gameMessage) {
      this.gameMessage = gameMessage;
   }

   public String getGameMessage() {
      return gameMessage;
   }
}
