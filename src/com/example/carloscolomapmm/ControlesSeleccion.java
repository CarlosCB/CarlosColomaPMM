package com.example.carloscolomapmm;

import com.example.carloscolomapmm.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ControlesSeleccion extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_controlesseleccion);
		
		final Button btnBoton1 = (Button)findViewById(R.id.BtnBoton1);
		final Button btnBoton2 = (Button)findViewById(R.id.BtnBoton2);
				
		btnBoton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ControlesSeleccion.this, ListButton.class);
				
				startActivity(intent);
				
			}
		});
		btnBoton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ControlesSeleccion.this, SpinnerButton.class);
						
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
