package com.arthas.xjsonview.process.list;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdapterHelper extends RecyclerView.ViewHolder {
    protected final Context context;
    private SparseArray<View> views;

    public AdapterHelper(View itemView) {
        super(itemView);
        this.views = new SparseArray<View>();
        context = itemView.getContext();
    }

    public Context getContext() {
        return getView().getContext();
    }

    public Activity getActivity() {
        return (Activity) getView().getContext();
    }



    public <T extends View> T getView(int viewId) {
        return retrieveView(viewId);
    }

    public <T extends View> T getView() {
        return (T) itemView;
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }


    public void setText(int viewId, String value) {
        TextView view = retrieveView(viewId);
        view.setText(value);
    }

    public void setHint(int viewId, String value) {
        TextView view = retrieveView(viewId);
        view.setHint(value);
    }

    /**
     * Will set the image of an ImageView from a resource id.
     *
     * @param viewId     The view id.
     * @param imageResId The image resource id.
     * @return The void for chaining.
     */
    public void setImageResource(int viewId, int imageResId) {
        ImageView view = retrieveView(viewId);
        view.setImageResource(imageResId);
    }

    /**
     * Will set background color of a view.
     *
     * @param viewId The view id.
     * @param color  A color, not a resource id.
     * @return The void for chaining.
     */
    public void setBackgroundColor(int viewId, int color) {
        View view = retrieveView(viewId);
        view.setBackgroundColor(color);
    }

    public void setBackground(int viewId, Drawable drawable) {
        View view = retrieveView(viewId);
        view.setBackgroundDrawable(drawable);
    }

    /**
     * Will set background of a view.
     *
     * @param viewId        The view id.
     * @param backgroundRes A resource to use as a background.
     * @return The void for chaining.
     */
    public void setBackgroundRes(int viewId, int backgroundRes) {
        View view = retrieveView(viewId);
        view.setBackgroundResource(backgroundRes);

    }

    public void setEnabled(int viewId, boolean enabled)
    {
        View view = retrieveView(viewId);
        view.setEnabled(enabled);
    }

    public void setTextColor(int viewId, int textColor) {
        TextView view = retrieveView(viewId);
        view.setTextColor(textColor);
    }


    /**
     * Will set the image of an ImageView from a drawable.
     *
     * @param viewId   The view id.
     * @param drawable The image drawable.
     * @return The void for chaining.
     */
    public void setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = retrieveView(viewId);
        view.setImageDrawable(drawable);

    }



    /**
     * Will download an image from a URL and put it in an ImageView.<br/>
     * It uses Square's Picasso library to download the image asynchronously and put the result
     * into the ImageView.<br/>
     * Picasso manages recycling of views in a ListView.<br/>
     * If you need more control over the Picasso settings, use {void#setImageBuilder}.
     *
     * @param viewId   The view id.
     * @param imageUrl The image URL.
     * @return The void for chaining.
     */
    public void setImageUrl(int viewId, String imageUrl) {
        ImageView view = retrieveView(viewId);
//        ImageHandler.display(context, view, imageUrl);
    }


    /**
     * Add an action to set the image of an image view. Can be called multiple times.
     */
    public void setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = retrieveView(viewId);
        view.setImageBitmap(bitmap);

    }

    /**
     * Add an action to set the alpha of a view. Can be called multiple times.
     * Alpha between 0-1.
     */
    public void setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            retrieveView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            retrieveView(viewId).startAnimation(alpha);
        }

    }

    public void setSelect(int viewId, boolean isSelected) {
        View view = retrieveView(viewId);
        view.setSelected(isSelected);

    }

    public void setVisible(boolean visible) {
        getView().setVisibility(visible ? View.VISIBLE : View.GONE);

    }

    /**
     * Set a view visibility to VISIBLE (true) or GONE (false).
     *
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for GONE.
     * @return The void for chaining.
     */
    public void setVisible(int viewId, boolean visible) {
        View view = retrieveView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);

    }

    public boolean getVisible(int viewId) {
        View view = retrieveView(viewId);
        return view.getVisibility() == View.VISIBLE;
    }

    /**
     * Add links into a TextView.
     *
     * @param viewId The id of the TextView to linkify.
     * @return The void for chaining.
     */
    public void linkify(int viewId) {
        TextView view = retrieveView(viewId);
        Linkify.addLinks(view, Linkify.ALL);

    }

    /**
     * Apply the typeface to the given viewId, and enable subpixel rendering.
     */
    public void setTypeface(int viewId, Typeface typeface) {
        TextView view = retrieveView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

    }

    /**
     * Apply the typeface to all the given viewIds, and enable subpixel rendering.
     */
    public void setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = retrieveView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }

    }

    /**
     * Sets the progress of a ProgressBar.
     *
     * @param viewId   The view id.
     * @param progress The progress.
     * @return The void for chaining.
     */
    public void setProgress(int viewId, int progress) {
        ProgressBar view = retrieveView(viewId);
        view.setProgress(progress);

    }

    /**
     * Sets the progress and max of a ProgressBar.
     *
     * @param viewId   The view id.
     * @param progress The progress.
     * @param max      The max value of a ProgressBar.
     * @return The void for chaining.
     */
    public void setProgress(int viewId, int progress, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);
        view.setProgress(progress);

    }

    /**
     * Sets the range of a ProgressBar to 0...max.
     *
     * @param viewId The view id.
     * @param max    The max value of a ProgressBar.
     * @return The void for chaining.
     */
    public void setMax(int viewId, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);

    }

    /**
     * Sets the rating (the number of stars filled) of a RatingBar.
     *
     * @param viewId The view id.
     * @param rating The rating.
     * @return The void for chaining.
     */
    public void setRating(int viewId, float rating) {
        RatingBar view = retrieveView(viewId);
        view.setRating(rating);

    }

    /**
     * Sets the rating (the number of stars filled) and max of a RatingBar.
     *
     * @param viewId The view id.
     * @param rating The rating.
     * @param max    The range of the RatingBar to 0...max.
     * @return The void for chaining.
     */
    public void setRating(int viewId, float rating, int max) {
        RatingBar view = retrieveView(viewId);
        view.setMax(max);
        view.setRating(rating);

    }

    /**
     * Sets the on click listener of the view.
     *
     * @param viewId   The view id.
     * @param listener The on click listener;
     * @return The void for chaining.
     */
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnClickListener(listener);

    }

    public void setOnClickListener(View.OnClickListener listener) {
        getView().setOnClickListener(listener);

    }

    /**
     * Sets the on touch listener of the view.
     *
     * @param viewId   The view id.
     * @param listener The on touch listener;
     * @return The void for chaining.
     */
    public void setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = retrieveView(viewId);
        view.setOnTouchListener(listener);

    }

    /**
     * Sets the on long click listener of the view.
     *
     * @param viewId   The view id.
     * @param listener The on long click listener;
     * @return The void for chaining.
     */
    public void setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnLongClickListener(listener);

    }

    public void setOnLongClickListener(View.OnLongClickListener listener) {
        getView().setOnLongClickListener(listener);

    }

    /**
     * Sets the tag of the view.
     *
     * @param viewId The view id.
     * @param tag    The tag;
     * @return The void for chaining.
     */
    public void setTag(int viewId, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(tag);

    }

    /**
     * Sets the tag of the view.
     *
     * @param viewId The view id.
     * @param key    The key of tag;
     * @param tag    The tag;
     * @return The void for chaining.
     */
    public void setTag(int viewId, int key, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(key, tag);

    }

    /**
     * Sets the checked status of a checkable.
     *
     * @param viewId  The view id.
     * @param checked The checked status;
     * @return The void for chaining.
     */
    public void setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) retrieveView(viewId);
        view.setChecked(checked);

    }

    /**
     * Sets the adapter of a adapter view.
     *
     * @param viewId  The view id.
     * @param adapter The adapter;
     * @return The void for chaining.
     */
    public void setAdapter(int viewId, Adapter adapter) {
        AdapterView view = retrieveView(viewId);
        view.setAdapter(adapter);

    }


    public void show() {
        getView().setVisibility(View.VISIBLE);
    }

    public void gone() {
        getView().setVisibility(View.GONE);
    }

    public int getDataPosition() {

        return (int) getView().getTag();
    }
}