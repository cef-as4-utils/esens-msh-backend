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
  public String details;


  @Override
  public String toString() {
    return "Message ID [" + messageId + "], Status: [" + status + "]";
  }

  /**
   * The enum that indicates the status of a message previously submitted
   * by a backend to its MSH. The MSH is responsible in informing the producer about
   * the fate of the message. If the has successfully sent to and received by the RMSH
   * then the {@link MessageNotification#status} field has to be {@link esens.wp6.esensMshBackend.MessageNotification.MessageDeliveryStatus#SUCCESS},
   * otherwise {@link esens.wp6.esensMshBackend.MessageNotification.MessageDeliveryStatus#FAIL}.
   *
   * @see esens.wp6.esensMshBackend.BackendListener#processNotification(MessageNotification)
   */
  public static enum MessageDeliveryStatus {
    SUCCESS, FAIL
  }
}
