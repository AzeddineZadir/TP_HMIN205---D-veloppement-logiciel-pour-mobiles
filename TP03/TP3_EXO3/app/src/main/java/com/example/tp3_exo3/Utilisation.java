package com.example.tp3_exo3;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Utilisation implements LifecycleObserver {
    public static int nbr = 0  ;
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public int nombreUtilisation() {
        return nbr++ ;
    }
}
