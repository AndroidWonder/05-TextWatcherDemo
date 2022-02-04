/* demonstrate the use of simple TextWatcher listeners on a widget.
Three methods are needed to satisfy the TextWatcher interface.
*/
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
			//called notify that somewhere within the widget the text has been changed.
			public void afterTextChanged(Editable s) {
				msg = "string length: " + txtInput.getText().toString().length()
				    + ", updated string: " + s.toString();
				txtMsg.setText( msg );				
			}

			//called to notify that within the widget the count characters beginning at start
			// are about to be replaced by new text with length after.
			public void beforeTextChanged(CharSequence s, int start,
					int count, int after) {	
		//		Toast.makeText(TextWatcherDemo.this, "BEFORE " + s, Toast.LENGTH_LONG).show();
			}

			//called to notify that within s the count characters beginning at start
			// have just replaced old text that had length before.
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
		//		Toast.makeText(TextWatcherDemo.this, "ON " + s, Toast.LENGTH_LONG).show();
				
			}
        	
        }); //addTextChangedListener       
        
    }
    
}