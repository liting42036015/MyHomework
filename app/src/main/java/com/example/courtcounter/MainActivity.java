package com.example.courtcounter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  final  int scoreArray[]={1,2,3};
    private  int lastScore_a,lastScore_b,score_a,score_b;
    private Button btna_1,btna_2,btna_3,btnb_1,btnb_2,btnb_3;
    private ImageView img_cancel,img_rest;
    private TextView test_score_a,test_score_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inintView();
    }
    private void inintView() {
        btna_1=findViewById(R.id.btna_1);
        btna_2=findViewById(R.id.btna_2);
        btna_3=findViewById(R.id.btna_3);
        btnb_1=findViewById(R.id.btnb_1);
        btnb_2=findViewById(R.id.btnb_2);
        btnb_3=findViewById(R.id.btnb_3);

        img_cancel=findViewById(R.id.img_cancel);
        img_rest=findViewById(R.id.img_reset);
        test_score_a=findViewById(R.id.score_a);
        test_score_b=findViewById(R.id.score_b);

        btna_1.setOnClickListener(this);
        btna_2.setOnClickListener(this);
        btna_3.setOnClickListener(this);
        btnb_1.setOnClickListener(this);
        btnb_2.setOnClickListener(this);
        btnb_3.setOnClickListener(this);
        img_rest.setOnClickListener(this);
        img_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btna_1:
                scoreAdd(0,scoreArray[0]);

                break;
            case R.id.btna_2:
                scoreAdd(0,scoreArray[1]);

                break;
            case R.id.btna_3:
                scoreAdd(0,scoreArray[2]);

                break;
            case  R.id.btnb_1:
                scoreAdd(1,scoreArray[0]);

                break;
            case  R.id.btnb_2:
                scoreAdd(1,scoreArray[1]);

                break;
            case  R.id.btnb_3:
                scoreAdd(1,scoreArray[2]);

                break;
            case  R.id.img_reset:
                reset();
                break;
            case  R.id.img_cancel:
                cancel();
                break;
            default:
                break;
        }
    }
    private void cancel() {
        if (score_a!=0&&score_a-lastScore_a>=0){
            score_a-=lastScore_a;
        }
        if (score_b!=0&&score_b-lastScore_b>=0){
            score_b-=lastScore_b;
        }
        ShowText();
    }
    private void reset() {
        //弹出提示框，提示用户你是否要重置
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder builder1 = builder.setTitle("提示")
                .setMessage("你确定要重置分数吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score_a = 0;
                        score_b = 0;
                        ShowText();
                        dialog.dismiss();
                        ;
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog  dialog=builder.create();
        dialog.show();
    }


    private   void  scoreAdd(int Tage,int score){
        //Tage:   0:a  1:b
        if (Tage==0||Tage==1){
            if (Tage==0){
                lastScore_b=0;
                lastScore_a=score;
                score_a+=lastScore_a;
            }else if (Tage==1){
                lastScore_a=0;
                lastScore_b=score;
                score_b+=lastScore_b;
            }
            ShowText();
        }
    }

    private  void ShowText(){
        test_score_a.setText(Integer.toString(score_a));
        test_score_b.setText(Integer.toString(score_b));
    }
}

