package com.example.mycolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private TextView tv_avalue;
    private TextView tv_rvalue;
    private TextView tv_gvalue;
    private TextView tv_bvalue;
    private SeekBar sb_a;
    private SeekBar sb_r;
    private SeekBar sb_g;
    private SeekBar sb_b;
    private EditText et_a;
    private EditText et_r;
    private EditText et_g;
    private EditText et_b;
    private Button btn_input;

    private int value_a;
    private int value_r;
    private int value_g;
    private int value_b;
    private int argb = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        change_seekbar();
        change_color();
    }

    private void init(){    // ID 지정 및 초기 TextView, EditText, ImageView 값 지정

        iv = (ImageView)findViewById(R.id.iv);
        tv_avalue = (TextView)findViewById(R.id.tv_avalue);
        tv_rvalue = (TextView)findViewById(R.id.tv_rvalue);
        tv_gvalue = (TextView)findViewById(R.id.tv_gvalue);
        tv_bvalue = (TextView)findViewById(R.id.tv_bvalue);
        sb_a = (SeekBar)findViewById(R.id.sb_a);
        sb_r = (SeekBar)findViewById(R.id.sb_r);
        sb_g = (SeekBar)findViewById(R.id.sb_g);
        sb_b = (SeekBar)findViewById(R.id.sb_b);
        et_a = (EditText)findViewById(R.id.et_a);
        et_r = (EditText)findViewById(R.id.et_r);
        et_g = (EditText)findViewById(R.id.et_g);
        et_b = (EditText)findViewById(R.id.et_b);
        btn_input = (Button)findViewById(R.id.btn_input);

        iv.setBackgroundColor(0x88888888);

        tv_avalue.setText(Integer.toString(sb_a.getProgress()));
        tv_rvalue.setText(Integer.toString(sb_r.getProgress()));
        tv_gvalue.setText(Integer.toString(sb_g.getProgress()));
        tv_bvalue.setText(Integer.toString(sb_b.getProgress()));

        et_a.setText(Integer.toString(sb_a.getProgress()));
        et_r.setText(Integer.toString(sb_r.getProgress()));
        et_g.setText(Integer.toString(sb_g.getProgress()));
        et_b.setText(Integer.toString(sb_b.getProgress()));
    }

    private void change_seekbar(){  // SeekBar의 progress값의 변화에 따른 EditText값 변경

        sb_a.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                et_a.setText(Integer.toString(sb_a.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                et_a.setText(Integer.toString(sb_a.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                et_r.setText(Integer.toString(sb_r.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                et_r.setText(Integer.toString(sb_r.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                et_g.setText(Integer.toString(sb_g.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                et_g.setText(Integer.toString(sb_g.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                et_b.setText(Integer.toString(sb_b.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                et_b.setText(Integer.toString(sb_b.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void change_color(){        // Button 클릭시 SeekBar의 progress값의 변화에 따른 ImageView, TextView값 변경
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_avalue.setText(Integer.toString(sb_a.getProgress()));
                tv_rvalue.setText(Integer.toString(sb_r.getProgress()));
                tv_gvalue.setText(Integer.toString(sb_g.getProgress()));
                tv_bvalue.setText(Integer.toString(sb_b.getProgress()));

                value_a = sb_a.getProgress()*256*256*256;
                value_r = sb_r.getProgress()*256*256;
                value_g = sb_g.getProgress()*256;
                value_b = sb_b.getProgress();
                argb += value_a + value_r + value_g + value_b;

                iv.setBackgroundColor(argb);
                argb = 0;
            }
        });
    }
}

