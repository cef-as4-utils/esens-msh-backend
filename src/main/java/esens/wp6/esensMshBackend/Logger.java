package esens.wp6.esensMshBackend;

/**
 * @author: yerlibilgin
 * @date: 09/11/15.
 */
public class Logger {
  public static ActualLogger actualLogger;

  public static void debug(String message) {
    if (actualLogger != null) {
      actualLogger.debug(message);
    }
  }

  public static void info(String message) {
    if (actualLogger != null) {
      actualLogger.info(message);
    }
  }

  public static void error(String message) {
    if (actualLogger != null) {
      actualLogger.error(message);
    }
  }

  public static void warn(String message) {
    if (actualLogger != null) {
      actualLogger.warn(message);
    }
  }
  public static void error(String message, Throwable th) {
    if (actualLogger != null) {
      actualLogger.error(message, th);
    }
  }

  public static void warn(String message, Throwable th) {
    if (actualLogger != null) {
      actualLogger.warn(message, th);
    }
  }


  public static NonStaticLogger createLogger(String name) {
    return new NonStaticLogger(name);
  }

  private Logger(String name) {

  }

 public static class NonStaticLogger {
    ActualLogger actualLoggerPrefix;

    NonStaticLogger(String name) {
      if (actualLogger != null)
        actualLoggerPrefix = actualLogger.create(name);
    }

    public void debug(String message) {
      if (actualLoggerPrefix != null) {
        actualLoggerPrefix.debug(message);
      }
    }

    public void info(String message) {
      if (actualLoggerPrefix != null) {
        actualLoggerPrefix.info(message);
      }
    }

    public void error(String message) {
      if (actualLoggerPrefix != null) {
        actualLoggerPrefix.error(message);
      }
    }

    public void warn(String message) {
      if (actualLoggerPrefix != null) {
        actualLoggerPrefix.warn(message);
      }
    }
    public void error(String message, Throwable th) {
      if (actualLoggerPrefix != null) {
        actualLoggerPrefix.error(message, th);
      }
    }

    public void warn(String message, Throwable th) {
      if (actualLoggerPrefix != null) {
        actualLoggerPrefix.warn(message, th);
      }
    }

  }
}
