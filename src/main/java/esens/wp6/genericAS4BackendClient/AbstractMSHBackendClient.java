package esens.wp6.genericAS4BackendClient;

/**
 *
 * A generic msh backend client that can be implemented by real clients (such as Minder Backend Client)
 * @author: yerlibilgin
 * @date: 04/08/15.
 */
public abstract class AbstractMSHBackendClient implements BackendListener {

  private AbstractMSHBackend mshBackend;

  public void submitMessage(SubmissionData submissionData) {
    mshBackend.submitMessage(submissionData);
  }

  /**
   * Sets the current mshBackend for this client and adds this client
   * as a backend listener to the mshBackend. This client will
   * receive the messages and submitted message updates.
   *
   * @param mshBackend
   */
  public void setMshBackend(AbstractMSHBackend mshBackend) {
    this.mshBackend = mshBackend;
    this.mshBackend.addBackendListener(this);
  }

}
