package starter.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String targetEnv;
    private static String url;
    private static String SuperAdminPassword;
    private static String SuperAdminUsername;

    private InputStream iStream;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties props = new Properties();

        try {
            setTargetEnv("qa");
            //setTargetEnv("trial");
        }

        catch (IllegalArgumentException e) {
            System.err.println("FAILED - Loading Params: " + e.getMessage());
        }

        try {
            iStream = this.getClass().getClassLoader()
                    .getResourceAsStream("props/" + targetEnv + "/env.properties");
            System.out.println(iStream.toString());
            props.load(iStream);

            // Super Admin
            SuperAdminUsername = props.getProperty("SuperAdminUsername");
            SuperAdminPassword = props.getProperty("SuperAdminPassword");
        }

        catch (IOException e) {
            System.err.println("FAILED - Loaded Properties Files: " + e.getMessage());
        }

        finally {
            if (iStream != null) {
                try {
                    iStream.close();
                }

                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setTargetEnv(String env) {
        String str = env.toLowerCase();

        switch (str) {
            case "qa":
                targetEnv = "qa";
                break;
            case "trial":
                targetEnv = "trial";
                break;
        }
    }

    public String getTargetEnv() {
        return targetEnv;
    }

    public String getSuperAdminPassword() {
        return SuperAdminPassword;
    }

    public String getSuperAdminUsername() {
        return SuperAdminUsername;
    }
}
