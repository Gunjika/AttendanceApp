package gunjika.varshney.gla.attendanceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Wifi_activity extends AppCompatActivity {
    Button btnonoff,btnDiscover,logout;
    WifiManager wifiManager;
    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_activity);
        btnonoff=findViewById(R.id.button10);
        btnDiscover=findViewById(R.id.button2);
        logout=findViewById(R.id.button4);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth = FirebaseAuth.getInstance();
                fAuth.signOut();
                Intent logoutIntent=new Intent(Wifi_activity.this,MainActivity.class);
                startActivity(logoutIntent);
            }
        });
        initialwork();
        exqListener();
    }

    private void exqListener() {
        btnonoff=findViewById(R.id.button10);
        btnDiscover=findViewById(R.id.button2);
        btnonoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifiManager.isWifiEnabled())
                {
                    wifiManager.setWifiEnabled(false);
                    btnonoff.setText("ON");
                }
                else {
                    wifiManager.setWifiEnabled(true);
                    btnonoff.setText("OFF");
                }
            }
        });
        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
                    @Override
                    public void onSuccess() {
                        Intent disIntent=new Intent(Wifi_activity.this,thirdActivity.class);
                        startActivity(disIntent);
                    }

                    @Override
                    public void onFailure(int reason) {

                    }
                });
            }
        });
    }

    private void initialwork() {
        btnonoff=findViewById(R.id.button9);
        btnDiscover=findViewById(R.id.button2);
        wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mManager= (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel=mManager.initialize(this,getMainLooper(),null);
        mReceiver=new WifiDirectBroadcastRecevier(mManager,mChannel,this);
        mIntentFilter=new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver,mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}
