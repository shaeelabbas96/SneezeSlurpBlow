package com.example.assignment2_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


        MediaPlayer sneezePlayer;
        MediaPlayer blowPlayer;
        MediaPlayer slurpPlayer;

        Button sneeze;
        Button blow;
        Button slurp;

        boolean clicked = false;
        int health = 10;
        View bg;

        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initUI();


            sneeze.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    sneezePlayer.start();
                    sneezeFunc();
                }

            });


            blow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    blowPlayer.start();
                   // Log.d("TEST:","fUN");

                }
            });

            slurp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    slurpPlayer.start();
                    healthStatus();
                }
            });
        }

        public void initUI()
        {
            sneeze = findViewById(R.id.sneeze);
            blow = findViewById(R.id.blow);
            slurp = findViewById(R.id.slurp);

            sneezePlayer = MediaPlayer.create(this, R.raw.sneeze2);
            blowPlayer = MediaPlayer.create(this, R.raw.blow_nose);
            slurpPlayer = MediaPlayer.create(this, R.raw.slurp);
            bg = this.getWindow().getDecorView();

        }

        public void sneezeFunc()
        {
            clicked = true;
            health -= 1;
            if (health <= 7 && health > 5)
            {
                bg.setBackgroundResource(R.color.lightblue);
            }
            else if (health <= 5)
            {
                bg.setBackgroundResource(R.color.red);
                if (health < 0)
                {
                    health = 0;
                }
            }
            Toast.makeText(getApplicationContext(), "Your health is " + String.valueOf(health), Toast.LENGTH_SHORT).show();
            System.out.println("The health is " + health);
        }

        public void healthStatus()
        {
            health += 2;
            if (health > 7)
            {
                bg.setBackgroundResource(R.color.white);
                if(health > 10)
                {
                    health = 10;
                }
            }
            else if(health <= 7)
            {
                bg.setBackgroundResource(R.color.lightblue);
            }
            Toast.makeText(getApplicationContext(), "Your health is " + String.valueOf(health), Toast.LENGTH_SHORT).show();
            System.out.println("The health is " + health);
        }





        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            if (clicked == true) {
                MediaPlayer ring = MediaPlayer.create(MainActivity.this, R.raw.blow_nose);
                ring.start();
                clicked = false;
            }
            else if (clicked == false) {
                MediaPlayer ring = MediaPlayer.create(MainActivity.this, R.raw.sneeze2);
                ring.start();
                clicked = true;
            }
        }


}
