package testdata;

public class ShopData extends DataCommon{

    @Override
    public String getHomePageUrl() {
        return "h";
    }

    @Override
    public String getProductionUrl() {
        return "https://";
    }

    @Override
    public String getloginPageUrl() {
        return "";
    }

    @Override
    public String getLoginId() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getTeleLoginId() {
        return null;
    }

    @Override
    public String getTelePassword() {
        return null;
    }

    @Override
    public void setCurrentRunCasename(String name) {

    }

    @Override
    public String getDefaultMTMPN() {
        return null;
    }
}
