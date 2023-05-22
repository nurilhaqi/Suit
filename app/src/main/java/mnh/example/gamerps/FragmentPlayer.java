package mnh.example.gamerps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPlayer extends Fragment implements View.OnClickListener {

    private View layout;
    private IHost host;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.fragment_player, null, false);
        this.layout.findViewById(R.id.ivPlayerRock).setOnClickListener(this);
        this.layout.findViewById(R.id.ivPlayerPaper).setOnClickListener(this);
        this.layout.findViewById(R.id.ivPlayerScrissor).setOnClickListener(this);

        return this.layout;
    }

    public void setHost(IHost activity){
        this.host = activity;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id==R.id.ivPlayerRock)
            this.host.suit(0);
        if (id==R.id.ivPlayerPaper)
            this.host.suit(1);
        if (id==R.id.ivPlayerScrissor)
            this.host.suit(2);
    }
}
