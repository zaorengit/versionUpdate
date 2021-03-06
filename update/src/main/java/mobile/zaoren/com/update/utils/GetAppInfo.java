package mobile.zaoren.com.update.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;


/**
 * Created by Administrator on 2016/8/10.
 */
public class GetAppInfo {
    /**
     * 获取应用包名
     *
     * @param context
     * @return
     */
    public static String getAppPackageName(Context context) {
        Log.i("tag", "packageName=" + context.getPackageName());
        return context.getPackageName();
    }

    /**
     * 获取应用名称
     *
     * @param context
     * @return
     */
    public static String getAppName(Context context) {
        String appName = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getAppPackageName(context), 0);
            appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            if (appName.length() <= 0)
                return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.i("tag", "appName=" + appName);
        return appName;
    }

    /**
     * 获取版本名称
     *
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getAppPackageName(context), 0);
            versionName = packageInfo.versionName;
            if (versionName.length() <= 0)
                return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本号，比较确定是不是最新版本
     *
     * @param context
     * @return
     */
    public static Integer getAppVersionCode(Context context) {
        Integer versionCode = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getAppPackageName(context), 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取当前版本包名
     *
     * @param context
     * @param apkPath
     * @return
     */
    public static String getAPKPackageName(Context context, String apkPath) {
        PackageManager pm = context.getPackageManager();
        PackageInfo info = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
        if (info != null) {
            ApplicationInfo appInfo = info.applicationInfo;
            return appInfo.packageName;
        }
        return null;
    }
//
//    /*
//      * 获取程序 图标
//      */
//    public static Drawable getAppIcon(Context context) {
//        PackageInfo packageInfo;
//        PackageManager packageManager = context.getPackageManager();
//        ApplicationInfo applicationInfo;
//        Drawable icon = ContextCompat.getDrawable(context, android.R.drawable.ic_menu_info_details);
//        try {
//            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
//            String packageNames = packageInfo.packageName;
//            applicationInfo = packageManager.getApplicationInfo(packageNames, 0);
//            icon = applicationInfo.loadIcon(packageManager);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return icon;
//    }

}
