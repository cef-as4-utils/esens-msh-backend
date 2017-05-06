package esens.wp6.esensMshBackend;

import java.util.Properties;

/**
 * A generic msh backend client that can be implemented by real clients (such as Minder Backend Client)
 *
 * @author: yerlibilgin
 * @date: 04/08/15.
 */
public abstract class AbstractMSHBackendAdapter implements BackendListener {

  private AbstractMSHBackend mshBackend;

  public void submitMessage(SubmissionData submissionData) {
    mshBackend.submitMessage(submissionData);
  }

  /**
   * Sets the current mshBackend for this client and adds this client
   * as a backend listener to the mshBackend. This client will
   * deliver the messages and submitted message updates.
   *
   * @param mshBackend
   */
  public void setMshBackend(AbstractMSHBackend mshBackend) {
    this.mshBackend = mshBackend;
    this.mshBackend.addBackendListener(this);
  }

  /**
   * If the backend client needs a special initalization routine, it might override this method.
   * <p>
   * The default implementation does noth'n
   */
  public void initialize(Properties properties) {

  }

  public final void startTest(Object context) {
    mshBackend.startTest(context);
    onStartTest(context);
  }

  protected void onStartTest(Object context){

  }

  public final void finishTest(Object context) {
    mshBackend.finishTest(context);
    onFinishTest(context);
  }

  protected void onFinishTest(Object context) {
  }
}
