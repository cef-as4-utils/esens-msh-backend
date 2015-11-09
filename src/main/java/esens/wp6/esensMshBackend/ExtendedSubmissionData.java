package esens.wp6.esensMshBackend;

import esens.wp6.esensMshBackend.Payload;
import esens.wp6.esensMshBackend.SubmissionData;

import java.io.Serializable;
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
public class ExtendedSubmissionData extends SubmissionData {
  public String service;
  public String action;
}

