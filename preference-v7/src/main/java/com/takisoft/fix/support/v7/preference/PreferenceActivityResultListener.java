package com.takisoft.fix.support.v7.preference;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.preference.Preference;

/**
 *
 */
public interface PreferenceActivityResultListener {
    /**
     * Called when the user clicks on the preference.
     *
     * @param fragment   The preference fragment that shows the preference screen.
     * @param preference The preference instance.
     */
    void onPreferenceClick(@NonNull PreferenceFragmentCompat fragment, @NonNull Preference preference);

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link Activity#RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     *
     * @param requestCode The integer request code originally supplied to startActivityForResult(), allowing you to identify who this result came from.
     * @param resultCode  The integer result code returned by the child activity through its setResult().
     * @param data        An Intent, which can return result data to the caller (various data can be attached to Intent "extras").
     */
    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);
}
