package com.example.group4;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class route extends AppCompatActivity
{
    ListView listView;
    String[] busnum ={"01","02","11","12","13","14","15","16","17AE","17","18","19","20","21","22","102","103K","103S","103V", "104",
            "105","106","107","108","112","116","117","118","126","127","136","137","147","153","202","204","205G","205K", "206","207",
            "209","212","213","216B","216K","217","226","254","305","315","402","403","410","504","506","658","706","716","903"};
    String[] buspath ={"ADAJAN G.S.R.T.C - RAILWAY STATION TERMINAL - ADAJAN G.S.R.T.C (CLOCKWISE)",
            "ADAJAN G.S.R.T.C - RAILWAY STATION TERMINAL - ADAJAN G.S.R.T.C (ANTICLOCKWISE)",
            "UDHANA DARWAJA BRTS - SACHIN GIDC JUNCTION BRTS",
            "ONGC COLONY BRTS - SARTHANA NATURE PARK BRTS",
            "JAHANGIRPURA COMMUNITY HALL BRTS - KADODARA",
            "ONGC COLONY BRTS - KOSAD EWS H2 BRTS",
            "SOMESHWAR JUNCTION BRTS - AMAZIA AMUSEMENT PARK BRTS - SOMESHWAR JUNCTION BRTS",
            "KOSAD DEPORT BRTS - DINDOLI VARIGHUH BRTS",
            "SACHIN RAILWAY STATION - KAMREJ TERMINAL BRTS",
            "KAMREJ TERMINAL BRTS - PAL R.T.O. BRTS",
            "RAILWAY STATION TERMINAL - UTRAN R.O.B. BRIDGE BRTS",
            "RAILWAY STATION TERMINAL - KADODARA",
            "KOSAD EWS H2 BRTS - KHARAWARNAGAR BRTS",
            "JAHANGIRPURA COMMUNITY HALL BRTS - PANDESARA G.I.D.C BRTS",
            "KOSAD EWS H2 BRTS - SARTHANA NATURE PARK BRTS",
            "RAILWAY STATION TERMINAL - VED GAM",
            "KATHOR GAM - RAILWAY STATION",
            "RAILWAY STATION EAST - SHEKHPUR GAAM",
            "VELANJA GAM - RAILWAY STATION",
            "RAILWAY STATION TERMINAL - DINDOLI GAM",
            "RAILWAY STATION TERMINAL - PANDESARA HOUSING",
            "RAILWAY STATION TERMINAL - ABHVA GAM",
            "RAILWAY STATION TERMINAL - VIVEKANAND COLLEGE",
            "OLPAD - RAILWAY STATION TERMINAL",
            "RAILWAY STATION TERMINAL - BHARTHANA (KOSAD GAM)",
            "RAILWAY STATION TERMINAL - KHAJOD GAM",
            "RAILWAY STATION TERMINAL - PALANPUR GAM",
            "RAILWAY STATION TERMINAL - SAYAN",
            "RAILWAY STATION TERMINAL - V.N.S.G.U BRTS",
            "RAILWAY STATION TERMINAL - RANDER GAM",
            "RAILWAY STATION TERMINAL - SURAT AIRPORT",
            "RAILWAY STATION TERMINAL - VARIAV GAM",
            "RAILWAY STATION EAST - GREEN CITY BHATHA",
            "UMRA GAM - KAPODARA",
            "CHOWK TERMINAL - GODADARA GAM",
            "CHOWK TERMINAL - GABHENI GAM",
            "CHOWK TERMINAL - GABHENI GAM",
            "LAJPOR JAIL - CHOWK TERMINAL",
            "CHOWK TERMINAL - DUMAS LANGAR (VIA C.K.PIYJWALA ENG. COLLEGE)",
            "CHOWK TERMINAL - VAISHNODEVI TOWNSHIP",
            "DABHOLI - DINDOLI GAM",
            "CHOWK TERMINAL - VARIAV GAM",
            "DABHOLI GAM - SARTHANA NAKA",
            "CHOWK TERMINAL - BHIMPORE",
            "CHOWK TERMINAL - KAADIFALIYA DUMAS",
            "MAKKAI POOL - BHESAN COLLEGE",
            "KOSAD GAM - V.N.S.G.U BRTS",
            "SUMAN DARSHAN - LIMBAYAT",
            "KHARVARNAGAR BRTS - UNN INDUSTRIAL ESTATE BRTS",
            "KHARVARNAGAR BRTS - BHESTAN GARDEN",
            "PUNA CANAL BRTS - UTRAN RAILWAY STATION",
            "SARTHANA NATURE PARK BRTS - PUNA CANAL ROAD",
            "MOTA VARACHHA - MINIBAZAAR LOOP",
            "AMAZIA AMUSEMENT PARK BRTS - BHESTAN GARDEN",
            "DINDOLI - V.N.S.G.U. BRTS",
            "ADAJAN G.S.R.T.C - MORA",
            "ISCON CIRCLE - V.N.S.G.U. BRTS",
            "JAHANGIRPURA - GAIL COLONY VESU",
            "PASODARA - BALAJI CHOWK PUNA"};
    int[] image ={R.drawable.ic_bus_green,
            R.drawable.ic_bus_green,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_red,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue,
            R.drawable.ic_bus_blue};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        listView=findViewById(R.id.busmain);
        MyAdapter adapter=new MyAdapter(this,busnum,buspath,image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){startActivity(new Intent(route.this,zeroone.class));}
                else if(i==1) { startActivity(new Intent(route.this,zerotwo.class)); }
                else if(i==2) { startActivity(new Intent(route.this,oneone.class)); }
                else if(i==3) { startActivity(new Intent(route.this,onetwo.class)); }
                else if(i==4) { startActivity(new Intent(route.this,onethree.class)); }
                else if(i==5) { startActivity(new Intent(route.this,onefour.class)); }
                else if(i==6) { startActivity(new Intent(route.this,onefive.class)); }
                else if(i==7) { startActivity(new Intent(route.this,onesix.class)); }
                else if(i==8) { startActivity(new Intent(route.this,onesevenae.class)); }
                else if(i==9) { startActivity(new Intent(route.this,oneseven.class)); }
                else if(i==10) { startActivity(new Intent(route.this,oneeight.class)); }
                else if(i==11) { startActivity(new Intent(route.this,onenine.class)); }
                else if(i==12) { startActivity(new Intent(route.this,twozero.class)); }
                else if(i==13) { startActivity(new Intent(route.this,twoone.class)); }
                else if(i==14) { startActivity(new Intent(route.this,zerotwo.class)); }
                else if(i==15) { startActivity(new Intent(route.this,onezerotwo.class)); }
                else if(i==16) { startActivity(new Intent(route.this,onezerothreek.class)); }
                else if(i==17) { startActivity(new Intent(route.this,onezerothrees.class)); }
                else if(i==18) { startActivity(new Intent(route.this,onezerothreev.class)); }
                else if(i==19) { startActivity(new Intent(route.this,onezerofour.class)); }
                else if(i==20) { startActivity(new Intent(route.this,onezerofive.class)); }
                else if(i==21) { startActivity(new Intent(route.this,onezerosix.class)); }
                else if(i==22) { startActivity(new Intent(route.this,onezeroseven.class)); }
                else if(i==23) { startActivity(new Intent(route.this,onezeroeight.class)); }
                else if(i==24) { startActivity(new Intent(route.this,oneonetwo.class)); }
                else if(i==25) { startActivity(new Intent(route.this,oneonesix.class)); }
                else if(i==26) { startActivity(new Intent(route.this,oneoneseven.class)); }
                else if(i==27) { startActivity(new Intent(route.this,oneoneeight.class)); }
                else if(i==28) { startActivity(new Intent(route.this,onetwosix.class)); }
                else if(i==29) { startActivity(new Intent(route.this,onetwoseven.class)); }
                else if(i==30) { startActivity(new Intent(route.this,onethreesix.class)); }
                else if(i==31) { startActivity(new Intent(route.this,onethreeseven.class)); }
                else if(i==32) { startActivity(new Intent(route.this,onefourseven.class)); }
                else if(i==33) { startActivity(new Intent(route.this,onefivethree.class)); }
                else if(i==34) { startActivity(new Intent(route.this,twozerotwo.class)); }
                else if(i==35) { startActivity(new Intent(route.this,twozerofour.class)); }
                else if(i==36) { startActivity(new Intent(route.this,twozerofiveg.class)); }
                else if(i==37) { startActivity(new Intent(route.this,twozerofivek.class)); }
                else if(i==38) { startActivity(new Intent(route.this,twozerosix.class)); }
                else if(i==39) { startActivity(new Intent(route.this,twozeroseven.class)); }
                else if(i==40) { startActivity(new Intent(route.this,twozeronine.class)); }
                else if(i==41) { startActivity(new Intent(route.this,twoonetwo.class)); }
                else if(i==42) { startActivity(new Intent(route.this,twoonethree.class)); }
                else if(i==43) { startActivity(new Intent(route.this,twoonesixb.class)); }
                else if(i==44) { startActivity(new Intent(route.this,twoonesixk.class)); }
                else if(i==45) { startActivity(new Intent(route.this,twooneseven.class)); }
                else if(i==46) { startActivity(new Intent(route.this,twotwosix.class)); }
                else if(i==47) { startActivity(new Intent(route.this,twofivefour.class)); }
                else if(i==48) { startActivity(new Intent(route.this,threezerofive.class)); }
                else if(i==49) { startActivity(new Intent(route.this,threeonefive.class)); }
                else if(i==50) { startActivity(new Intent(route.this,fourzerotwo.class)); }
                else if(i==51) { startActivity(new Intent(route.this,fourzerothree.class)); }
                else if(i==52) { startActivity(new Intent(route.this,fouronezero.class)); }
                else if(i==53) { startActivity(new Intent(route.this,fivezerofour.class)); }
                else if(i==54) { startActivity(new Intent(route.this,fivezerosix.class)); }
                else if(i==55) { startActivity(new Intent(route.this,sixfiveeight.class)); }
                else if(i==56) { startActivity(new Intent(route.this,sevenzerosix.class)); }
                else if(i==57) { startActivity(new Intent(route.this,sevenonesix.class)); }
                else if(i==58) { startActivity(new Intent(route.this,ninezerothree.class)); }
                else { Toast.makeText(route.this, "tap again !", Toast.LENGTH_SHORT).show(); }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String[] dbusnum;
        String[] dbuspath;
        int[] dimage;
        MyAdapter (Context c, String[] num, String[] path, int[] img)
        {
            super(c,R.layout.list_items,R.id.busnum,num);
            this.context=c;
            this.dbusnum=num;
            this.dbuspath=path;
            this.dimage=img;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row=layoutInflater.inflate(R.layout.list_items,parent,false);
            ImageView imageView=row.findViewById(R.id.buscol);
            TextView textView=row.findViewById(R.id.busnum);
            TextView textView1=row.findViewById(R.id.buspath);

            imageView.setImageResource(dimage[position]);
            textView.setText(dbusnum[position]);
            textView1.setText(dbuspath[position]);
            return row;
        }
    }
}
