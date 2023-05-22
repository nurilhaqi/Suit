package mnh.example.gamerps;

import static java.lang.Thread.sleep;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLawan extends Fragment {

    private View layout;
    private ImageView ivLawan;
    private int tangan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.fragment_lawan, null, false);
        this.ivLawan = this.layout.findViewById(R.id.ivLawan);

        return this.layout;
    }

    public int getTangan(){
        return this.tangan;
    }

    @Override
    public void onResume() {
        super.onResume();

        Handler h = new Handler();
        Thread t = new Thread(()->{
            //kode dibawah ini akan run di bg
            while (true) {
                int tanganLawan = (int) (Math.random() * 3);
                try {
                    //lapor ke UI thread
                    h.post(()->{
                        //kode di bawah ini run di UI thread
                        if (tanganLawan ==0)
                            this.ivLawan.setImageResource(R.drawable.rock);
                        else if (tanganLawan ==1)
                            this.ivLawan.setImageResource(R.drawable.paper);
                        else this.ivLawan.setImageResource(R.drawable.scissor);
                        this.tangan = tanganLawan;
                    });
                    sleep(30);
                }catch (Exception e){break;}
            }
        });
        t.start();
    }
}
