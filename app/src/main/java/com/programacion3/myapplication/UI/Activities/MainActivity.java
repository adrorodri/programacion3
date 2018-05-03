package com.programacion3.myapplication.UI.Activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.programacion3.myapplication.R;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    // Request code for permissions (Can be any value lower than 16 bits)
    private static final int RC_CAMERA_AND_LOCATION = 123;

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

        // Request all permissions that our app will use
        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        EasyPermissions.requestPermissions(
                new PermissionRequest.Builder(this, RC_CAMERA_AND_LOCATION, perms)
                        .build());
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
            case R.id.buttonMainStorage: {
                intent = new Intent(this, StorageActivity.class);
                break;
            }
            case R.id.buttonMainDatabase: {
                intent = new Intent(this, DBActivity.class);
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

    // Method called when permissions are resolved (accepted or denied) from the dialog
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "PERMISOS ACEPTADOS!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "PERMISOS RECHAZADOS!", Toast.LENGTH_SHORT).show();
        // Close the app, as we don't have permissions to use it. App may crash!
        finish();
    }
}













