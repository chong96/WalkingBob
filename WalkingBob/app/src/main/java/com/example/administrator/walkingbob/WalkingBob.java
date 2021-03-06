package com.example.administrator.walkingbob;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class WalkingBob extends Activity {

    GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);
    }

    class GameView extends SurfaceView implements Runnable {

        Thread gameThread = null;

        SurfaceHolder ourHolder;

        volatile boolean playing;

        Canvas canvas;
        Paint paint;

        long fps;

        private long timeThisFrame;

        Bitmap bitmapBob;

        Boolean isMoving = false;

        float walkSpeedPerSecond = 150;

        float bobXPosition = 10;



        public GameView(Context context) {
            super(context);

            ourHolder = getHolder();
            paint = new Paint();
            bitmapBob = BitmapFactory.decodeResource(this.getResources(), R.drawable.bob);
        }

        @Override
        public void run() {
            while (playing) {
                long startFrameTime = System.currentTimeMillis();

                update();

                draw();

                timeThisFrame = System.currentTimeMillis() - startFrameTime;
                if (timeThisFrame > 0) {
                    fps = 1000 / timeThisFrame;
                }
            }
        }

        public void update() {

            if (isMoving) {
                bobXPosition = bobXPosition + (walkSpeedPerSecond / fps);
            }

        }

        public void draw() {

            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();

                canvas.drawColor(Color.argb(255, 26, 128, 182));

                paint.setColor(Color.argb(255, 249, 129, 0));

                paint.setTextSize(45);

                canvas.drawText("FPS: " + fps, 20, 40, paint);

                canvas.drawBitmap(bitmapBob, bobXPosition, 200, paint);

                ourHolder.unlockCanvasAndPost(canvas);
            }

        }

        public void pause() {
            playing = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void resume() {
            playing = true;
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            switch (event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN:
                    isMoving = true;
                    break;

                case MotionEvent.ACTION_UP:
                    isMoving = false;
                    break;
            }
            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }
}
