package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by zhangyn on 17/3/28.
 */

public class YiewEngine {


    public static View createmyiew(Context context, ViewGroup parent, Yiew yiew) {


        switch (yiew.view) {
            case "verticalLayout": {


                LinearLayout view = new LinearLayout(context);
                view.setOrientation(LinearLayout.VERTICAL);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);
                DynamicHelper.applyLinearLayout(view, yiew);




                if (yiew.child != null && yiew.child.size() > 0) {
                    for (Yiew yiew1 : yiew.child) {
                        View childview = createmyiew(context, view, yiew1);
                        if (childview != null)
                            view.addView(childview);
                    }

                }
                return view;

            }

            case "horizonLayout": {
                LinearLayout view = new LinearLayout(context);
                view.setOrientation(LinearLayout.HORIZONTAL);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);
                DynamicHelper.applyLinearLayout(view, yiew);


                if (yiew.child != null && yiew.child.size() > 0) {
                    for (Yiew yiew1 : yiew.child) {
                        View childview = createmyiew(context, view, yiew1);
                        if (childview != null)
                            view.addView(childview);
                    }

                }
                return view;

            }


            case "TextView": {
                TextView view = new TextView(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);

                DynamicHelper.applyTextView(view, yiew);


                return view;
            }

            case "ImageView": {
                ImageView view = new ImageView(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);
                DynamicHelper.applyImageView(view, yiew);


                return view;

            }
            case "Line": {
                View view = new View(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);


                return view;

            }
            case "View": {
                View view = new View(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);


                return view;

            }
            case "ScrollView": {
                ScrollView view = new ScrollView(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);

                view.setVerticalFadingEdgeEnabled(false);
                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                view.setFadingEdgeLength(0);

                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);

                view.setVerticalFadingEdgeEnabled(false);
                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                view.setFadingEdgeLength(0);


                if (yiew.child != null && yiew.child.size() > 0) {
                    for (Yiew yiew1 : yiew.child) {
                        View childview = createmyiew(context, view, yiew1);
                        if (childview != null)
                            view.addView(childview);
                    }

                }
                return view;

            }
            case "scrollView": {
                ScrollView view = new ScrollView(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);

                view.setVerticalFadingEdgeEnabled(false);
                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                view.setFadingEdgeLength(0);


                Yiew verticalLayoutyiew = new Yiew();
                verticalLayoutyiew.width = "match";
                verticalLayoutyiew.height = "match";
                verticalLayoutyiew.view = "verticalLayout";
                ViewGroup verticalLayout = (ViewGroup) createmyiew(context, view, verticalLayoutyiew);
                view.addView(verticalLayout);

                if (yiew.child != null && yiew.child.size() > 0) {
                    for (Yiew yiew1 : yiew.child) {
                        View childview = createmyiew(context, verticalLayout, yiew1);
                        if (childview != null)
                            verticalLayout.addView(childview);
                    }

                }
                return view;

            }
            case "RelativeLayout": {
                RelativeLayout view = new RelativeLayout(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);
                DynamicHelper.applyRelativeLayout(view, yiew);

                if (yiew.child != null && yiew.child.size() > 0) {
                    for (Yiew yiew1 : yiew.child) {
                        View childview = createmyiew(context, view, yiew1);
                        if (childview != null)
                            view.addView(childview);
                    }

                }
                return view;
            }

            case "FrameLayout": {
                FrameLayout view = new FrameLayout(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                DynamicHelper.applyaLayout(view, params, yiew);
                DynamicHelper.applyView(view, yiew);




                if (yiew.child != null && yiew.child.size() > 0) {
                    for (Yiew yiew1 : yiew.child) {
                        View childview = createmyiew(context, view, yiew1);
                        if (childview != null)
                            view.addView(childview);
                    }

                }
                return view;
            }


            default:
                break;
        }

        return null;
    }
}
