package com.anndevvor.circleboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class CircleBoard extends View {
	
	private static final float K = 57.2958f;
	
	int clock_hand_color;
	boolean clock_hand_volume;
	float clock_hand_height;
	float clock_hand_tail_height;
	float clock_hand_width;
	float clock_hand_center_ring_radius;
	float clock_hand_round_radius;
	
	int board_color_in;
	int board_color_out;
	
	int rim_color;
	float rim_width;
	boolean rim_volume;
	
	int grid_large_number;
	int grid_small_number;
	int number_min;
	int number_max;
	
	float grid_large_width;
	float grid_large_height;
	float grid_small_width;
	float grid_small_height;
	int grid_large_color;
	int grid_small_color;
	int grid_text_color;
	float grid_text_size;
	boolean grid_text_bold;
	
	
	
	int color_1;
	float value;
	Paint paint = new Paint();
	
	public CircleBoard(Context context) {
		super(context);
		init(null, 0);
	}
	
	public CircleBoard(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs, 0);
	}
	
	public CircleBoard(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs, defStyle);
	}
	
	private void init(AttributeSet attrs, int defStyle) {
		final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CircleBoard, defStyle, 0);
		clock_hand_color = a.getColor(R.styleable.CircleBoard_clock_hand_color, Color.RED);;
		clock_hand_volume = a.getBoolean(R.styleable.CircleBoard_clock_hand_volume, true);
		clock_hand_height = a.getDimension(R.styleable.CircleBoard_clock_hand_height, 4001f);
		clock_hand_tail_height = a.getDimension(R.styleable.CircleBoard_clock_hand_tail_height, 4001f);;
		clock_hand_width = a.getDimension(R.styleable.CircleBoard_clock_hand_width, 4001f);;
		clock_hand_center_ring_radius = a.getDimension(R.styleable.CircleBoard_clock_hand_center_ring_radius, 4001f);;
		clock_hand_round_radius = a.getDimension(R.styleable.CircleBoard_clock_hand_round_radius, 4001f);;
		
		board_color_in = a.getColor(R.styleable.CircleBoard_board_color_in, Color.WHITE);
		board_color_out = a.getColor(R.styleable.CircleBoard_board_color_out, Color.LTGRAY);
		rim_color = a.getColor(R.styleable.CircleBoard_rim_color, Color.GRAY);
		rim_width = a.getDimension(R.styleable.CircleBoard_rim_width,4001f);
		rim_volume = a.getBoolean(R.styleable.CircleBoard_rim_volume, true);
		
		grid_large_number = a.getInt(R.styleable.CircleBoard_grid_large_number, 10);
		grid_small_number = a.getInt(R.styleable.CircleBoard_grid_small_number, 5);
		number_min = a.getInt(R.styleable.CircleBoard_number_min, 0);
		number_max = a.getInt(R.styleable.CircleBoard_number_max, 100);
		
		grid_large_color = a.getColor(R.styleable.CircleBoard_grid_large_color, Color.DKGRAY);;
		grid_small_color = a.getColor(R.styleable.CircleBoard_grid_small_color, Color.DKGRAY);;
		grid_text_color = a.getColor(R.styleable.CircleBoard_grid_text_color, Color.DKGRAY);;
		grid_large_width = a.getDimension(R.styleable.CircleBoard_grid_large_width,4001f);;
		grid_large_height = a.getDimension(R.styleable.CircleBoard_grid_large_height,4001f);;
		grid_small_width = a.getDimension(R.styleable.CircleBoard_grid_small_width,4001f);;
		grid_small_height = a.getDimension(R.styleable.CircleBoard_grid_small_height,4001f);;
		grid_text_size = a.getDimension(R.styleable.CircleBoard_grid_text_size,4001f);;
		grid_text_bold = a.getBoolean(R.styleable.CircleBoard_grid_text_bold,false);;
		
		a.recycle();
	}
	
	private void invalidateTextPaintAndMeasurements() {
		/*mTextPaint.setTextSize(mExampleDimension);
		mTextPaint.setColor(mExampleColor);
		mTextWidth = mTextPaint.measureText(mExampleString);
		
		Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
		mTextHeight = fontMetrics.bottom;*/
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int w = Math.min(getWidth(), getHeight());
		int h = w;
		float center_x = w/2f;
		float center_y = w/2f;
		float radius = w/2f;
		float ring_width = rim_width < 4000 ? rim_width : radius/10f;
		
		float strelka_width = clock_hand_width < 4000 ? clock_hand_width : radius/20f;
		float strelka_hei = clock_hand_height < 4000 ? clock_hand_height : radius-ring_width-radius/50f;
		float strelka_center_radius = clock_hand_center_ring_radius < 4000 ? clock_hand_center_ring_radius : radius/20f;
		float strelka_tail_height = clock_hand_tail_height < 4000 ?  clock_hand_tail_height : strelka_hei/4f;
		
		float min = number_min;
		float max = number_max;
		
		int kolvo_deleniy = grid_large_number;
		float text_size = grid_text_size < 4000 ? grid_text_size : radius/10f;
		float delenie_width = grid_large_width < 4000 ? grid_large_width : radius/40f;
		float delenie_height = grid_large_height < 4000 ? grid_large_height : radius/15f;
		float delenie_zakruglenie = clock_hand_round_radius < 4000 ? clock_hand_round_radius : radius/10f;
		
		int kolvo_small_deleniy = grid_small_number;
		float delenie_small_width = grid_small_width < 4000 ? grid_small_width : radius/100f;
		float delenie__small_height = grid_small_height < 4000 ? grid_small_height : radius/20f;
		
		//FON
		Paint paint_inside = new Paint();
		paint_inside.setShader(new RadialGradient(center_x, center_y, radius - ring_width,
				board_color_in,
				board_color_out,
				Shader.TileMode.MIRROR));
		paint_inside.setStyle(Paint.Style.FILL);
		paint_inside.setAntiAlias(true);
		canvas.drawCircle(center_x,center_y,radius - ring_width,paint_inside);
		
		
		
		
		
		//DELENIA
		paint.setColor(Color.parseColor("#787878"));
		paint.setAntiAlias(true);
		
		for (double i2 = -(225d+0.0d)/K; i2 <= (46d/K); i2+= 270d/K/(kolvo_deleniy)/(kolvo_small_deleniy)) {
			float x1 = (float) (radius + Math.cos(i2) * (radius-delenie__small_height-ring_width));
			float y1 = (float)(radius + Math.sin(i2) * (radius-delenie__small_height-ring_width));
			canvas.save();
			canvas.rotate((float) i2*K-90f, x1, y1);
			paint.setColor(grid_small_color);
			canvas.drawRoundRect(x1-delenie_small_width/2f,y1,x1+delenie_small_width/2f,y1+delenie__small_height, 2, 2,paint);
			canvas.restore();
		}
		
		float n = min;
		for (double i = -225/K; i <= (46/K); i+= 270/K/kolvo_deleniy) {
			int x1 = (int)(radius + Math.cos(i) * (radius-delenie_height-ring_width));
			int y1 = (int)(radius + Math.sin(i) * (radius-delenie_height-ring_width));
			paint.setColor(grid_large_color);
			canvas.save();
			canvas.rotate((float) i*K-90f, x1, y1);
			canvas.drawRoundRect(x1-delenie_width/2f,y1,x1+delenie_width/2f,y1+delenie_height, 2, 2,paint);
			canvas.restore();
			paint.setTextSize(text_size);
			paint.setFakeBoldText(grid_text_bold);
			paint.setColor(grid_text_color);
			float width_max = paint.measureText((int)max+"");
			x1 = (int)(radius + Math.cos(i) * (radius-width_max/1.8f-ring_width - delenie_height) );
			y1 = (int)(radius + Math.sin(i) * (radius-width_max/1.8f-ring_width - delenie_height) );
			float width = paint.measureText((int)n+"");
			canvas.drawText((int)n+"", x1-width/2f,y1+text_size/3f,paint);
			n+=(max-min)/kolvo_deleniy;
		}
		
		
		
		//RING TELO
		Paint paint_kolco = new Paint();
		paint_kolco.setStrokeWidth(ring_width);
		paint_kolco.setColor(rim_color);
		paint_kolco.setStyle(Paint.Style.STROKE);
		paint_kolco.setAntiAlias(true);
		canvas.drawCircle(center_x,center_y,radius-ring_width/2f, paint_kolco);
		
		//RING VOLUME
		Paint paint1 = new Paint();
		paint1.setStyle(Paint.Style.STROKE);
		paint1.setAntiAlias(true);
		/*paint1.setShader(new SweepGradient(center_x,center_y, new int[]{
				Color.parseColor("#0008ff"),
				Color.parseColor("#0066ff"),
				Color.parseColor("#00fffc"),
				Color.parseColor("#00ff6c"),
				Color.parseColor("#2aff00"),
				Color.parseColor("#b4ff00"),
				Color.parseColor("#fff000"),
				Color.parseColor("#ff8400"),
				Color.parseColor("#ff6000"),
				Color.parseColor("#ff0000"),
		},
				new float[]{0.1f,
						0.5f,
						0.55f,
						0.6f,
						0.65f,
						0.75f,
						0.8f,
						0.85f,
						0.9f,
						0.95f
				}));*/
		Log.e("XXX:", "onDraw:" + ring_width);
		paint1.setShader(new RadialGradient(center_x,center_y, ring_width,
				new int[]{Color.parseColor("#66000000"),
						Color.parseColor("#00000000"),
						Color.parseColor("#33000000")},
				new float[]{0.1f,0.5f, 0.8f}, Shader.TileMode.MIRROR));
		paint1.setStrokeWidth(ring_width);
		if(rim_volume) canvas.drawCircle(center_x,center_y,radius-ring_width/2f, paint1);
		
		
		//STRELKA
		Paint paint_strelka = new Paint();
		paint_strelka.setAntiAlias(true);
		paint_strelka.setColor(clock_hand_color);
		Paint paint_strelka_volume = new Paint();
		paint_strelka_volume.setAntiAlias(true);
		paint_strelka_volume.setShader(new LinearGradient(center_x,center_y-strelka_width/2f,center_x,center_y+strelka_width/2f, new int[]{
				Color.parseColor("#33000000"),
				Color.parseColor("#22FFFFFF"),
				Color.parseColor("#33000000"),
		}, new float[]{
				0.0f, 0.5f,1f
		}, Shader.TileMode.MIRROR));
		canvas.save();
		float middle = (max+min)/2f;
		float koef = 270f/(max-min);
		float angel = (value-middle)*koef-90f;
		canvas.rotate(angel, center_x, center_y);
		canvas.drawRoundRect(center_x-strelka_tail_height,center_y-strelka_width/2f,center_x+strelka_hei, center_y+strelka_width/2f, delenie_zakruglenie, delenie_zakruglenie, paint_strelka);
		if(clock_hand_volume) canvas.drawRoundRect(center_x-strelka_tail_height,center_y-strelka_width/2f,center_x+strelka_hei, center_y+strelka_width/2f, delenie_zakruglenie, delenie_zakruglenie, paint_strelka_volume);
		canvas.restore();
		
		//STELKA CENTER
		
		if(strelka_center_radius > 0) {
			paint_strelka_volume.setShader(new RadialGradient(center_x, center_y, strelka_center_radius, new int[]{
					Color.parseColor("#33000000"),
					Color.parseColor("#22FFFFFF"),
					Color.parseColor("#33000000"),
			}, new float[]{
					0.0f, 0.5f, 1f
			}, Shader.TileMode.MIRROR));
			canvas.drawCircle(center_x, center_y, strelka_center_radius, paint_strelka);
			if (clock_hand_volume)
				canvas.drawCircle(center_x, center_y, strelka_center_radius, paint_strelka_volume);
		}
		
	}
	
	
	public String getExampleString() {
		return "";
	}
	

	public void setExampleString(String exampleString) {
	
		invalidateTextPaintAndMeasurements();
	}
	
}