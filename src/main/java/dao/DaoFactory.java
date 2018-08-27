package dao;

public class DaoFactory {
    private static Users usersDao;
    private static Ads adsDao;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new UsersDao();
        }
        return usersDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new adsDao();
        }
        return adsDao;
    }



}
