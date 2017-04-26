package com.reactlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class RNViewMask extends ViewGroup {
    private Bitmap mMaskBitmap = null;
    private BitmapDrawable mMaskImage = null;
    private Paint mPaint = new Paint();
    private PorterDuffXfermode mDuffMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Resources mResources = this.getContext().getResources();

    private int mLastMeasuredWidth = -1, mLastMeasuredHeight = -1;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public RNViewMask(Context context) {
        super(context);
        init();
    }

    public RNViewMask(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RNViewMask(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setLayerType(LAYER_TYPE_HARDWARE, null);

        this.mMaskImage = new BitmapDrawable(
                this.mResources,
                BitmapFactory.decodeResource(this.mResources, R.drawable.hexagon_vertical)
        );
    }

    public void setMask(String maskName) {
        int resID = this.mResources.getIdentifier(maskName, "drawable", getContext().getPackageName());

        this.mMaskImage = new BitmapDrawable(
                this.mResources,
                BitmapFactory.decodeResource(this.mResources, resID)
        );
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        if (this.mMaskImage != null && getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.reloadBitmapMask();

            this.mPaint.setXfermode(this.mDuffMode);
            canvas.drawBitmap(this.mMaskBitmap, 0.0f, 0.0f, this.mPaint);
            this.mPaint.setXfermode(null);
        }
    }

    private void reloadBitmapMask() {
        if (getMeasuredWidth() != this.mLastMeasuredWidth || getMeasuredHeight() != this.mLastMeasuredHeight) {
            if (this.mMaskBitmap != null && !this.mMaskBitmap.isRecycled()) {
                this.mMaskBitmap.recycle();
            }

            this.mMaskBitmap = Bitmap.createBitmap(
                    getMeasuredWidth(),
                    getMeasuredHeight(),
                    Bitmap.Config.ARGB_8888
            );
            Canvas maskCanvas = new Canvas(this.mMaskBitmap);

            this.mMaskImage.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.mMaskImage.draw(maskCanvas);

            this.mLastMeasuredWidth = getMeasuredWidth();
            this.mLastMeasuredHeight = getMeasuredHeight();
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }
}
