package esens.wp6.esensMshBackend;

/**
 * @author: yerlibilgin
 * @date: 04/08/15.
 */
public interface BackendListener {
  /**
   * Fired by the MSH backend when a message is received from
   * the MSH. The MSH does not have to send a SubmissionData
   * object directly via a protocol like RMI. The implementers of backend are responsible
   * to parse the messages (or events) received from their MSH's into a SubmissionData object
   *
   * @param submissionData
   * The SubmissionData instance that contains information about the received message
   */
  public void deliver(SubmissionData submissionData);


  /**
   * Fired by the MSH backend upon receiving information about a message
   * previously submitted to the MSH. The distinction is done by the {@link MessageNotification#messageId}
   *
   *
   * @param messageNotification
   */
  public void processNotification(MessageNotification messageNotification);
}
