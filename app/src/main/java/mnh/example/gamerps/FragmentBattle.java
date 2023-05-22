package mnh.example.gamerps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentBattle extends Fragment {

    private View layout;
    private ImageView tanganLawan;
    private ImageView tanganPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.fragment_battle, null, false);
        this.tanganLawan = this.layout.findViewById(R.id.ivBattleLawan);
        this.tanganPlayer = this.layout.findViewById(R.id.ivBattlePlayer);
        return this.layout;
    }

    public void suiiittt(int tanganPlayer,int tanganLawan){
        this.tanganLawan.setImageResource(icon((tanganLawan)));
        this.tanganPlayer.setImageResource(icon((tanganPlayer)));

        if (tanganLawan==tanganPlayer){
            Toast.makeText(this.getActivity(), "seri", Toast.LENGTH_SHORT).show();
        }//draw
        if(tanganPlayer-tanganLawan == 1){
            Toast.makeText(this.getActivity(), "menang", Toast.LENGTH_SHORT).show();
        }//win
        else {
            Toast.makeText(this.getActivity(), "kalah", Toast.LENGTH_SHORT).show();
        }//lose
    }

    private int icon (int tangan){
        if (tangan == 0) return  R.drawable.rock;
        if (tangan == 1) return  R.drawable.paper;
        return  R.drawable.scissor;
    }

}
