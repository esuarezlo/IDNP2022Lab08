package org.idnp.IDNP2022Lab08.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.idnp.IDNP2022Lab08.R;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private final TextView txtId;
    private final TextView txtFirstname;
    private final TextView txtLastname;
    private final TextView txtSchool;
    private final TextView txtProgram;

    public PersonViewHolder(View view) {
        super(view);

        txtId = (TextView) view.findViewById(R.id.txtId);
        txtFirstname = (TextView) view.findViewById(R.id.txtFirstname);
        txtLastname = (TextView) view.findViewById(R.id.txtLastname);
        txtSchool = (TextView) view.findViewById(R.id.txtSchool);
        txtProgram = (TextView) view.findViewById(R.id.txtProgram);
    }

    public TextView getTxtId() {
        return txtId;
    }

    public TextView getTxtFirstname() {
        return txtFirstname;
    }

    public TextView getTxtLastname() {
        return txtLastname;
    }

    public TextView getTxtSchool() {
        return txtSchool;
    }

    public TextView getTxtProgram() {
        return txtProgram;
    }
}