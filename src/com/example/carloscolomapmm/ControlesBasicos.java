package com.example.carloscolomapmm;

import com.example.carloscolomapmm.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View.OnClickListener;

public class ControlesBasicos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_controlesbasicos);
		
		final Button btnBoton1 = (Button)findViewById(R.id.BtnBoton1);
		final Button btnBoton2 = (Button)findViewById(R.id.BtnBoton2);
		final EditText txtNombre = (EditText)findViewById(R.id.TxtNombre);
		final Button btnHola = (Button)findViewById(R.id.BtnHola);
		
		btnBoton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ControlesBasicos.this, RadioButton.class);
				
				startActivity(intent);
				
			}
		});
		
		btnBoton2.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ControlesBasicos.this, CheckButton.class);
						
				startActivity(intent);		
			}
		});
				
		
		btnHola.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(ControlesBasicos.this, FrmSaludo.class);
						
				
				Bundle b = new Bundle();
				b.putString("NOMBRE", txtNombre.getText().toString());
				intent.putExtras(b);
				startActivity(intent);
						
			}
		});
				
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
