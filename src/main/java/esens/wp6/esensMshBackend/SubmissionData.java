package esens.wp6.esensMshBackend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
  public boolean isPingMessage;
  public String refToMessageId;
  public String conversationId;
  public String messageId;
  public String to;
  public String from;
  public String pModeId;

  private List<Payload> payloads = new ArrayList<>();

  public static SubmissionData createPingMessage() {
    final SubmissionData metadata = new SubmissionData();
    metadata.isPingMessage = true;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient) {
    final SubmissionData metadata = new SubmissionData();
    metadata.isPingMessage = false;
    metadata.originalSender = originalSender;
    metadata.finalRecipient = finalRecipient;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String refToMessageId) {
    final SubmissionData metadata = create(originalSender, finalRecipient);
    metadata.refToMessageId = refToMessageId;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String refToMessageId,
                                      String conversationId) {
    final SubmissionData metadata = create(originalSender, finalRecipient, refToMessageId);
    metadata.conversationId = conversationId;
    return metadata;
  }

  public static SubmissionData create(String originalSender, String finalRecipient, String refToMessageId,
                                      String conversationId, String messageId) {
    final SubmissionData metadata = create(originalSender, finalRecipient, refToMessageId, conversationId);
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

  public void add(Payload payload) {
    payloads.add(payload);
  }

}

