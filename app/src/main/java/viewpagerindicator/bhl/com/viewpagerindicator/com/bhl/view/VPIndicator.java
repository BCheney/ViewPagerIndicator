package viewpagerindicator.bhl.com.viewpagerindicator.com.bhl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;


public class VPIndicator extends LinearLayout {
    private Paint mPaint;
    private Path mPath;
    private int tabBottomWidth;
    private int mTriangleBottomWidth;
    private int tabCount = 4;
    private int mTriangleBottomX;
    private int mTranslateX;

    public VPIndicator(Context context) {
        this(context, null);
    }

    public VPIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        tabBottomWidth = w / tabCount;
        mTriangleBottomWidth = tabBottomWidth / 6;
        mTriangleBottomX = tabBottomWidth / 2 - mTriangleBottomWidth / 2;
        initTriangle();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(mTranslateX, 0);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }

    /***
     * 初始化三角形
     */
    private void initTriangle() {
        mPath = new Path();
        mPath.moveTo(tabBottomWidth / 2 - mTriangleBottomWidth / 2, getHeight());
        mPath.lineTo(tabBottomWidth / 2 + mTriangleBottomWidth / 2, getHeight());
        mPath.lineTo(tabBottomWidth / 2, getHeight() - mTriangleBottomWidth / 2);
        mPath.close();
    }

    public void scroll(int position, float offset) {
        mTranslateX = (int) (tabBottomWidth * (position + offset));
        invalidate();
    }
}
