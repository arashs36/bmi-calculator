package com.arash.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.arash.bmicalculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        super.onCreate(savedInstanceState);
        setContentView(view);
        final int[] age = {18};
        final int[] weight = {60};
        final float[] res = {0};
        final int[] height = {170};
        binding.ageneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age[0]>1){
                    age[0] -=1;
                    binding.agenum.setText(String.valueOf(age[0]));
                }
                else Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
            }
        });
        binding.agepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age[0] +=1;
                binding.agenum.setText(String.valueOf(age[0]));
            }
        });
        binding.weineg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight[0]>1){
                    weight[0] -=1;
                    binding.weightnum.setText(String.valueOf(weight[0]));
                }
                else {
                    Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.weipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight[0] +=1;
                binding.weightnum.setText(String.valueOf(weight[0]));
            }
        });
        binding.heiseek.setMax(250);
        binding.heiseek.setProgress(170);
        binding.heiseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                height[0] = i;
                binding.heinum.setText(String.valueOf(height[0]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.calbut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                    if(height[0]==0){
                        Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        res[0] = calbmi(weight,height);
                        binding.resid.setText(String.valueOf(res[0]));
                    }

                    if (res[0]<18.5&res[0]>0){
                        binding.posid.setText("UnderWeight");
                    }
                    else if (res[0]>=18.5&res[0]<=25){
                        binding.posid.setText("Normal");
                    }
                    else if (res[0]>25&res[0]<30){
                        binding.posid.setText("OverWeight");
                    }
                    else if (res[0]>=30){
                        binding.posid.setText("fat");
                    }
            }

        });

    }


    private float calbmi (int[] weight , int[] height){
        float hei_met= ((float) height[0]/100);
        return ((float) weight[0]/(hei_met *  hei_met));
    }

}