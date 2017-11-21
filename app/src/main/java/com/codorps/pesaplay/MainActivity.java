package com.codorps.pesaplay;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer x,y,z,i,j,k,m,n,v;
    private Integer r1,r2,r3,r4,v1,v2,v3,v4,v5,vv1,vv2,vv3,vvv1,vvv2;
    private Integer rq;
    private Integer shuffle=4;
    private Integer quiz=3;
    private Integer count=0;
    public Integer vx,vy,vz,vi,vj,vk,vm,vn,vv;
    public Integer vvvv1=0;
    public Integer jackpot=162;
    public Integer bonusquiz;
    public int totalRandom=15;



    public TextView cube1;
    public TextView cube2;
    public TextView cube3;
    public TextView txtcombo;
    public TextView txtscore;

    public Button gameShuffle;
    public Button gameToss;
    public Button gameQuiz;






    AlertDialog.Builder builder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cube1=(TextView) findViewById(R.id.cube1);
        cube2=(TextView) findViewById(R.id.cube2);
        cube3=(TextView) findViewById(R.id.cube3);
        txtcombo=(TextView) findViewById(R.id.combo);
        txtscore=(TextView) findViewById(R.id.score);

        gameShuffle=(Button) findViewById(R.id.btnshuffle);
        gameToss=(Button) findViewById(R.id.btntoss);
        gameQuiz=(Button) findViewById(R.id.btnquiz);




        gameQuiz.setText("Quiz("+quiz+")");
        //game shuffle
        gameShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deploy onshuffle method
                OnShuffleCube1();
                OnShuffleCube2();
                OnShuffleCube3();
                shuffle--;
                gameShuffle.setText("Shuffle("+shuffle+")");
                if(shuffle<=0){
                    gameShuffle.setClickable(false);
                    gameShuffle.setEnabled(false);
                    shuffle=0;
                }else{
                    gameShuffle.setClickable(true);
                    gameShuffle.setEnabled(true);
                }
            }
        });

        builder=new AlertDialog.Builder(MainActivity.this);

        //game Toss
        //the basic art of electronics, perfect form of painting
        //randomizing the letters on a maximum schedule to produce a randomized group known as a shuffle.
        gameToss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffle=3;
                gameShuffle.setText("Shuffle("+shuffle+")");
                gameShuffle.setClickable(true);
                gameShuffle.setEnabled(true);
                //deploy ontoss method
                OnToss();



                if(count==27){
                    count=27;
                   //show dialog and score
                    builder.setTitle("Congratulations!");
                    displayAlert("You have scored "+vvvv1+" points");
                }

                if(vvvv1==162){
                    //show dialog and score
                    builder.setTitle("JACKPOT!");
                    displayAlert("You have scored "+vvvv1+" points");
                    if(count==27){
                        //show dialog and score
                        builder.setTitle("JACKPOT!");
                        displayAlert("You have scored "+vvvv1+" points");
                    }
                }


                if(vvvv1<18){
                    txtcombo.setText("Next Combo: "+18);
                }else if(vvvv1>=18 && vvvv1<45){
                    txtcombo.setText("Next Combo: "+45);
                }else if(vvvv1>=45 && vvvv1<72){
                    txtcombo.setText("Next Combo: "+72);
                }else if(vvvv1>=72){
                    txtcombo.setText("No Combo!");
                }

                if(vvvv1==18){
                    vvvv1+=10;
                    Toast.makeText(MainActivity.this,"10 points reward on combo point 18!", Toast.LENGTH_LONG).show();
                }else if(vvvv1==45){
                    Toast.makeText(MainActivity.this,"10 points reward on combo point 45!", Toast.LENGTH_LONG).show();
                    vvvv1+=10;
                }else if(vvvv1==72){
                    Toast.makeText(MainActivity.this,"10 points reward on combo point 72!", Toast.LENGTH_LONG).show();
                    vvvv1+=10;
                }
                gameToss.setText("Toss("+count+")");
                txtscore.setText("FINAL SCORE: "+vvvv1);
            }

        });

        //game quiz
        gameQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deploy on quiz method
                OnQuiz();

                if(quiz<=0){
                    quiz=0;
                    gameQuiz.setClickable(false);
                    gameQuiz.setEnabled(false);
                }else {
                    gameQuiz.setClickable(true);
                    gameQuiz.setEnabled(true);
                }
                gameQuiz.setText("Quiz("+quiz+")");

                if(vvvv1==18){
                    vvvv1+=10;
                    Toast.makeText(MainActivity.this,"10 points reward on combo point 18!", Toast.LENGTH_LONG).show();
                }else if(vvvv1==45){
                    Toast.makeText(MainActivity.this,"10 points reward on combo point 45!", Toast.LENGTH_LONG).show();
                    vvvv1+=10;
                }else if(vvvv1==72){
                    Toast.makeText(MainActivity.this,"10 points reward on combo point 72!", Toast.LENGTH_LONG).show();
                    vvvv1+=10;
                }
                gameToss.setText("Toss("+count+")");
                txtscore.setText("FINAL SCORE: "+vvvv1);
            }
        });

    }



    public void OnShuffleCube1(){
        Random r=new Random();
        x=r.nextInt(totalRandom);
        if(x==0){
            y=r.nextInt(totalRandom);
        }else if (x==totalRandom){
            y=0;
            z=0;
        }else if (x<totalRandom){
            y=r.nextInt(totalRandom-x);
        }

        if(x<totalRandom && y==0){
            z=totalRandom-x;
        } else if (x==0 && y==0){
            z=totalRandom;
        }else if(y==totalRandom){
            x=0;
            z=0;
        }else if(y==totalRandom-x){
            z=0;
            y=totalRandom-x;
        }else if (y<totalRandom-x){
            z=totalRandom-(x+y);
        }

        vx=x;
        vy=y;

        cube1.setText("Cube 1(X="+x+","+"Y="+y+","+"Z="+z+")");

    }
    public void OnShuffleCube2(){

        Random r=new Random();
        i=r.nextInt(totalRandom);
        if(i==0){
            j=r.nextInt(totalRandom);
        }else if (i==totalRandom){
            j=0;
            k=0;
        }else if (i<totalRandom){
            j=r.nextInt(totalRandom-i);
        }

        if(i<totalRandom && j==0){
            k=totalRandom-i;
        } else if (i==0 && j==0){
            k=totalRandom;
        }else if(j==totalRandom){
            i=0;
            k=0;
        }else if(j==totalRandom-i){
            k=0;
            j=totalRandom-i;
        }else if (j<totalRandom-i){
            k=totalRandom-(i+j);
        }

        vj=j;
        vk=k;

        cube2.setText("Cube 2(I="+i+","+"J="+j+","+"K="+k+")");

    }
    public void OnShuffleCube3(){

        Random r=new Random();
        m=r.nextInt(totalRandom);
        if(m==0){
            n=r.nextInt(totalRandom);
        }else if (m==totalRandom){
            n=0;
            v=0;
        }else if (m<totalRandom){
            n=r.nextInt(totalRandom-m);
        }

        if(m<totalRandom && n==0){
            v=totalRandom-m;
        } else if (m==0 && n==0){
            v=totalRandom;
        }else if(n==totalRandom){
            m=0;
            v=0;
        }else if(n==totalRandom-m){
            v=0;
            n=totalRandom-m;
        }else if (n<totalRandom-m){
            v=totalRandom-(m+n);
        }

        vm=m;
        vn=n;
        vv=v;

        cube3.setText("Cube 3(M="+m+","+"N="+n+","+"V="+v+")");

    }



    public void OnToss(){

        Random tr=new Random();
        r1=tr.nextInt(2);

        if(r1==0){
            v1=vx;
            v2=z;
            v3=vj;
            v4=vm;
            v5=vn;
        }else {
            v1=vy;
            v2=i;
            v3=vk;
            v4=vn;
            v5=vv;
        }

        r2=tr.nextInt(4-2)+2;

        if(r2==2){
            vv1=v1;
            vv2=v3;
            vv3=v4;
        }else{
            vv1=v2;
            vv2=v4;
            vv3=v5;
        }

        r3=tr.nextInt(6-4)+4;

        if(r3==4){
            vvv1=vv1;
            vvv2=vv2;
        }else{
            vvv1=vv2;
            vvv2=vv3;
        }

        r4=tr.nextInt(8-6)+6;

        if(r4==6){
            vvvv1=vvvv1+vvv1;
        }else {
            vvvv1=vvvv1+vvv2;
        }


        count+=1;
    }

    public void OnQuiz(){

        Random rnq=new Random();
        rq=rnq.nextInt(3);

        if(rq==0){
            bonusquiz=0;
            Toast.makeText(MainActivity.this,"0 points reward on Question!", Toast.LENGTH_LONG).show();
        }else if (rq==1){
            bonusquiz=5;
            Toast.makeText(MainActivity.this,"5 points reward on Question!", Toast.LENGTH_LONG).show();
        }else if (rq==2){
            bonusquiz=10;
            Toast.makeText(MainActivity.this,"10 points reward on Question!", Toast.LENGTH_LONG).show();
        }
        vvvv1+=bonusquiz;
        txtscore.setText("FINAL SCORE: "+vvvv1);
        quiz--;
    }

    public void displayAlert(String message){
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //reset everything
                vvvv1=0;
                count=0;
                quiz=3;
                shuffle=3;

                gameShuffle.setText("Shuffle("+shuffle+")");
                gameToss.setText("Toss("+count+")");
                gameQuiz.setText("Quiz("+quiz+")");
                txtscore.setText("FINAL SCORE: "+vvvv1);

                gameQuiz.setClickable(true);
                gameQuiz.setEnabled(true);

            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }


}
