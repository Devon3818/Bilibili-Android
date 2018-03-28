package com.example.apple.bilibili;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by apple on 2018/3/28.
 */

public class LoginActivity extends Activity {

    ImageView mLeftLogo;
    ImageView mRightLogo;
    ImageView mDeleUserName;
    EditText et_UserName;
    EditText et_pass;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mLeftLogo = findViewById(R.id.iv_icon_left);
        mRightLogo = findViewById(R.id.iv_icon_right);
        mDeleUserName = findViewById(R.id.delete_username);
        et_UserName = findViewById(R.id.et_username);
        et_pass = findViewById(R.id.et_password);

        et_UserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b && et_UserName.getText().length() > 0){
                    mDeleUserName.setVisibility(View.VISIBLE);
                }else{
                    mDeleUserName.setVisibility(View.GONE);
                }
                mLeftLogo.setImageResource(R.drawable.ic_22);
                mRightLogo.setImageResource(R.drawable.ic_33);
            }
        });

        et_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mLeftLogo.setImageResource(R.drawable.ic_22_hide);
                mRightLogo.setImageResource(R.drawable.ic_33_hide);
            }
        });

        et_UserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et_pass.setText("");
                if(charSequence.length()>0){
                    mDeleUserName.setVisibility(View.VISIBLE);
                }else{
                    mDeleUserName.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
