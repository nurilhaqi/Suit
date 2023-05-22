package mnh.example.gamerps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IHost{

    private FragmentManager fm;
    private FragmentLawan fl;
    private FragmentBattle fb;
    private FragmentPlayer fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fm = getSupportFragmentManager();
        this.fl = new FragmentLawan();
        this.fb = new FragmentBattle();
        this.fp = new FragmentPlayer();

        this.fp.setHost(this);

        this.fm.beginTransaction()
                .add(R.id.frameLawan, this.fl, "FLAWAN")
                .add(R.id.frameBattle, this.fb, "FBATTLE")
                .add(R.id.framePlayer, this.fp, "FPLAYER")
                .commit();
    }

    @Override
    public void suit(int tanganPlayer) {
        FragmentLawan fl = (FragmentLawan) getSupportFragmentManager().findFragmentByTag("FLAWAN");
        int tanganLawan = fl.getTangan();

        FragmentBattle fb = (FragmentBattle) getSupportFragmentManager().findFragmentByTag("FBATTLE");

        fb.suiiittt(tanganPlayer, tanganLawan);
    }
}