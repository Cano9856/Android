package com.example.loginandroid_29_09_2023.lstMov.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Libros;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.utils.ImageLoader;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {

    private List<Libros> libros;
    private Context context;

    public PeliculaAdapter(Context context, List<Libros> libros) {
        this.libros= libros;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onItemClick(Libros libros);
    }

    private  OnItemClickListener listener;

    // Método para establecer el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_card,
                            parent,
                        false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        initSVTeamImageView( this.libros.get(position).getImagen_url(), holder.ivLibro);
    }
    private void initSVTeamImageView(String url, ImageView imagen) {
//        String myUrl = "";
        ImageLoader.Builder builder = new ImageLoader.Builder(url, imagen);

        builder.build().load();
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivLibro;

        private TextView tvNombre;
        private TextView tvId;
        private TextView tvDescripcion;
        private TextView tvPrecio;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            ivLibro = itemView.findViewById(R.id.ivProducto);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvId = itemView.findViewById(R.id.tvId);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);

            }
            public void bind(Producto producto) {
                Producto currentProducto = producto;
            }
        }
    }

