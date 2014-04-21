package cz.halt.multidraw.app;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Filip on 21. 4. 2014.
 */
public class ExampleDrawer
{
	public static void drawBitmap(Bitmap bitmap, int width, int height)
	{
		Canvas c = new Canvas(bitmap);
		Paint p = new Paint();
		p.setColor(Color.TRANSPARENT);
		c.drawRect(0, 0, width, height, p);
		p.setColor(Color.RED);
		c.drawRect(new RectF(0, 0, 100, 100), p);
	}
}
