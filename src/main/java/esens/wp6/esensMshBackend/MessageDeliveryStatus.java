package esens.wp6.esensMshBackend;

/**
 * The enum that indicates the status of a message previously submitted
 * by a backend to its MSH. The MSH is responsible in informing the producer about
 * the fate of the message. If the has successfully sent to and received by the RMSH
 * then the {@link MessageNotification#status} field has to be {@link MessageDeliveryStatus#Receipt},
 * otherwise {@link MessageDeliveryStatus#Error}.
 *
 * @see BackendListener#processNotification(MessageNotification)
 */
public enum MessageDeliveryStatus {
  Submitted, SubmissionFailed, Receipt, Error
}
