package testdata;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;


public class PropsUtils {

    public static Properties loadProps() {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("src/test/resources/Conf.properties");
//            FileInputStream in = new FileInputStream("Conf.properties");

//            FileInputStream in = new FileInputStream("./src/test/resources/Conf.properties");
//            properties.load(Class.forName("PropsUtils").getResourceAsStream("Conf.properties"));

            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static int getDefaultTimeout() {
        return Integer.parseInt(loadProps().getProperty("DefaultTimeout"));
    }

    public static String getURL(String site) {
        String url = null;
        switch (site){
            case "OfficialUrl":
                url = loadProps().getProperty("OfficialUrl");
                break;
            case "ShopUrl":
                url = loadProps().getProperty("ShopUrl");
                break;
            case "ContactUsUrl":
                url = loadProps().getProperty("ContactUsUrl");
                break;
            case "EPPUrl":
                url = loadProps().getProperty("EPPUrl");
                break;
        }
//        return loadProps().getProperty(site);
        return url;
    }



//    public static String getTargetStore(String caseName) {
//        if (System.getProperty("onlyRerunFail").toLowerCase().equals("true")) {
//            if (testCaseService == null) {
//                testCaseService = AutoReportImpl
//                        .creatInstance(PropsUtils.getParameter(System.getProperty("environment")));
//            }
//            return testCaseService.getRerunStores(System.getProperty("runId"), caseName, false);
//        } else
//            return System.getProperty("targetStore");
//    }

    /**
     * @Owner Songli
     * @Parameter
     * @Usage Used in data-driven for further check scenarios
     */
//    public static Object[][] getFurtherCheckData() {
//        if (testCaseService == null) {
//            testCaseService = AutoReportImpl
//                    .creatInstance(PropsUtils.getParameter(System.getProperty("environment")));
//        }
//        return testCaseService.getFurtherCheckData();
//    }

//    public static ArrayList<String[]> getTargetStorePayment(String category) {
//        if (System.getProperty("onlyRerunFail").toLowerCase().equals("true")) {
//            if (testCaseService == null) {
//                testCaseService = AutoReportImpl
//                        .creatInstance(PropsUtils.getParameter(System.getProperty("environment")));
//            }
//            return testCaseService.getRerunStoresPayment(System.getProperty("runId"), category, false);
//        } else {
//            ArrayList<String[]> result = new ArrayList<String[]>();
//            result.add(new String[] { "ALL" });
//            return result;
//        }
//
//    }

    public static String getParameter(String parameter) {
        return loadProps().getProperty(parameter);
    }
}
