package esens.wp6.genericAS4BackendClient;

import java.io.Serializable;

/**
 * Carries the information about a submission of a message
 *
 * @author: yerlibilgin
 * @date: 26/07/15.
 */
public class MessageStatus implements Serializable {
  /**
   * The ebms message id
   */
  public String messageId;

  /**
   * Status: SUCCESS, FAIL
   */
  public MessageStatusEnum status;

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
   * then the {@link MessageStatus#status} field has to be {@link MessageStatusEnum#SUCCESS},
   * otherwise {@link MessageStatusEnum#FAIL}.
   *
   * @see esens.wp6.genericAS4BackendClient.BackendListener#updateMessageStatus(MessageStatus)
   */
  public static enum MessageStatusEnum {
    SUCCESS, FAIL
  }
}
