package com.example.fgallet2016.europcar.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class VehiculeService extends Service {
    public VehiculeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
