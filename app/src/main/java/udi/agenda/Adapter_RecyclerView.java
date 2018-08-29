package udi.agenda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import udi.agenda.Interface.RecyclerView_ClickListener;


public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.ViewHolder>{
    public Context context;
    public List<ClsAgenda> ListaAgenda;
    private RecyclerView_ClickListener clickListener;
    public Adapter_RecyclerView(Context context, List<ClsAgenda> catList){
        this.context = context;
        this.ListaAgenda = catList;
    }

    @Override
    public Adapter_RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Titulo.setText(ListaAgenda.get(position).getNombre());
        holder.Fecha.setText(ListaAgenda.get(position).getFecha());
        /*if(ListaAgenda.get(position).getEstado()){
            holder.Estado.setText("Disponible");
        }else{holder.Estado.setText("Ocupado");
        }*/
        holder.Descripcion.setText(ListaAgenda.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return ListaAgenda.size();
    }
    public void setClickListener(RecyclerView_ClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView Titulo,Fecha;
        public EditText Descripcion;
        public FrameLayout contenedor;
        public ViewHolder(View itemView) {
            super(itemView);

            Titulo = (TextView) itemView.findViewById(R.id.txtTitulo);
            Fecha = (TextView) itemView.findViewById(R.id.txtFecha);
            Descripcion = (EditText) itemView.findViewById(R.id.etdescripcion);
            contenedor = (FrameLayout) itemView.findViewById(R.id.flcontainer);
            contenedor.setTag(contenedor);
            contenedor.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
