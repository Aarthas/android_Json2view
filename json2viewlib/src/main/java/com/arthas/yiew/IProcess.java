package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.decode.YiewBean;

public  interface IProcess {
        View createView(Context context, ViewGroup parent, YiewBean yiew,YiewStore yiewStore);
    }