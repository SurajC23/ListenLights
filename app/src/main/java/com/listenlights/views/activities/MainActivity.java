package com.listenlights.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.listenlights.R;
import com.listenlights.views.fragments.BinToBinFragment;
import com.listenlights.views.fragments.DPRFragment;
import com.listenlights.views.fragments.GRPOFragment;
import com.listenlights.views.fragments.PRFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvPR, tvGRPO, tvBinToBin, tvDPR;
    RelativeLayout rlPR, rlGRPO, rlBinToBin, rlDPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        callFragment(new PRFragment());
        setTextVisibility();
    }

    private void initViews() {
        tvPR = findViewById(R.id.tvPR);
        tvGRPO = findViewById(R.id.tvGRPO);
        tvBinToBin = findViewById(R.id.tvBinToBin);
        tvDPR = findViewById(R.id.tvDPR);

        rlPR = findViewById(R.id.rlPR);
        rlGRPO = findViewById(R.id.rlGRPO);
        rlBinToBin = findViewById(R.id.rlBinToBin);
        rlDPR = findViewById(R.id.rlDPR);

        tvPR.setOnClickListener(this);
        tvGRPO.setOnClickListener(this);
        tvBinToBin.setOnClickListener(this);
        tvDPR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvPR:
                rlPR.setVisibility(View.VISIBLE);
                rlGRPO.setVisibility(View.GONE);
                rlBinToBin.setVisibility(View.GONE);
                rlDPR.setVisibility(View.GONE);
                callFragment(new PRFragment());
                break;

            case R.id.tvGRPO:
                rlPR.setVisibility(View.GONE);
                rlGRPO.setVisibility(View.VISIBLE);
                rlBinToBin.setVisibility(View.GONE);
                rlDPR.setVisibility(View.GONE);
                callFragment(new GRPOFragment());
                break;

            case R.id.tvBinToBin:
                rlPR.setVisibility(View.GONE);
                rlGRPO.setVisibility(View.GONE);
                rlBinToBin.setVisibility(View.VISIBLE);
                rlDPR.setVisibility(View.GONE);
                callFragment(new BinToBinFragment());
                break;

            case R.id.tvDPR:
                rlPR.setVisibility(View.GONE);
                rlGRPO.setVisibility(View.GONE);
                rlBinToBin.setVisibility(View.GONE);
                rlDPR.setVisibility(View.VISIBLE);
                callFragment(new DPRFragment());
                break;
        }
    }

    private void callFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flMain, fragment).commit();
    }

    private void setTextVisibility() {
        rlPR.setVisibility(View.VISIBLE);
        rlGRPO.setVisibility(View.GONE);
        rlBinToBin.setVisibility(View.GONE);
        rlDPR.setVisibility(View.GONE);
    }
}