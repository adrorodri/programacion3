package com.programacion3.myapplication.UI.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programacion3.myapplication.Model.Person;
import com.programacion3.myapplication.R;

import java.util.List;

/**
 * Created by adro_ on 4/19/2018.
 */

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.PersonViewHolder> {

    Context context;
    List<Person> personList;
    LayoutInflater inflater;

    public PersonRecyclerAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayout = inflater.inflate(R.layout.layout_list_person_item, null);
        return new PersonViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.textViewNombre.setText(personList.get(position).getNombre());
        holder.textViewApellido.setText(personList.get(position).getApellido());
        holder.textViewCodigoUpb.setText(String.valueOf(personList.get(position).getCodigoUpb()));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNombre;
        TextView textViewApellido;
        TextView textViewCodigoUpb;
        public PersonViewHolder(View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewApellido = itemView.findViewById(R.id.textViewApellido);
            textViewCodigoUpb = itemView.findViewById(R.id.textViewCodigoUpb);
        }
    }
}
