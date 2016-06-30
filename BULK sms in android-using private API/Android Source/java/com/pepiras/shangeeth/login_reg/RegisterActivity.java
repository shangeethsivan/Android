package com.pepiras.shangeeth.login_reg;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shangeethsivan on 28-06-2016.
 */
public class RegisterActivity extends LoginActivity  {
    private EditText e_username;
    private EditText e_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e_username = (EditText) findViewById(R.id.r_username);
        e_number = (EditText) findViewById(R.id.r_number);

    }
    public void invokeRegister(View view){
        username = e_username.getText().toString();
        password = e_number.getText().toString();

        invokeRegister(username, password);
    }
    private void invokeRegister(final String username, String password) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loadingDialog = ProgressDialog.show(RegisterActivity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://192.168.1.140/bulk/registration.php");// use localhost or your local ip
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                String s = result.trim();
                loadingDialog.dismiss();
                Log.d("FIND","TEST:"+s);
                if(s.equalsIgnoreCase("Please Fill The Fileds")){
                    Toast.makeText(getApplicationContext(), "Please Fill The Fileds", Toast.LENGTH_LONG).show();

                }else{
                    if (s.equalsIgnoreCase("success")) {
                        //Intent intent = new Intent(RegisterActivity.this,UserActivity.class);
                        //intent.putExtra(USER_NAME, username);
                        //finish();
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                       // startActivity(intent);
                        //startActivity(new Intent(LoginActivity.this, UserActivity.class));


                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid User Name or Password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username, password);

    }
}