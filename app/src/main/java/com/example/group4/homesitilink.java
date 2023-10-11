package com.example.group4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
public class homesitilink extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView user,tic,route,loc,fb,map;
    FirebaseAuth hsAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homesitilink);
        user=findViewById(R.id.user);
        tic=findViewById(R.id.ticket);
        route=findViewById(R.id.route);
        loc=findViewById(R.id.location);
        fb=findViewById(R.id.feedback);
        map=findViewById(R.id.map);
        hsAuth=FirebaseAuth.getInstance();
        user.setOnClickListener(view -> {
            Intent intent=new Intent(homesitilink.this, user.class);
            startActivity(intent);
        });

        tic.setOnClickListener(view -> {
            Intent intent=new Intent(homesitilink.this,ticket.class);
            startActivity(intent);
        });

        route.setOnClickListener(view -> {
            Intent intent=new Intent(homesitilink.this,route.class);
            startActivity(intent);
        });

        loc.setOnClickListener(view -> {
            Intent intent=new Intent(homesitilink.this,loc.class);
            startActivity(intent);
        });

        fb.setOnClickListener(view -> {
            Intent intent=new Intent(homesitilink.this,feedback.class);
            startActivity(intent);
        });

        map.setOnClickListener(view -> {
            Intent intent=new Intent(homesitilink.this, map.class);
            startActivity(intent);
        });

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.naview);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.naview:
                break;
            case R.id.favtrip:
                Intent intent = new Intent(homesitilink.this, favtrip.class);
                startActivity(intent);
                break;
            case R.id.eml:
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"joinyour4122733@gmail.com"});
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, new String[]{"help and support"});
                sendIntent.putExtra(Intent.EXTRA_TEXT, new String[]{});
                sendIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(sendIntent, "Choose an Email client :"));
                break;
            case R.id.share:
                Intent shareIntent=new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=sitilink");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent,"sharevia"));
                Toast.makeText(this, "Sharing..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                AlertDialog.Builder alert = new AlertDialog.Builder(homesitilink.this);
                alert.setMessage("Do you really want to logout?");
                alert.setCancelable(true)
                        .setPositiveButton("Logout", (dialogInterface, i1) ->
                        {
                            hsAuth.signOut();
                            logout();
                        })
                        .setNegativeButton("Cancel", (dialogInterface, i12) -> dialogInterface.cancel());
                AlertDialog alertDialog=alert.create();
                alertDialog.show();
        }
        return true;
    }
    private void logout()
    {
        Intent i=new Intent(homesitilink.this,login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
}