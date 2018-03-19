package com.omvp.app.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.omvp.app.BuildConfig;
import com.omvp.app.injector.module.HelperModule;
import com.omvp.app.injector.module.InterceptorActivityModule;
import com.omvp.app.injector.module.UseCaseModule;
import com.omvp.app.injector.scope.PerActivity;
import com.omvp.app.util.DisposableManager;
import com.omvp.app.util.TrackerManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Module;
import dagger.Provides;

/**
 * Provides base activity dependencies. This must be included in all activity modules, which must
 * provide a concrete implementation of {@link Activity}.
 */
@Module(includes = {
        InterceptorActivityModule.class,
        UseCaseModule.class,
        HelperModule.class
})
public abstract class BaseActivityModule {

    @Provides
    @PerActivity
    static Resources resources(Activity activity) {
        return activity.getResources();
    }

    @Provides
    @PerActivity
    static Bundle activityExtras(Activity activity) {
        return activity.getIntent() != null && activity.getIntent().getExtras() != null ? activity.getIntent().getExtras() : new Bundle();
    }

    @Provides
    @PerActivity
    static RxPermissions rxPermission(Activity activity) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.setLogging(BuildConfig.DEBUG);
        return rxPermissions;
    }

    @Provides
    @PerActivity
    static DisposableManager activityDisposableManager() {
        return new DisposableManager();
    }

    @Provides
    @PerActivity
    static TrackerManager trackerManager(Activity activity, Tracker tracker, FirebaseAnalytics firebaseAnalytics) {
        return new TrackerManager(activity, tracker, firebaseAnalytics);
    }

}
