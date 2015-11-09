package esens.wp6.esensMshBackend;

import java.util.Properties;

/**
 * @author: yerlibilgin
 * @date: 05/08/15.
 */
public class BackendLauncher {
  public static void initialize(Properties properties) throws Exception {
    Class<AbstractMSHBackendAdapter> clas = (Class<AbstractMSHBackendAdapter>) Class.forName(properties.getProperty("BACKEND_ADAPTER_CLASS"));
    AbstractMSHBackendAdapter client = clas.newInstance();

    Class<AbstractMSHBackend> clas2 = (Class<AbstractMSHBackend>) Class.forName(properties.getProperty("BACKEND_CLASS"));
    AbstractMSHBackend backend = clas2.newInstance();

    client.setMshBackend(backend);
    client.initialize(properties);
  }

  public static void initialize(Properties properties, ClassLoader classLoader) throws Exception {
    Class<AbstractMSHBackendAdapter> clas = (Class<AbstractMSHBackendAdapter>) classLoader.loadClass(properties.getProperty("BACKEND_ADAPTER_CLASS"));
    AbstractMSHBackendAdapter client = clas.newInstance();

    Class<AbstractMSHBackend> clas2 = (Class<AbstractMSHBackend>) classLoader.loadClass(properties.getProperty("BACKEND_CLASS"));
    AbstractMSHBackend backend = clas2.newInstance();

    client.setMshBackend(backend);
    client.initialize(properties);
  }
}
