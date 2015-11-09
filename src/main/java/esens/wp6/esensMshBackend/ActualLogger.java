package esens.wp6.esensMshBackend;

/**
 * @author: yerlibilgin
 * @date: 09/11/15.
 */
public abstract class ActualLogger {
  public abstract void debug(String message);

  public abstract void info(String message);

  public abstract void error(String message);

  public abstract void warn(String message);

  public abstract ActualLogger create(String name);

  public abstract void error(String message, Throwable th);

  public abstract void warn(String message, Throwable th);
}
