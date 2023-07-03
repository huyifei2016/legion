package testdata;
public class TestData {
    public OfficialSiteData officialSiteData = null;
    public ShopData shopData = null;

    public String Environment = null;
    public String Store = null;
    public String Type = null;
    public EnvData envData = null;
    public TestData(String environment, String type, String store) {
        try {
            officialSiteData = (OfficialSiteData) Class.forName("testdata."  + "OfficialSiteData").getDeclaredConstructor().newInstance();
            shopData = (ShopData) Class.forName("testdata."  + "ShopData").getDeclaredConstructor().newInstance();

//            CTO = (CTOData) Class.forName("TestData." + environment + ".CTO.Data").newInstance();
//            if (type.toLowerCase().equals("b2b"))
//                B2B = (B2BData) Class.forName("TestData." + environment + ".B2B." + store + ".Data").newInstance();
//            else
//                B2C = (B2CData) Class.forName("TestData." + environment + ".B2C." + store + ".Data").newInstance();
            Environment = environment;
            Store = store;
            Type = type;
//            envData = (EnvData) Class.forName("TestData." + environment + ".EnvData").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}