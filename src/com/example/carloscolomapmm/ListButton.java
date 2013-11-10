package com.example.carloscolomapmm;

import com.example.carloscolomapmm.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListButton extends Activity {

    private Musica[] datos = 
    	new Musica[]{
			new Musica("Marilyn Manson", "Metal Industrial", "1993 - Actualidad", R.drawable.manson),
    		new Musica("Ac / Dc", "Hard Rock", "Decada de los 70", R.drawable.acdc),
    		new Musica("Rlling Stones", "Rock'n'Roll", "Decada de los 60", R.drawable.rollin),
    		new Musica("Slipknot", "Nu Metal", "Decada de los 90", R.drawable.slipknot)};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbutton);
                
        ListView listView = (ListView)findViewById(R.id.LstOpciones);
     		
  		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  			public void onItemClick(AdapterView<?> parent, android.view.View v, int position, long id){
  				Intent intent = new Intent(ListButton.this, ListButtonPantallaDos.class);  				
  				Bundle b = new Bundle();
  				String titulo=((Musica)parent.getAdapter().getItem(position)).getTitulo();
  				String subtitulo=((Musica)parent.getAdapter().getItem(position)).getSubtitulo();
  				String fecha=((Musica)parent.getAdapter().getItem(position)).getFecha();
  				b.putString("Titulo", titulo);
  				b.putString("Subtitulo", subtitulo);
  				b.putString("Fecha", fecha);
  				int foto=((Musica)parent.getAdapter().getItem(position)).getFoto();
  				b.putInt("Foto", foto);
  				
  				intent.putExtras(b);
				
				startActivity(intent);
  			}
			      			
  		});
                
        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        
        lstOpciones.setAdapter(adaptador);
    }
    
    class AdaptadorTitulares extends ArrayAdapter<Musica> {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.activity_music, datos);
    		this.context = context;
    	}
    	public View getView(int position, View convertView, ViewGroup parent) {
			
    		View item = convertView;
    		ViewHolder holder;
    		
    		if (item == null){
    			LayoutInflater inflater = context.getLayoutInflater();
    			item = inflater.inflate(R.layout.activity_music, null);
    			holder = new ViewHolder();
    			holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
    			holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
    			holder.fecha = (TextView)item.findViewById(R.id.LblFecha);
    			holder.imagen = (ImageView)item.findViewById(R.id.LblImagen);
    			item.setTag(holder);
    		}
    		else{
    			holder = (ViewHolder)item.getTag();
    		}
			holder.titulo.setText(datos[position].getTitulo());
			holder.subtitulo.setText(datos[position].getSubtitulo());
			holder.fecha.setText(datos[position].getFecha());
			holder.imagen.setImageResource(datos[position].getFoto());
			return(item);
		}
    }

    static class ViewHolder{
    	TextView titulo;
    	TextView subtitulo;
    	TextView fecha;
    	ImageView imagen;
    }
    
}
