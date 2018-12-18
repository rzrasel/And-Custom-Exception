package com.rz.feedexception;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        try {
            //check001(10);
            check001(20);
        } catch (FeedException ex) {
            if (ex instanceof NetworkError) {
                System.out.println("GET ERROR FROM NETWORK ERROR");
            }
            ex.printStackTrace();
            //System.out.println(ex.getMessage());
        }
    }

    public void check001(int argValue) throws FeedException {
        try {
            int a = 20 / 0;
        } catch (ArithmeticException ex) {
            throw new NetworkError(ex.getMessage());
        }
        if (argValue == 10) {
            throw new FeedException("FeedException");
        } else if (argValue == 20) {
            throw new NetworkError("NetworkError");
        }
    }
}
