package com.example.thigk_appmaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv; //Khai bao bien textview
    private String input, answer; //kb bien input va answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa textview
        tv = (TextView) findViewById(R.id.tv);
    }

    public void ButtonClick(View view){
        Button button = (Button) view;

        //lấy chữ trong button
        String data = button.getText().toString();


        switch (data){
            case "ON/C":
                input="";
                break;
            case "CE":
                if(input.length()>0){
                    String newText = input.substring(0,input.length()-1);
                    input= newText;
                }
                break;
            case "=":
                pheptinh();
                answer=input;
                break;
            case "x":
                pheptinh();
                input += "*";
                break;
            default:
                if(input == null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") ||data.equals("/")){
                    pheptinh();
                }
                input += data;
        }
        tv.setText(input);
    }

    public void pheptinh(){
        if(input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try{
                double cong = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = cong+"";

            }catch (Exception e){

            }
        }
        if(input.split("\\-").length==2){
            String number[] = input.split("\\-");
            try{
                double tru = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = tru+"";

            }catch (Exception e){

            }
        }
        if(input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try{
                double nhan = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = nhan+"";

            }catch (Exception e){

            }
        }
        if(input.split("\\/").length==2){
            String number[] = input.split("\\/");
            try{
                double chia = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = chia+"";

            }catch (Exception e){

            }
        }

        String n[] = input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
    }



}