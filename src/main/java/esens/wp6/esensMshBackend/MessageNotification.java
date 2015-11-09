package esens.wp6.esensMshBackend;

import java.io.Serializable;

/**
 * Carries the information about a submission of a message
 *
 * @author: yerlibilgin
 * @date: 26/07/15.
 */
public class MessageNotification implements Serializable {
  /**
   * The ebms message id
   */
  public String messageId;

  /**
   * Status: SUCCESS, FAIL
   */
  public MessageDeliveryStatus status;

  /**
   * Error code that will be provided by the MSH to the backend
   */
  public String errorCode;

  /**
   * in case of success empty string or null. <br>
   * in case of failure the error description (if any)
   */
  public String shortDescription;
  public String description;


  @Override
  public String toString() {
    return "Message ID [" + messageId + "], Status: [" + status + "]";
  }

}
