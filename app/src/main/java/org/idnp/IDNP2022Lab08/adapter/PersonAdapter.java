package org.idnp.IDNP2022Lab08.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.idnp.IDNP2022Lab08.R;
import org.idnp.IDNP2022Lab08.entity.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private List<Person> persons;

    public PersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_postulante, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.getTxtId().setText(String.valueOf(person.getId()));
        holder.getTxtFirstname().setText(person.getFirstname());
        holder.getTxtLastname().setText(person.getLastname());
        holder.getTxtSchool().setText(person.getSchool());
        holder.getTxtProgram().setText(person.getProgram());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
