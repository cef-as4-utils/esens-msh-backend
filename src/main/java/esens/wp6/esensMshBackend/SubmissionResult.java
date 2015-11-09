package esens.wp6.esensMshBackend;

import java.io.Serializable;

/**
 * @author: yerlibilgin
 * @date: 30/10/15.
 */
public class SubmissionResult implements Serializable {
  public String ebmsMessageId;
  public SubmissionError error;
}

