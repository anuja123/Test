package app.sante.com.sante.view.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import app.sante.com.sante.R;

public class LoginActivity extends FragmentActivity implements View.OnClickListener{
    private TextView skip ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        skip = (TextView)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);

            }
        });


    }




    @Override
    public void onClick(View v) {

    }


}