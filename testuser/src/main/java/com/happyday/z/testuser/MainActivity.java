package com.happyday.z.testuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText_word ;
    EditText editText_pass ;
    Button btn;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_word= (EditText) findViewById(R.id.username);
        editText_pass= (EditText) findViewById(R.id.password);
        t= (TextView) findViewById(R.id.tedxt);
        btn= (Button) findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


    public void login(){
       final String name=editText_word.getText().toString();
       final String pass=editText_pass.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection =null;
                BufferedReader reader=null;
                try {
                    URL url =new URL("http://10.32.59.252:8080/XSTXK/login.jsp?username="+name+"&password="+pass);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    InputStream in=httpURLConnection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    Log.i("aaaa",response.toString());
                    int i=response.toString().indexOf("<");

                    String c=response.toString().substring(0,i);

                    c=c.trim();
                    Log.i("ccccc",c);
                    JSONArray jsonArray = new JSONArray(c);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    final String b=jsonObject.getString("reason");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            t.setText(b);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void netLogin(){

    }


}
