package com.example.administrator.walkingbob;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class ParallaxView extends SurfaceView implements Runnable {

    private volatile boolean running;
    private Thread gameThread = null;

    // For drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    // Holds a reference to the Activity
    Context context;

    // Control the fps
    long fps =60;

    // Screen resolution
    int screenWidth;
    int screenHeight;

    ParallaxView(Context context, int screenWidth, int screenHeight) {
        super(context);

        this.context = context;

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        ourHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {

        while (running) {
            long startFrameTime = System.currentTimeMillis();

            update();

            draw();

            long thisFrameTime = System.currentTimeMillis() - startFrameTime;
            if (thisFrameTime >= 1) {
                fps = 1000 / thisFrameTime;
            }
        }
    }

    private void update() {

    }

    private void draw() {

        if (ourHolder.getSurface().isValid()) {

            canvas = ourHolder.lockCanvas();


            canvas.drawColor(Color.argb(255, 0, 3, 70));


            paint.setTextSize(60);
            paint.setColor(Color.argb(255, 255, 255, 255));
            canvas.drawText("I am a plane", 350, screenHeight / 100 * 5, paint);
            paint.setTextSize(220);
            canvas.drawText("I'm a train", 50, screenHeight / 100*80, paint);


            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
