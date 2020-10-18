package com.example.assignment3_cmpt276_fall2020;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * MessageFragment class represents the congratulation dialog that pops up after the user
 * finishes the game, on the positive button press advances back to the menu activity.
 * Contains two images and congratulation text.
 */
public class MessageFragment extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Create the view to show
        View v  = LayoutInflater.from(getActivity())
                .inflate(R.layout.alert_layout, null);
        //Create button listener
        DialogInterface.OnClickListener listener = (dialog, which) -> {
            Intent intent = new Intent(getActivity(), MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        };

        //Build the alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("Game Over")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();
    }
}
