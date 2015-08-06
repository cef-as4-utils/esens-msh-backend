package esens.wp6.esensMshBackend;

import java.util.Properties;

/**
 * @author: yerlibilgin
 * @date: 05/08/15.
 */
public class BackendLauncher {
  public static void initialize(Properties properties) throws Exception {
    Class<AbstractMSHBackendClient> clas = (Class<AbstractMSHBackendClient>) Class.forName(properties.getProperty("BACKEND_CLIENT_CLASS"));
    AbstractMSHBackendClient client = clas.newInstance();

    Class<AbstractMSHBackend> clas2 = (Class<AbstractMSHBackend>) Class.forName(properties.getProperty("BACKEND_CLASS"));
    AbstractMSHBackend backend = clas2.newInstance();

    backend.addBackendListener(client);
    client.setMshBackend(backend);
    client.initialize();
  }
}
