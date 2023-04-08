public class Gameloop implements Runnable {

  public static final int FPS = 60;
  public static final long maxLoopTime = 1000 / FPS;
  private static State state = State.START;
  public boolean running = true;
  Spielfeld spielfeld;

  public static void main(String[] arg) {
    Gameloop gameloop = new Gameloop();

    new Thread(gameloop).start();
  }

  @Override
  public void run() {
    long timestamp;
    long oldTimestamp;

    switch (state) {
      case START:
        //DRAW THE START SCREEN
        new Spielfeld();
        break;
      case RUNNING:
        //DRAW THE GAME
        break;
      case PAUSE:
        //DRAW THE PAUSE SCREEN
        break;
      case GAME_OVER:
        //DRAW THE GAME OVER SCREEN
        break;
      default:
        throw new RuntimeException("Unknown state: " + state);
    }

    while (running) {
      oldTimestamp = System.currentTimeMillis();
      update();
      timestamp = System.currentTimeMillis();
      if (timestamp - oldTimestamp > maxLoopTime) {
        System.out.println("Wir sind zu spät!");
        continue;
      }
      render();
      timestamp = System.currentTimeMillis();
      System.out.println(maxLoopTime + " : " + (timestamp - oldTimestamp));
      if (timestamp - oldTimestamp <= maxLoopTime) {
        try {
          Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  void update() {
  }

  void render() {
  }
}
