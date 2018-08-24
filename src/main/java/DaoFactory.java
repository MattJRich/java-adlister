public class DaoFactory {
    private static Ads adsDao;
    private static Config adsConfig = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(adsConfig);
        }
        return adsDao;
    }

}
