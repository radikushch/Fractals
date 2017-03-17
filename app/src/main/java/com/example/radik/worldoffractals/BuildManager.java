package com.example.radik.worldoffractals;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BuildManager extends AppCompatActivity implements View.OnClickListener {

    DrawView draw;
    Button but1, but2, but3, but4, but5;
    ImageButton soundbtn, soundbtnplay, exit;
    SolutionMandelbrot mandelbrot;
    SolutionJulia julia;
    SolutionNewton newton;
    SolutionTree tree;
    SolutionWhirlwind whirlwind;
    ImageView container;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_manager);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mediaPlayer.start();

        draw = new DrawView(this);
        draw.setBackgroundColor(Color.WHITE);
        container = (ImageView) findViewById(R.id.container);

        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);
        but5 = (Button) findViewById(R.id.but5);
        soundbtn = (ImageButton) findViewById(R.id.soundbtn);
        soundbtnplay =(ImageButton)  findViewById(R.id.soundbtnplay);
        exit = (ImageButton) findViewById(R.id.exit);


        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        soundbtn.setOnClickListener(this);
        soundbtnplay.setOnClickListener(this);
        exit.setOnClickListener(this);


        mandelbrot = new SolutionMandelbrot();
        julia = new SolutionJulia();
        newton = new SolutionNewton();
        tree = new SolutionTree();
        whirlwind = new SolutionWhirlwind();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.but1: container.setImageBitmap(draw.bitmap); mandelbrot.drawMandelbrot(draw); break;
            case R.id.but2: container.setImageBitmap(draw.bitmap); julia.drawJulia(draw);           break;
            case R.id.but3: container.setImageBitmap(draw.bitmap); newton.drawNewton(draw);         break;
            case R.id.but4:
                draw.bitmap.eraseColor(Color.rgb(238, 213, 183));
                tree.drawTree(700, 450, 3 * Math.PI*(6.0/6), 200, draw);
                transform(90);
                break;
            case R.id.but5: container.setImageBitmap(draw.bitmap); whirlwind.drawWhirlwind(draw); break;
            case R.id.soundbtn:
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    soundbtn.setVisibility(View.INVISIBLE);
                    soundbtnplay.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.soundbtnplay:
                mediaPlayer.start();
                soundbtnplay.setVisibility(View.INVISIBLE);
                soundbtn.setVisibility(View.VISIBLE);
                break;
            case R.id.exit:
                mediaPlayer.stop();
                this.finish();
        }
    }

    public void transform(int angle){
        Matrix m = new Matrix();
        m.postRotate(angle);
        Bitmap rotate = Bitmap.createBitmap(draw.bitmap, 0, 0, draw.bitmap.getWidth(), draw.bitmap.getHeight(), m, true);
        container.setImageBitmap(rotate);
    }
}
