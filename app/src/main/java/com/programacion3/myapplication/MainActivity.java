package com.programacion3.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (action != null &&
                action.equals(Intent.ACTION_SEND) &&
                type != null &&
                type.equals("text/plain")) {
            if (intent.hasExtra(Intent.EXTRA_TEXT)) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                Toast.makeText(this, sharedText, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mainMenuContactos: {
                Toast.makeText(this, "Contactos", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mainMenuLogout: {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mainMenuExit: {
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.buttonMainLayouts: {
                intent = new Intent(this, LayoutsActivity.class);
                break;
            }
            case R.id.buttonMainMarginPadding: {
                intent = new Intent(this, MarginPaddingActivity.class);
                break;
            }
            case R.id.buttonMainImage: {
                intent = new Intent(this, ImageActivity.class);
                break;
            }
            case R.id.buttonMainLifeCycle: {
                intent = new Intent(this, LifeCycleActivity.class);
                break;
            }
            case R.id.buttonMainLogin: {
                intent = new Intent(this, LoginActivity.class);
                break;
            }
            case R.id.buttonMainProgrammaticViews: {
                intent = new Intent(this, ProgrammaticViewsActivity.class);
                break;
            }
            case R.id.buttonMainWidgets: {
                intent = new Intent(this, WidgetsActivity.class);
                break;
            }
            case R.id.buttonMainList: {
                intent = new Intent(this, ListActivity.class);
                break;
            }
            case R.id.buttonMainRecycler: {
                intent = new Intent(this, RecyclerActivity.class);
                break;
            }
            case R.id.buttonMainNotifications: {
                intent = new Intent(this, NotificationsActivity.class);
                break;
            }
            case R.id.buttonMainPopupMenu: {
                PopupMenu popupMenu = new PopupMenu(this, view);
                popupMenu.inflate(R.menu.main_menu);
                popupMenu.show();
                break;
            }
            default: {
                intent = new Intent(this, LayoutsActivity.class);
                break;
            }
        }

        if (intent != null) {
            startActivity(intent);
        }

    }

    public void onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "CLICK EN POPUP", Toast.LENGTH_SHORT).show();
    }
}













