package com.wissen.mesut.j6_7friendmapping.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wissen.mesut.j6_7friendmapping.R;

/**
 * Created by Mesut on 12.09.2017.
 */

public class BaseActivity extends AppCompatActivity {
    public ProgressDialog mProgressDialog;
    public ProgressBar mProgressBar;
    public FirebaseAuth mAuth;
    public FirebaseUser user;
    public FirebaseDatabase database;
    public DatabaseReference myRef;

    public boolean validateForm(View view) {
        boolean valid = true;
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (TextUtils.isEmpty(editText.getText().toString())) {
                editText.setError("Gerekli!");
                valid = false;
            } else {
                editText.setError(null);
            }
        }
        return valid;
    }

    public void showProgressDialog(String title, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle(title);
            mProgressDialog.setMessage(message);
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    public void showProgressDialog(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle(R.string.veritabanibaglaniyor);
            mProgressDialog.setMessage(message);
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
