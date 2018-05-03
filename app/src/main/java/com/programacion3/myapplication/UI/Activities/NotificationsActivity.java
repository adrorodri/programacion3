package com.programacion3.myapplication.UI.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion3.myapplication.R;

public class NotificationsActivity extends AppCompatActivity {

    private static String CHANNEL_ID = "891723891728";
    private static int NOTIFICATION_ID = 120;

    private View parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        parentView = findViewById(R.id.parentView);
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonToast: {
                Toast.makeText(this, "Este es un Toast!", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.buttonCustomToast: {
                View layout = getLayoutInflater().inflate(R.layout.layout_toast_custom, null);

                TextView textView = layout.findViewById(R.id.textViewToast);
                textView.setText("HOLA DESDE CUSTOM TOAST!");

                Toast toast = new Toast(this);
                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

                break;
            }
            case R.id.buttonDialog: {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("TITULO!");
                builder.setMessage("MESSAGE!");
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(NotificationsActivity.this, "Este es un Toast!", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                break;
            }
            case R.id.buttonCustomDialog: {

                View layout = getLayoutInflater().inflate(R.layout.layout_toast_custom, null);

                TextView textView = layout.findViewById(R.id.textViewToast);
                textView.setText("HOLA DESDE CUSTOM TOAST!");

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("TITULO!");
                builder.setView(layout);
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(NotificationsActivity.this, "Este es un Toast!", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                break;
            }
            case R.id.buttonPopup: {
                break;
            }
            case R.id.buttonSnackbar: {
                Snackbar.make(parentView, "This is a Snackbar!", Snackbar.LENGTH_LONG).show();
                break;
            }
            case R.id.buttonNotification: {

                NotificationCompat.Builder notificationCompatBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
                notificationCompatBuilder.setContentTitle("TITULO NOTIFICACION");
                notificationCompatBuilder.setContentText("CONTENIDO");
                notificationCompatBuilder.setSmallIcon(R.drawable.notification);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
                notificationManagerCompat.notify(NOTIFICATION_ID, notificationCompatBuilder.build());

                break;
            }
            default: {
                break;
            }
        }
    }
}













