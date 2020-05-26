package decorator2;

public class Main {
  public static void main(String[] args) {
    Player player = new ArcherKit(new FirstPlayer());
    System.out.println("count = " + player.getShotsCount());
  }
}
