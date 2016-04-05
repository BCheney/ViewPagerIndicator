package viewpagerindicator.bhl.com.viewpagerindicator.com.bhl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;


public class ViewPagerIndicator extends LinearLayout {
    private Paint mPaint;
    private Path mPath;
    private int mTriangleWidth;
    private int mTriangleHeight;
    private int mInitTriangleX;
    private int mTranslationX;
    private int mDefaultTabCount = 3;

    private static final float mTriangleBottomWidthRatio = 1 / 6F;


    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        //初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#FFFFFF"));
        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setPathEffect(new CornerPathEffect(3));

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
//        canvas.translate(mInitTriangleX + mTranslationX, getHeight() - 2);
//        canvas.drawPath(mPath, mPaint);
        mPaint.setStrokeWidth((float) 15.0);              //设置线宽
        canvas.drawLine(getWidth() / mDefaultTabCount / 2 - mTriangleWidth / 2 + mTranslationX, getHeight(), getWidth() / mDefaultTabCount / 2 + mTriangleWidth / 2 + mTranslationX, getHeight(), mPaint);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        mTriangleWidth = (int) (w / mDefaultTabCount * mTriangleBottomWidthRatio);
        mTriangleWidth = (int) getWidth() / mDefaultTabCount/2;
        mInitTriangleX = w / mDefaultTabCount / 2 - mTriangleWidth / 2;
//        initTriangle();
    }

    private void initTriangle() {
        mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.lineTo(mTriangleWidth, 0);
        mPath.lineTo(mTriangleWidth / 2, -mTriangleWidth / 2);
        mPath.close();
    }

    public void scroll(int position, float positionOffset) {
        int tabWidth = getWidth() / mDefaultTabCount;
        mTranslationX = (int) (tabWidth * (position + positionOffset));
        invalidate();
    }
}
