package esens.wp6.esensMshBackend;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class contains all the information necessary for a single message submission.
 * It includes all the payloads and their ids and other data. It is converted to
 * the MSH representations by the Backend Implementers.
 * the
 *
 * @author: muhammet
 * @date: 25/07/15.
 */
public class SubmissionData implements Serializable {
  public String originalSender;
  public String finalRecipient;
  /**
   * Ref to message id - referencing to the previous ebms message id if any
   */
  public String refToMessageId;
  /**
   * Conversation ID
   */
  public String conversationId;
  /**
   * EBMS message ID
   */
  public String messageId;


  /**
   * TO party ID
   */
  public String to;
  /**
   * TO party Role
   */
  public String toPartyRole;
  /**
   * FROM party ID
   */
  public String from;
  /**
   * FROM party ID
   */
  public String fromPartyRole;
  /**
   * This pmode id is used for mapping to service and actions
   */
  public String pModeId;

  public String service;
  public String action;

  /**
   * The payloads to be carried by this submission data
   */
  private List<Payload> payloads = new ArrayList<>();

  /**
   * This field represents the UserMessage/MessageProperties/Property items.
   */
  public Properties properties = new Properties();

  public static SubmissionData create(String originalSender, String finalRecipient) {
    final SubmissionData metadata = new SubmissionData();
    metadata.originalSender = originalSender;
    metadata.finalRecipient = finalRecipient;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String fromPartyId, String toPartyId) {
    final SubmissionData metadata = create(originalSender, finalRecipient);
    metadata.from = fromPartyId;
    metadata.to = toPartyId;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String fromPartyId, String toPartyId, String refToMessageId) {
    final SubmissionData metadata = create(originalSender, finalRecipient, fromPartyId, toPartyId);
    metadata.refToMessageId = refToMessageId;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String fromPartyId, String toPartyId, String refToMessageId,
                                      String conversationId) {
    final SubmissionData metadata = create(originalSender, finalRecipient, fromPartyId, toPartyId, refToMessageId);
    metadata.conversationId = conversationId;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String fromPartyId, String toPartyId, String refToMessageId,
                                      String conversationId, String messageId) {
    final SubmissionData metadata = create(originalSender, finalRecipient, fromPartyId, toPartyId, refToMessageId, conversationId);
    metadata.messageId = messageId;
    return metadata;
  }

  @Override
  public String toString() {
    return "SubmissionData [MSG:" + messageId + ", PMODEID:" + pModeId + ", FROM:" + from + ", TO: " + to + ", ORG_SND:" + originalSender + ", FNL_RCP:" + finalRecipient + ", REFT2MSGID:" + refToMessageId + ", CNVRSID:" + conversationId + "]";
  }

  public List<Payload> getPayloads() {
    return payloads;
  }

  public void removeAllPayloads() {
    payloads.clear();
  }

  public SubmissionData add(Payload payload) {
    payloads.add(payload);
    return this;
  }

  public void addProperty(String name, String value) {
    if (this.properties == null) {
      this.properties = new Properties();
    }

    properties.put(name, value);
  }

}

