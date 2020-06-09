package com.example.softtrigger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class Restarter extends BroadcastReceiver {
    private static final String DATAWEDGE_ACTION = "com.symbol.datawedge.api.ACTION";
    private static final String DATAWEDGE_EXTRA_KEY_SCANNER_TRIGGER_CONTROL = "com.symbol.datawedge.api.SOFT_SCAN_TRIGGER";
    private static final String DATAWEDGE_EXTRA_VALUE_TOGGLE_SCANNER = "TOGGLE_SCANNING";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Broadcast Listened", "Service tried to stop");
        Toast.makeText(context, "Service restarted", Toast.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, SoftTriggerScan.class));
        } else {
            context.startService(new Intent(context, SoftTriggerScan.class));
        }
    }
}