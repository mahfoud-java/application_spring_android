package com.tpjava2.appjob.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpjava2.appjob.R;
import com.tpjava2.appjob.model.Annonce;

import java.util.List;

public class ListeAnnoncesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Annonce> listeAnnonce;
    private ClickAnnonceListener listener;



    public interface ClickAnnonceListener {
        void onClickAnnonceListener(Annonce annonce);
    }

    public ListeAnnoncesAdapter(List<Annonce> listeAnnonce, ClickAnnonceListener listener) {
        this.listeAnnonce = listeAnnonce;
        this.listener = listener;
    }

    static class AnnonceViewHolder extends RecyclerView.ViewHolder{

        TextView textViewIntitule;
        TextView textViewDescription;
        TextView textViewDiplome;
        TextView textViewId;


        Button buttonAnnonceEdition;
        LinearLayout layout;

        public AnnonceViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIntitule = itemView.findViewById(R.id.textView_intitule);
            textViewDescription = itemView.findViewById(R.id.textView_salaire);
            textViewDiplome = itemView.findViewById(R.id.textView_diplome);
            textViewId = itemView.findViewById(R.id.textView_id);
            layout = itemView.findViewById(R.id.linearLayout_annoces);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_annonce, parent, false);
        return new AnnonceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AnnonceViewHolder view = (AnnonceViewHolder)holder;

        view.textViewIntitule.setText(listeAnnonce.get(position).getIntitule());
        view.textViewDescription.setText("Salaire : " +listeAnnonce.get(position).getSalaire()+" $");

      view.textViewId.setText(""+listeAnnonce.get(position).getId());
      view.textViewDiplome.setText("Diplome exigé : "+listeAnnonce.get(position).getDiplome().getDenomination());

        //view.textViewDiplome.setText(listeAnnonce.get(position).getDiplome.getIntitule());

        ((AnnonceViewHolder) holder).layout.setOnClickListener((View.OnClickListener) v ->
                listener.onClickAnnonceListener(listeAnnonce.get(position)));
    }

    @Override
    public int getItemCount() {

        return listeAnnonce.size();
    }
}
