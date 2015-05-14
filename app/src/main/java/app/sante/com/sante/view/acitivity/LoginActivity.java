package app.sante.com.sante.view.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import app.sante.com.sante.R;

public class LoginActivity extends FragmentActivity implements View.OnClickListener{
    private TextView skip ;
    private LoginButton fbLoginBtn;
    //private UiLifecycleHelper uiHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);
        skip = (TextView)findViewById(R.id.skip);
        fbLoginBtn = (LoginButton)findViewById(R.id.connectWithFbButton);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);

            }
        });

        //fbLoginBtn.setUserInfoChangedCallBack()


    }




    @Override
    public void onClick(View v) {

    }


}