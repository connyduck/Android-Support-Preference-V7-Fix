package com.takisoft.fix.support.v7.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceDialogFragmentCompat;

import com.android.colorpicker.ColorPickerDialog;
import com.android.colorpicker.ColorPickerSwatch;

public class ColorPickerPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat implements ColorPickerSwatch.OnColorSelectedListener {

    private int pickedColor;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ColorPickerPreference pref = getColorPickerPreference();

        ColorPickerDialog.Params params = new ColorPickerDialog.Params.Builder()
                .setSelectedColor(pref.getColor())
                .setColors(pref.getColors())
                .setColorContentDescriptions(pref.getColorDescriptions())
                .setSize(pref.getSize())
                .setColumns(pref.getColumns())
                .build();

        ColorPickerDialog dialog = new ColorPickerDialog(getActivity(), this, params);
        dialog.setTitle(pref.getDialogTitle());

        return dialog;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        super.onClick(dialog, which);

        if (which == DialogInterface.BUTTON_POSITIVE) {
            //((DatePickerDialog) getDialog()).onClick(dialog, which);
        }
    }

    @Override
    public void onDialogClosed(boolean positiveResult) {
        ColorPickerPreference preference = getColorPickerPreference();

        if (positiveResult) {
            preference.setColor(pickedColor);
        }
    }

    @Override
    public void onColorSelected(int color) {
        this.pickedColor = color;

        super.onClick(getDialog(), DialogInterface.BUTTON_POSITIVE);
    }

    ColorPickerPreference getColorPickerPreference() {
        return (ColorPickerPreference) getPreference();
    }
}
