package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.Yiew;

public  interface IComponent {
        View createView(Context context, ViewGroup parent, Yiew yiew);
    }