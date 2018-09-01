package udi.agenda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import udi.agenda.Interface.RecyclerView_ClickListener;

public class MainActivity extends AppCompatActivity implements RecyclerView_ClickListener {

    private RecyclerView DetalleAgendaRV;
    private Adapter_RecyclerView adapterAgenda;
    private List<ClsAgenda> listaAgenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        this.CreateDataAgenda();
        this.LoadRecyclerView();
        Toast.makeText(this, "On Create", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_LONG).show();
    }

    private void CreateDataAgenda(){
        listaAgenda =  new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaAgenda.add(new ClsAgenda("Tarea "+i ,"Task "+i+" muy importante no olvidar",  "28/0"+i+"/2018"));
        }
    }
    private void LoadRecyclerView(){
        DetalleAgendaRV = (RecyclerView)findViewById(R.id.rvDetalleAgenda);
        DetalleAgendaRV.setLayoutManager(new LinearLayoutManager(this));
        adapterAgenda =  new Adapter_RecyclerView(this,listaAgenda);
        DetalleAgendaRV.setAdapter(adapterAgenda);
        adapterAgenda.setClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view, int position) {

    }
}
