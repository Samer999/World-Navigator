package Controllers.GameTimer;

public class GameTimer extends Thread {

  private int seconds;
  private boolean timeOut;

  public GameTimer(int seconds) {
    setSeconds(seconds);
  }

  @Override
  public void run() {

    while (seconds > 0) {
      removeSeconds(1);

      try {

        sleep(1000);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    timeOut = true;
  }

  public boolean isTimeOut() {
    return timeOut;
  }

  public void setSeconds(int seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("seconds value is invalid!");
    }

    synchronized (this) {
      this.seconds = seconds;
    }
  }

  public int getRemainingSeconds() {
    return seconds;
  }

  public void addSeconds(int seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("seconds value is invalid!");
    }

    synchronized (this) {
      setSeconds(getRemainingSeconds() + seconds);
    }
  }

  public void removeSeconds(int seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("seconds value is invalid!");
    }

    synchronized (this) {
      setSeconds(getRemainingSeconds() - seconds);
    }
  }
}
