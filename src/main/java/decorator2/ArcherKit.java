package decorator2;

public class ArcherKit extends Kit {

  private Player player;

  public ArcherKit(Player player) {
    this.player = player;
  }

  @Override
  public int getShotsCount() {
    return 10 + player.getShotsCount();
  }
}
