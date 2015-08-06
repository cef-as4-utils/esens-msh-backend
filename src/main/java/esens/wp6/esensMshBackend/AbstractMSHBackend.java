package esens.wp6.esensMshBackend;

import java.util.ArrayList;
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
  private List<BackendListener> backendListeners = new ArrayList<>();

  /**
   * When called, notifies all the backend listeners about the reception
   * of a new message carried by the SubmissionData object.
   *
   * @param submissionData
   */
  public void deliver(SubmissionData submissionData) {
    for (BackendListener listener : backendListeners) {
      listener.deliver(submissionData);
    }
  }


  /**
   * The party id (or the name) of the gateway that we are connecting to.
   * @return
   */
  public abstract String getGatewayID();

  /**
   * When called, notifies all the backend listeners about the status of a message previously submitted to the MSH.
   * If the message has successfully received by the RMSH and the SMSH has received a NR receipt
   * then the {@link MessageNotification#status} field is
   * {@link esens.wp6.esensMshBackend.MessageNotification.MessageDeliveryStatus#SUCCESS}, otherwise
   * {@link esens.wp6.esensMshBackend.MessageNotification.MessageDeliveryStatus#FAIL}
   *
   * @param status
   */
  public void processNotification(MessageNotification status) {
    for (BackendListener listener : backendListeners) {
      listener.processNotification(status);
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

  public void addBackendListener(BackendListener listener) {
    backendListeners.add(listener);
  }

  public void removeBackendListener(BackendListener listener) {
    backendListeners.remove(listener);
  }


  /**
   * Conventional method for finishing after a backend interaction.
   * Override it if you want to do specific things then.
   */
  public void release() {

  }
}