package esens.wp6.esensMshBackend;

import java.io.Serializable;

/**
 * This class represents a structure that contains all the necessary information about a payload
 *
 * @author: yerlibilgin
 * @date: 25/07/15.
 */
public class Payload implements Serializable {
  public String payloadId;
  public String mimeType;
  public String characterSet;
  public String contentType;
  public byte[] data;

  @Override
  public String toString() {
    int len = 0;
    if (data != null)
      len = data.length;

    return "Payload [" + payloadId + ", " + mimeType + "], length: " + len;
  }


  public static Payload create(String payloadId, String mimeType, String characterSet, byte[] data) {
    Payload pl = new Payload();
    pl.payloadId = payloadId;
    pl.mimeType = mimeType;
    pl.characterSet = characterSet;
    pl.data = data;
    return pl;
  }

  public static Payload create(String payloadId, String mimeType, byte[] data) {
    Payload pl = new Payload();
    pl.payloadId = payloadId;
    pl.mimeType = mimeType;
    pl.data = data;
    return pl;
  }

  public static Payload create(String payloadId, byte[] data) {
    Payload pl = new Payload();
    pl.payloadId = payloadId;
    pl.data = data;
    return pl;
  }
}
