// demonstrate the use of a simple TEXTWATCHER control
//Three methods are needed to satisfy the TextWatcher interface

package com.course.example.textwatcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TextWatcherDemo extends Activity  {
    private EditText txtInput;
    private TextView txtMsg;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtMsg = (TextView)findViewById(R.id.txtMsg);
        txtInput = (EditText)findViewById(R.id.txtInput);    

        // add listener to EditText widget for text changes       
        txtInput.addTextChangedListener(new TextWatcher() {
        	String msg;
			public void afterTextChanged(Editable s) {
				msg = "count: " + txtInput.getText().toString().length()
				    + " " + s.toString();
				txtMsg.setText( msg );				
			}

			public void beforeTextChanged(CharSequence s, int start,
					int count, int after) {	
			//	Toast.makeText(getApplicationContext(), "BTC " + s, Toast.LENGTH_LONG).show();
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			//	Toast.makeText(getApplicationContext(), "OTC " + s, Toast.LENGTH_LONG).show();
				
			}
        	
        }); //addTextChangedListener       
        
    }
    
}