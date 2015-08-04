package esens.wp6.genericAS4BackendClient;

import esens.wp6.genericAS4BackendClient.BackendListener;

import java.util.List;

/**
 * This class represents a the backend of an MSH that provides
 * the basic functionality of sending and receiving messages and
 * retrieving information about the submitted messages
 *
 * @author: yerlibilgin
 * @date: 04/08/15.
 */
public abstract class AbstractMSHBackend {

  /**
   * A list of backend listeners that will be updated
   * when a message or a status update is received
   */
  private List<BackendListener> backendListeners;

  /**
   * When called, notifies all the backend listeners about the reception
   * of a new message carried by the SubmissionData object.
   *
   * @param submissionData
   */
  public void receive(SubmissionData submissionData) {
    for (BackendListener listener : backendListeners) {
      listener.receiveMessage(submissionData);
    }
  }

  /**
   * When called, notifies all the backend listeners about the status of a message previously submitted to the MSH.
   * If the message has successfully received by the RMSH and the SMSH has received a NR receipt
   * then the {@link esens.wp6.genericAS4BackendClient.MessageStatus#status} field is
   * {@link esens.wp6.genericAS4BackendClient.MessageStatus.MessageStatusEnum#SUCCESS}, otherwise
   * {@link esens.wp6.genericAS4BackendClient.MessageStatus.MessageStatusEnum#FAIL}
   *
   * @param status
   */
  public void updateMessageStatus(MessageStatus status) {
    for (BackendListener listener : backendListeners) {
      listener.updateMessageStatus(status);
    }
  }

  /**
   * This method is used by the backend clients to submit messages to the MSH.
   * The implementers of this class have to convert the submissiondata
   * to some representation that is agreed on, for the communication with the MSH.
   *
   * @param submissionData
   * @return
   */
  public abstract String submitMessage(SubmissionData submissionData);

}
