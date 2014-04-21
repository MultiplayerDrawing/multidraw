package cz.halt.multidraw.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Filip on 21. 4. 2014.
 */
public class DrawingPanel extends View
{
	private Bitmap bitmap;
	private Paint p = new Paint();
	private Rect r = new Rect();

	public DrawingPanel(Context context)
	{
		super(context);
	}

	public DrawingPanel(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public DrawingPanel(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	private int pow2(int a)
	{
		if(a <= 0)
		{
			return 1;
		}
		return pow2(a - 1) * 2;
	}

	private int getNextComplementSize(Canvas c)
	{
		int max = Math.max(c.getWidth(), c.getHeight());
		int log = (int) Math.ceil(Math.log((double) max) / Math.log(2.0) - 0.1);

		return pow2(log);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		if(bitmap == null)
		{
			int size = getNextComplementSize(canvas);
			bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
			r.top = 0;
			r.left = 0;
			r.right = canvas.getWidth();
			r.bottom = canvas.getHeight();
		}
		ExampleDrawer.drawBitmap(bitmap, canvas.getWidth(), canvas.getHeight());
		canvas.drawBitmap(bitmap, r, r, p);
	}
}
